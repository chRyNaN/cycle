package com.chrynan.presentation

import com.chrynan.dispatchers.CoroutineDispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

/**
 * A convenience function to create a [ViewModel] without having to directly create an implementation. This could be
 * especially useful for simple applications that don't have complex dependency management and testing requirements.
 *
 * Example usage:
 * ```kotlin
 * ViewModel<I, S, C> {
 *     this.intents
 *         .perform { intent, state -> ... }
 *         .reduce { state, change -> ... }
 *         .startWithInitialState()
 *         .render()
 *         .launchIn(coroutineScope)
 * }
 * ```
 */
@Suppress("FunctionName")
fun <I : Intent, S : State, C : Change> ViewModel(
    initialState: S? = null,
    dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    onUnbind: (DelegatingViewModel<I, S, C>.() -> Unit)? = null,
    onBind: DelegatingViewModel<I, S, C>.() -> Unit
): DelegatingViewModel<I, S, C> = DelegatingViewModel(
    initialState = initialState,
    dispatchers = dispatchers,
    onUnbind = onUnbind,
    onBind = onBind
)

/**
 * A convenience function to create a [ViewModel] without having to directly create an implementation. This could be
 * especially useful for simple applications that don't have complex dependency management and testing requirements.
 *
 * Example usage:
 * ```kotlin
 * ViewModel<I, S, C>(
 *     perform = { intent, state -> ... },
 *     reduce = { state, change -> ... })
 * ```
 */
@OptIn(FlowPreview::class)
@Suppress("FunctionName")
fun <I : Intent, S : State, C : Change> ViewModel(
    initialState: S? = null,
    dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    onUnbind: (DelegatingViewModel<I, S, C>.() -> Unit)? = null,
    onBind: (DelegatingViewModel<I, S, C>.() -> Unit)? = null,
    onError: (() -> Unit)? = null,
    startWithInitialState: Boolean = true,
    flatMapStrategy: FlatMapStrategy = FlatMapStrategy.Latest,
    perform: suspend (I, S?) -> Flow<C>,
    reduce: suspend (S?, C) -> S
): DelegatingViewModel<I, S, C> = DelegatingViewModel(
    initialState = initialState,
    dispatchers = dispatchers,
    onUnbind = onUnbind,
    onBind = {
        onBind?.invoke(this)

        if (startWithInitialState) {
            this.intents
                .perform(strategy = flatMapStrategy, action = perform)
                .reduce(reduce)
                .startWithInitialState()
                .render()
                .catch { onError?.invoke() }
                .launchIn(coroutineScope)
        } else {
            this.intents
                .perform(strategy = flatMapStrategy, action = perform)
                .reduce(reduce)
                .render()
                .catch { onError?.invoke() }
                .launchIn(coroutineScope)
        }
    }
)

/**
 * An implementation of [ViewModel] that delegates the provider properties to their corresponding [ViewModel]
 * equivalents. This implementation also makes a lot of the protected [ViewModel] functions public so that they can
 * be called in a scoped context.
 */
class DelegatingViewModel<I : Intent, S : State, C : Change> internal constructor(
    initialState: S? = null,
    dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    private val onUnbind: (DelegatingViewModel<I, S, C>.() -> Unit)? = null,
    private val onBind: DelegatingViewModel<I, S, C>.() -> Unit
) : ViewModel<I, S, C>(
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
}
