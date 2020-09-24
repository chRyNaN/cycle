@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter")

package com.chrynan.presentation

import com.chrynan.dispatchers.CoroutineDispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
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
     * Reduces and renders the [Change]s of type [C] from this [Flow] and returns a [Flow] of the new [State]s of type
     * [S]. This is a convenience function for calling the [reduce] function followed by the [render] function.
     */
    protected fun Flow<C>.reduceAndRender(): Flow<S> = reduce().render()
}
