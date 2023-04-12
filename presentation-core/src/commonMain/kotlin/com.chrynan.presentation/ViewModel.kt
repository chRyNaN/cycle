@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter")

package com.chrynan.presentation

import com.chrynan.dispatchers.CoroutineDispatchers
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

/**
 * A [ViewModel] is a design pattern component that acts as a bridge between the [View] and the application logic. It
 * is responsible for coordinating the application logic, in the uni-directional flow established by this design
 * pattern, to ultimately derive a new [State] that is to be rendered by the [View]. This [ViewModel] component does
 * not have a reference to the [View], instead the [View] has a reference to a [ViewModel], and calls the
 * [ViewModel.states] property to obtain a [Flow] of [State] changes that it subscribes to, so that it can update
 * whenever the [ViewModel] derives a new [State]. This simplifies the communication between the two components, by
 * removing the cyclic dependency between the two (as is common in a traditional MVP design pattern).
 *
 * A [ViewModel] wraps a [StateStore] component to provide more complex functionality. [ViewModel]s perform application
 * component specific [Action]s to derive a [Flow] of [Change]s that are provided to the wrapped [StateStore] to reduce
 * a new [State]. Some of the [StateStore] functionality is exposed in a [ViewModel] by delegation, such as the
 * [ViewModel.states] property just delegates to the [StateStore.states] property.
 *
 * To obtain a basic [ViewModel] instance where the [Action]s can be provided at the call-site, use the
 * [ViewModel.Companion.create] functions. However, it is strongly encouraged to create [ViewModel] subclasses and
 * provide implementation specific [Action] functions.
 *
 * @see [IntentViewModel] for an abstract [ViewModel] implementation that works well with the MVI (Model-View-Intent)
 * design pattern.
 */
