@file:Suppress("unused")

package com.chrynan.cycle

import com.chrynan.dispatchers.CoroutineDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

/**
 * An abstract implementation of a [ViewModel] that supports the MVI (Model-View-Intent) design pattern. Inheritors of
 * this class must implement the [performIntentAction] function which associates an [Action] with an [Intent]. To emit
 * an [Intent] on an [IntentViewModel], use the [IntentViewModel.intent] function.
 */
@FlowPreview
@ExperimentalCoroutinesApi
abstract class IntentViewModel<Intent, State, Change>(
    stateStore: MutableStateStore<State, Change>,
    dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    resetOnUnbind: Boolean = false,
    flatMapStrategy: FlatMapStrategy = FlatMapStrategy.Latest
) : ViewModel<State, Change>(
    stateStore = stateStore,
    dispatchers = dispatchers,
    resetOnUnbind = resetOnUnbind,
    flatMapStrategy = flatMapStrategy
) {

    /**
     * Takes the current [state] and the [intent] and produces a [Flow] of [Change]s. These [Change]s will be reduced
     * to produce a new [state]. This function is invoked by the [intent] function and should not be publicly scoped.
     */
    protected abstract fun performIntentAction(state: State?, intent: Intent): Flow<Change>

    /**
     * Triggers the invocation of the [Action] associated with the provided [to] [Intent]. This may result in a changes
     * to the current [State].
     *
     * **Note:** This function looks similar to the [dispatch] function, but that function emits a [Change] which will
     * be reduced to create a new [State], whereas, this [intent] function emits an [Intent] which triggers an
     * associated [Action] to produce a [Change] (which then will be reduced to create a new [State]). This function is
     * more similar to the [perform] function, but instead of performing the action at the call-site, this [intent]
     * function just triggers the associated [Action] which is encapsulated in the [IntentViewModel] implementation.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun intent(to: Intent) {
        perform {
            performIntentAction(currentState, to)
        }
    }

    companion object
}

/**
 * Creates a new basic [IntentViewModel] instance with the provided [performIntentAction], [stateStore] and other
 * parameter values. Creating an [IntentViewModel] this way is convenient and useful, but for more advanced use-cases
 * and more control, consider making discrete [IntentViewModel] implementations.
 */
@FlowPreview
@ExperimentalCoroutinesApi
fun <Intent, State, Change> IntentViewModel.Companion.create(
    performIntentAction: State?.(Intent) -> Flow<Change>,
    stateStore: MutableStateStore<State, Change>,
    dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    resetOnUnbind: Boolean = false,
    flatMapStrategy: FlatMapStrategy = FlatMapStrategy.Latest
): IntentViewModel<Intent, State, Change> = BaseIntentViewModel(
    performIntentAction = performIntentAction,
    stateStore = stateStore,
    dispatchers = dispatchers,
    resetOnUnbind = resetOnUnbind,
    flatMapStrategy = flatMapStrategy
)

/**
 * Creates a new basic [IntentViewModel] instance with the provided [performIntentAction], [reducer] and other
 * parameter values. Creating an [IntentViewModel] this way is convenient and useful, but for more advanced use-cases
 * and more control, consider making discrete [IntentViewModel] implementations.
 */
@FlowPreview
@ExperimentalCoroutinesApi
fun <Intent, State, Change> IntentViewModel.Companion.create(
    performIntentAction: State?.(Intent) -> Flow<Change>,
    reducer: Reducer<State, Change>,
    initialState: State? = null,
    dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    resetOnUnbind: Boolean = false,
    flatMapStrategy: FlatMapStrategy = FlatMapStrategy.Latest
): IntentViewModel<Intent, State, Change> = BaseIntentViewModel(
    performIntentAction = performIntentAction,
    stateStore = MutableStateStore(initialState = initialState, reducer = reducer),
    dispatchers = dispatchers,
    resetOnUnbind = resetOnUnbind,
    flatMapStrategy = flatMapStrategy
)

/**
 * A basic implementation of the [IntentViewModel] abstract class used by the [IntentViewModel] constructor function.
 * It is recommended to avoid this approach for more complex use-cases and instead create a [IntentViewModel] subclass,
 * adding any implementation specific [Action] functions necessary.
 */
@FlowPreview
@ExperimentalCoroutinesApi
private class BaseIntentViewModel<Intent, State, Change>(
    private val performIntentAction: State?.(Intent) -> Flow<Change>,
    stateStore: MutableStateStore<State, Change>,
    dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    resetOnUnbind: Boolean = false,
    flatMapStrategy: FlatMapStrategy = FlatMapStrategy.Latest
) : IntentViewModel<Intent, State, Change>(
    stateStore = stateStore,
    dispatchers = dispatchers,
    resetOnUnbind = resetOnUnbind,
    flatMapStrategy = flatMapStrategy
) {

    override fun performIntentAction(state: State?, intent: Intent): Flow<Change> =
        performIntentAction.invoke(state, intent)
}
