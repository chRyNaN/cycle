package com.chrynan.presentation

import com.chrynan.dispatchers.CoroutineDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

/**
 * A convenience function to create a [Presenter] without having to directly create an implementation. This could be
 * especially useful for simple applications that don't have complex dependency management and testing requirements.
 *
 * Example usage:
 * ```kotlin
 * Presenter<I, S, C>(view = view) {
 *     this.view.intents()
 *         .perform { intent, state -> ... }
 *         .reduce { state, change -> ... }
 *         .startWithInitialState()
 *         .render()
 *         .launchIn(coroutineScope)
 * }
 * ```
 */
@Suppress("FunctionName")
fun <I : Intent, S : State, C : Change> Presenter(
    view: View<I, S>,
    initialState: S? = null,
    dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    onUnbind: (DelegatingPresenter<I, S, C>.() -> Unit)? = null,
    onBind: DelegatingPresenter<I, S, C>.() -> Unit
): DelegatingPresenter<I, S, C> = DelegatingPresenter(
    view = view,
    initialState = initialState,
    dispatchers = dispatchers,
    onUnbind = onUnbind,
    onBind = onBind
)

/**
 * An implementation of [BasePresenter] that delegates the provider properties to their corresponding [BasePresenter]
 * equivalents. This implementation also makes a lot of the protected [BasePresenter] functions public so that they can
 * be called in a scoped context.
 */
class DelegatingPresenter<I : Intent, S : State, C : Change> internal constructor(
    override val view: View<I, S>,
    initialState: S? = null,
    dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    private val onUnbind: (DelegatingPresenter<I, S, C>.() -> Unit)? = null,
    private val onBind: DelegatingPresenter<I, S, C>.() -> Unit
) : BasePresenter<I, S, C>(
    initialState = initialState,
    dispatchers = dispatchers
) {

    override fun onBind() {
        super.onBind()

        onBind(this)
    }

    override fun onUnbind() {
        super.onUnbind()

        onUnbind?.invoke(this)
    }

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    public override fun Flow<I>.performWith(action: Action<I, S, C>): Flow<C> =
        flowOn(dispatchers.main)
            .onEach { stateStore.updateLastIntent(it) }
            .flatMapLatest { action(it, currentState) }
            .flowOn(dispatchers.io)

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    public override fun Flow<I>.perform(action: suspend (I, S?) -> Flow<C>): Flow<C> =
        flowOn(dispatchers.main)
            .onEach { stateStore.updateLastIntent(it) }
            .flatMapLatest { action(it, currentState) }
            .flowOn(dispatchers.io)

    public override fun Flow<C>.reduceWith(reducer: Reducer<S, C>): Flow<S> =
        onEach { stateStore.updateLastChange(it) }
            .map { reducer.invoke(currentState, it) }
            .flowOn(dispatchers.io)

    public override fun Flow<C>.reduce(reducer: suspend (S?, C) -> S): Flow<S> =
        onEach { stateStore.updateLastChange(it) }
            .map { reducer.invoke(currentState, it) }
            .flowOn(dispatchers.io)

    public override fun Flow<S>.startWithInitialState(): Flow<S> =
        onStart {
            initialState?.let { emit(it) }
        }

    public override fun Flow<S>.render(): Flow<S> =
        onEach { stateStore.updateCurrentState(it) }
            .onEach { view.render(it) }
            .flowOn(dispatchers.main)
}
