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
 * [ViewModel.renderStates] property to obtain a [Flow] of [State] changes that it subscribes to, so that it can update
 * whenever the [ViewModel] derives a new [State]. This simplifies the communication between the two components, by
 * removing the cyclic dependency between the two (as is common in a traditional MVP design pattern).
 *
 * This is a base implementation of the [Presenter] interface that provides functions for handling common
 * functionality, such as, the [performWith], [reduceWith], and [render] functions.
 */
abstract class ViewModel<I : Intent, S : State, C : Change>(
    protected val initialState: S? = null,
    protected val dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers,
    private val resetOnUnbind: Boolean = false
) : PlatformViewModel(),
    Presenter<I, S, C>,
    ViewModelFlowScope<I, S, C> {

    override val currentState: S?
        get() = stateStore.currentState

    override val renderStates: Flow<S?>
        get() = stateStore.states.map { it.value }

    override val intents: Flow<I>
        get() = stateStore.intents.mapNotNull { it?.value }

    override var isBound = false
        internal set

    val coroutineScope: CoroutineScope = object : CoroutineScope {

        override val coroutineContext: CoroutineContext
            get() = job + dispatchers.main
    }

    protected open val stateStore: MutableStateStore<I, S, C> = BasicStateStore(initialState)

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

    override fun intent(to: I) {
        stateStore.updateLastIntent(intent = to)
    }

    /**
     * This function will be invoked when this Presenters [bind] function is called when this
     * Presenter is not already bound.
     *
     * This is a good place to setup any resources or calls. Typically, the MVI pattern flow is
     * set up here by listening to [Intent]s emitted by the [View].
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
    override fun Flow<I>.performWith(
        strategy: FlatMapStrategy,
        action: Action<I, S, C>
    ): Flow<C> =
        flowOn(dispatchers.main)
            .flatMap(strategy = strategy) { action.create(it, currentState) }
            .flowOn(dispatchers.io)

    /**
     * Converts this [Flow] of [Intent]s of type [I] into a [Flow] of [Change]s of type [C] using the provided [action]
     * function.
     */
    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    override fun Flow<I>.perform(
        strategy: FlatMapStrategy,
        action: suspend (I, S?) -> Flow<C>
    ): Flow<C> =
        flowOn(dispatchers.main)
            .flatMap(strategy = strategy) { action(it, currentState) }
            .flowOn(dispatchers.io)

    /**
     * Converts this [Flow] of [Change]s of type [C] into a [Flow] of type [S] using this [ViewModel]s [Reducer].
     */
    override fun Flow<C>.reduceWith(reducer: Reducer<S, C>): Flow<S?> =
        onEach { stateStore.updateLastChange(it) }
            .map { reducer.create(currentState, it) }
            .flowOn(dispatchers.io)

    /**
     * Converts this [Flow] of [Change]s of type [C] into a [Flow] of type [S] using this [ViewModel]s [Reducer].
     */
    override fun Flow<C>.reduce(reducer: suspend (S?, C) -> S?): Flow<S?> =
        onEach { stateStore.updateLastChange(it) }
            .map { reducer.invoke(currentState, it) }
            .flowOn(dispatchers.io)

    /**
     * Emits the [initialState] value in [onStart] if it is not null.
     */
    override fun Flow<S?>.startWithInitialState(): Flow<S?> =
        onStart {
            emit(initialState)
        }

    /**
     * Renders the [State]s of type [S] from this [Flow] with this [ViewModel]s [View].
     */
    override fun Flow<S?>.render(): Flow<S?> =
        onEach { stateStore.updateCurrentState(it) }
            .flowOn(dispatchers.main)
}
