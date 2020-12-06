@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter")

package com.chrynan.presentation

import com.chrynan.dispatchers.CoroutineDispatchers
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

/**
 * A base implementation of the [Presenter] interface that provides functions for handling common functionality, such
 * as, the [reduceAndRender] function.
 */
abstract class BasePresenter<I : Intent, S : State, C : Change>(
    protected val initialState: S,
    protected val dispatchers: CoroutineDispatchers
) : Presenter<I, S, C>,
    PresenterCoroutineScope {

    override var currentState: S = initialState
        protected set

    override val coroutineContext: CoroutineContext
        get() = job + dispatchers.main

    override var isBound = false
        internal set

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
            .flatMapLatest { action(it, currentState) }
            .flowOn(dispatchers.io)

    /**
     * Converts this [Flow] of [Intent]s of type [I] into a [Flow] of [Change]s of type [C] using the provided [action]
     * function.
     */
    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    protected fun Flow<I>.perform(action: (I, S) -> Flow<C>): Flow<C> =
        flowOn(dispatchers.main)
            .flatMapLatest { action(it, currentState) }
            .flowOn(dispatchers.io)

    /**
     * Converts this [Flow] of [Change]s of type [C] into a [Flow] of type [S] using this [Presenter]s [Reducer].
     */
    protected fun Flow<C>.reduce(): Flow<S> =
        map { reducer(currentState, it) }
            .flowOn(dispatchers.io)

    /**
     * Renders the [State]s of type [S] from this [Flow] with this [Presenter]s [View].
     */
    protected fun Flow<S>.render(): Flow<S> =
        onEach { currentState = it }
            .onEach { view.render(it) }
            .flowOn(dispatchers.main)

    /**
     * Performs the provided [action], then Reduces the [Change]s of type [C] from this [Flow] and returns a [Flow] of
     * the new [State]s of type [S]. This is a convenience function for calling the [perform] function followed by the
     * [reduce] function.
     */
    protected fun Flow<I>.performAndReduce(action: Action<I, S, C>): Flow<S> =
        perform(action).reduce()

    /**
     * Performs the provided [action], then Reduces the [Change]s of type [C] from this [Flow] and returns a [Flow] of
     * the new [State]s of type [S]. This is a convenience function for calling the [perform] function followed by the
     * [reduce] function.
     */
    protected fun Flow<I>.performAndReduce(action: (I, S) -> Flow<C>): Flow<S> =
        perform(action).reduce()

    /**
     * Reduces and renders the [Change]s of type [C] from this [Flow] and returns a [Flow] of the new [State]s of type
     * [S]. This is a convenience function for calling the [reduce] function followed by the [render] function.
     */
    protected fun Flow<C>.reduceAndRender(): Flow<S> = reduce().render()

    /**
     * Performs the provided [action], then Reduces and renders the [Change]s of type [C] from this [Flow] and returns
     * a [Flow] of the new [State]s of type [S]. This is a convenience function for calling the [perform] function
     * followed by the [reduce] and [render] functions.
     */
    protected fun Flow<I>.performAndReduceAndRender(action: Action<I, S, C>): Flow<S> =
        perform(action).reduce().render()

    /**
     * Performs the provided [action], then Reduces and renders the [Change]s of type [C] from this [Flow] and returns
     * a [Flow] of the new [State]s of type [S]. This is a convenience function for calling the [perform] function
     * followed by the [reduce] and [render] functions.
     */
    protected fun Flow<I>.performAndReduceAndRender(action: (I, S) -> Flow<C>): Flow<S> =
        perform(action).reduce().render()
}