@FlowPreview
@ExperimentalCoroutinesApi
abstract class ViewModel<State, Change>(
    protected val stateStore: MutableStateStore<State, Change>,
    protected val dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    protected val resetOnUnbind: Boolean = false,
    protected val flatMapStrategy: FlatMapStrategy = FlatMapStrategy.Latest
) : PlatformViewModel(),
    Bindable {

    final override var isBound = false
        internal set

    /**
     * Exposes the [stateStore]'s [StateStore.initialState] property.
     */
    val initialState: State?
        get() = stateStore.initialState

    /**
     * Exposes the [stateStore]'s [StateStore.currentState] property.
     */
    val currentState: State?
        get() = stateStore.currentState

    /**
     * Exposes the [stateStore]'s [StateStore.states] property.
     */
    val states: StateFlow<State?>
        get() = stateStore.states

    /**
     * A [CoroutineScope] bound to this [ViewModel]'s lifecycle defined by when the component [isBound].
     */
    protected val coroutineScope: CoroutineScope = object : CoroutineScope {

        override val coroutineContext: CoroutineContext
            get() = job + dispatchers.main
    }

    /**
     * A [MutableStateFlow] of [Action]s that represent the [Action]s being performed via calls to the [perform]
     * function.
     */
    protected val actions = MutableStateFlow<Action<State, Change>?>(null)

    private lateinit var job: Job

    /**
     * Binds this [ViewModel].
     *
     * Prefer overriding the [onBind] function for setup logic.
     */
    final override fun bind() {
        if (!isBound) {
            job = SupervisorJob()
            isBound = true
            onBind()
        }
    }

    /**
     * Unbinds this [ViewModel].
     *
     * Prefer overriding the [onUnbind] function for cleanup logic.
     */
    final override fun unbind() {
        if (isBound) {
            onUnbind()
            job.cancel()
            isBound = false

            if (resetOnUnbind) {
                stateStore.reset()
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is ViewModel<*, *>) return false

        if (this.initialState != other.initialState) return false
        if (this.currentState != other.currentState) return false
        if (this.stateStore != other.stateStore) return false

        return this.resetOnUnbind == other.resetOnUnbind
    }

    override fun hashCode(): Int {
        var result = initialState.hashCode()

        result = result * 31 + stateStore.hashCode()
        result = result * 31 + initialState.hashCode()
        result = result * 31 + currentState.hashCode()
        result = result * 31 + resetOnUnbind.hashCode()

        return result
    }

    override fun toString(): String =
        "ViewModel(initialState=$initialState,currentState=$currentState,stateStore=$stateStore,dispatchers=$dispatchers,resetOnUnbind=$resetOnUnbind,flatMapStrategy=$flatMapStrategy)"

    /**
     * Triggers the invocation of the provided [action] which results in the [action]'s [Change]s being reduced and
     * producing a new [State].
     */
    protected open fun perform(action: Action<State, Change>) {
        actions.value = action
    }

    /**
     * Triggers the invocation of the provided [action] which results in the [action]'s [Change] being reduced and
     * producing a new [State]. This function differs from the [ViewModel.perform] function in that the provided [action]
     * only returns a single [Change], whereas the [ViewModel.perform] function returns a [Flow] of [Change]s.
     */
    protected open fun performSingle(action: suspend State?.() -> Change) =
        this.perform { flowOf(action.invoke(currentState)) }

    /**
     * Emits the provided [change], causing it to be reduced which produces a new [State].
     */
    protected open fun dispatch(change: Change) = perform { flowOf(change) }

    /**
     * This function will be invoked when this Presenters [bind] function is called and this
     * Presenter is not already bound.
     */
    protected open fun onBind() {
        actions.filterNotNull()
            .flatMap(flatMapStrategy) { it.invoke(currentState) }
            .onEach { stateStore.dispatch(it) }
            .launchIn(coroutineScope)
    }

    /**
     * This function will be invoked when this Presenters [unbind] function is called and this
     * Presenter is bound.
     *
     * This is a good place to clear up any resources. Note that this function will be invoked
     * before the [coroutineScope] is cancelled.
     */
    protected open fun onUnbind() {}

    companion object
}

/**
 * A convenience function that subscribes to [State] changes on the [ViewModel.states] property using the provided
 * values. The [onError] function is invoked when an exception was encountered, and the [onState] function is invoked
 * when a new [State] is emitted on the [ViewModel.states] [StateFlow].
 */
@ExperimentalCoroutinesApi
@FlowPreview
fun <State, Change> ViewModel<State, Change>.subscribe(
    coroutineScope: CoroutineScope,
    dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    onError: suspend () -> Unit = {},
    onState: suspend (State?) -> Unit
) {
    states.onEach(onState)
        .catch { onError() }
        .flowOn(dispatchers.main)
        .launchIn(coroutineScope)
}

/**
 * Creates a new basic [ViewModel] instance with the provided [stateStore] and parameter values. Creating a [ViewModel]
 * this way is convenient and useful, but for more advanced use-cases and more control, consider making discrete
 * [ViewModel] implementations.
 */
@FlowPreview
@ExperimentalCoroutinesApi
fun <State, Change> ViewModel.Companion.create(
    stateStore: MutableStateStore<State, Change>,
    dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    resetOnUnbind: Boolean = false,
    flatMapStrategy: FlatMapStrategy = FlatMapStrategy.Latest
): BaseViewModel<State, Change> =
    BaseViewModel(
        stateStore = stateStore,
        dispatchers = dispatchers,
        resetOnUnbind = resetOnUnbind,
        flatMapStrategy = flatMapStrategy
    )

/**
 * Creates a new basic [ViewModel] instance with the provided [reducer] and parameter values. Creating a [ViewModel]
 * this way is convenient and useful, but for more advanced use-cases and more control, consider making discrete
 * [ViewModel] implementations.
 */
@FlowPreview
@ExperimentalCoroutinesApi
fun <State, Change> ViewModel.Companion.create(
    reducer: Reducer<State, Change>,
    initialState: State? = null,
    dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    resetOnUnbind: Boolean = false,
    flatMapStrategy: FlatMapStrategy = FlatMapStrategy.Latest
): BaseViewModel<State, Change> =
    BaseViewModel(
        stateStore = MutableStateStore(initialState = initialState, reducer = reducer),
        dispatchers = dispatchers,
        resetOnUnbind = resetOnUnbind,
        flatMapStrategy = flatMapStrategy
    )

/**
 * A basic implementation of the [ViewModel] abstract class used by the [ViewModel] constructor function. This
 * implementation publicly exposes the [perform], [performSingle], and [dispatch] functions. It is recommended to avoid
 * this approach for more complex use-cases and instead create a [ViewModel] subclass, adding any implementation
 * specific [Action] functions necessary, and leaving the [perform], [performSingle], and [dispatch] functions not
 * publicly exposed.
 */
@FlowPreview
@ExperimentalCoroutinesApi
class BaseViewModel<State, Change> internal constructor(
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

    public override fun perform(action: Action<State, Change>) =
        super.perform(action)

    public override fun performSingle(action: suspend State?.() -> Change) =
        super.performSingle(action)

    public override fun dispatch(change: Change) =
        super.dispatch(change)

    companion object
}
