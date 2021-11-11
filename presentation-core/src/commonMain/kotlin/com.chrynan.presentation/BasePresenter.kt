@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter")

package com.chrynan.presentation

import com.chrynan.dispatchers.CoroutineDispatchers
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

/**
 * A base implementation of the [Presenter] interface that provides functions for handling common
 * functionality, such as, the [perform], [reduce], and [render] functions.
 */
abstract class BasePresenter<I : Intent, S : State, C : Change>(
    protected val initialState: S? = null,
    protected val dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers
) : ViewModel(),
    Presenter<I, S, C> {

    override val currentState: S?
        get() = stateStore.currentState

    override val coroutineScope: CoroutineScope = object : CoroutineScope {

        override val coroutineContext: CoroutineContext
            get() = job + dispatchers.main
    }

    override var isBound = false
        internal set

    protected open val stateStore: StateStore<I, C, S> = BasicStateStore(initialState)

    private lateinit var job: Job

    override fun bind() {
        if (!isBound) onBind()
    }

    override fun unbind() {
        if (isBound) onUnbind()
    }

    protected open fun onBind() {
        job = SupervisorJob()
        isBound = true
    }

    protected open fun onUnbind() {
        job.cancel()
        isBound = false
    }

    /**
     * Converts this [Flow] of [Intent]s of type [I] into a [Flow] of [Change]s of type [C] using the provided [action].
     */
    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    protected fun Flow<I>.perform(action: Action<I, S, C>): Flow<C> =
        flowOn(dispatchers.main)
            .onEach { stateStore.updateLastIntent(it) }
            .flatMapLatest { action(it, currentState) }
            .flowOn(dispatchers.io)

    /**
     * Converts this [Flow] of [Intent]s of type [I] into a [Flow] of [Change]s of type [C] using the provided [action]
     * function.
     */
    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    protected fun Flow<I>.perform(action: (I, S?) -> Flow<C>): Flow<C> =
        flowOn(dispatchers.main)
            .onEach { stateStore.updateLastIntent(it) }
            .flatMapLatest { action(it, currentState) }
            .flowOn(dispatchers.io)

    /**
     * Converts this [Flow] of [Change]s of type [C] into a [Flow] of type [S] using this [Presenter]s [Reducer].
     */
    protected fun Flow<C>.reduce(reducer: Reducer<S, C>): Flow<S> =
        onEach { stateStore.updateLastChange(it) }
            .map { reducer.invoke(currentState, it) }
            .flowOn(dispatchers.io)

    /**
     * Converts this [Flow] of [Change]s of type [C] into a [Flow] of type [S] using this [Presenter]s [Reducer].
     */
    protected fun Flow<C>.reduce(reducer: (S?, C) -> S): Flow<S> =
        onEach { stateStore.updateLastChange(it) }
            .map { reducer.invoke(currentState, it) }
            .flowOn(dispatchers.io)

    /**
     * Emits the [initialState] value in [onStart] if it is not null.
     */
    protected fun Flow<S>.startWithInitialState(): Flow<S> =
        onStart {
            initialState?.let { emit(it) }
        }

    /**
     * Renders the [State]s of type [S] from this [Flow] with this [Presenter]s [View].
     */
    protected fun Flow<S>.render(): Flow<S> =
        onEach { stateStore.updateCurrentState(it) }
            .onEach { view.render(it) }
            .flowOn(dispatchers.main)
}
