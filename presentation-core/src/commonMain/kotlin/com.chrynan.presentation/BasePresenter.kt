@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter")

package com.chrynan.presentation

import com.chrynan.dispatchers.CoroutineDispatchers
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

/**
 * A base implementation of the [Presenter] interface that provides functions for handling common
 * functionality, such as, the [performWith], [reduceWith], and [render] functions.
 */
abstract class BasePresenter<I : Intent, S : State, C : Change>(
    protected val initialState: S? = null,
    protected val dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers
) : ViewModel(),
    Presenter<I, S, C> {

    override val currentState: S?
        get() = stateStore.currentState

    override val renderStates: Flow<S>
        get() = stateStore.states.filterNotNull()

    override val coroutineScope: CoroutineScope = object : CoroutineScope {

        override val coroutineContext: CoroutineContext
            get() = job + dispatchers.main
    }

    override var isBound = false
        internal set

    protected open val stateStore: StateStore<I, C, S> = BasicStateStore(initialState)

    private lateinit var job: Job

    /**
     * Binds this [Presenter].
     *
     * Prefer overriding the [onBind] function for setup logic.
     */
    override fun bind() {
        if (!isBound) {
            job = SupervisorJob()
            isBound = true
            onBind()
        }
    }

    /**
     * Unbinds this [Presenter].
     *
     * Prefer overriding the [onUnbind] function for cleanup logic.
     */
    override fun unbind() {
        if (isBound) {
            onUnbind()
            job.cancel()
            isBound = false
        }
    }

    /**
     * This function will be invoked when this Presenters [bind] function is called when this
     * Presenter is not already bound.
     *
     * This is a good place to setup any resources or calls. Typically, the MVI pattern flow is
     * setup here by listening to [Intent]s emitted by the [View].
     */
    protected open fun onBind() {}

    /**
     * This function will be invoked when this Presenters [unbind] function is called when this
     * Presenter is bound.
     *
     * This is a good place to clear up any resources. Note that this function will be invoked
     * before the [coroutineScope] is cancelled.
     */
    protected open fun onUnbind() {}

    /**
     * Converts this [Flow] of [Intent]s of type [I] into a [Flow] of [Change]s of type [C] using the provided [action].
     */
    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    protected open fun Flow<I>.performWith(action: Action<I, S, C>): Flow<C> =
        flowOn(dispatchers.main)
            .onEach { stateStore.updateLastIntent(it) }
            .flatMapLatest { action(it, currentState) }
            .flowOn(dispatchers.io)

    /**
     * Converts this [Flow] of [Intent]s of type [I] into a [Flow] of [Change]s of type [C] using the provided [action]
     * function.
     */
    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    protected open fun Flow<I>.perform(action: suspend (I, S?) -> Flow<C>): Flow<C> =
        flowOn(dispatchers.main)
            .onEach { stateStore.updateLastIntent(it) }
            .flatMapLatest { action(it, currentState) }
            .flowOn(dispatchers.io)

    /**
     * Converts this [Flow] of [Change]s of type [C] into a [Flow] of type [S] using this [Presenter]s [Reducer].
     */
    protected open fun Flow<C>.reduceWith(reducer: Reducer<S, C>): Flow<S> =
        onEach { stateStore.updateLastChange(it) }
            .map { reducer.invoke(currentState, it) }
            .flowOn(dispatchers.io)

    /**
     * Converts this [Flow] of [Change]s of type [C] into a [Flow] of type [S] using this [Presenter]s [Reducer].
     */
    protected open fun Flow<C>.reduce(reducer: suspend (S?, C) -> S): Flow<S> =
        onEach { stateStore.updateLastChange(it) }
            .map { reducer.invoke(currentState, it) }
            .flowOn(dispatchers.io)

    /**
     * Emits the [initialState] value in [onStart] if it is not null.
     */
    protected open fun Flow<S>.startWithInitialState(): Flow<S> =
        onStart {
            initialState?.let { emit(it) }
        }

    /**
     * Renders the [State]s of type [S] from this [Flow] with this [Presenter]s [View].
     */
    protected open fun Flow<S>.render(): Flow<S> =
        onEach { stateStore.updateCurrentState(it) }
            .flowOn(dispatchers.main)
}
