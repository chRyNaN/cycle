@file:Suppress("unused")

package com.chrynan.presentation

import com.chrynan.dispatchers.CoroutineDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.ExperimentalTime

/**
 * A component that holds the whole state tree for a [ViewModel]. The only way to change the state inside it is to
 * dispatch a [Change] to it.
 *
 * @see [StateStore] constructor function to create an instance of this interface.
 */
interface StateStore<State, Change> {

    /**
     * Retrieves the initial [State] value that was provided when this [StateStore] was created.
     */
    val initialState: State?

    /**
     * Retrieves a [StateFlow] of this [StateStore]'s [State] changes. The items emitted on this [StateFlow] depend on
     * mutable function calls to alter the state, such as the [MutableStateStore.dispatch] function. The first value
     * emitted will be the [initialState] value.
     */
    val states: StateFlow<State?>

    companion object
}

/**
 * Retrieves the current [State] value for this [StateStore]. This is equivalent to call [StateFlow.value] on the
 * [StateStore.states] property, and is provided for convenience.
 */
val <State, Change> StateStore<State, Change>.currentState: State?
    get() = states.value

/**
 * A convenience function that subscribes to [State] changes on the [StateStore.states] property using the provided
 * values. The [onError] function is invoked when an exception was encountered, and the [onState] function is invoked
 * when a new [State] is emitted on the [StateStore.states] [StateFlow].
 */
fun <State, Change> StateStore<State, Change>.subscribe(
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
 * A mutable [StateStore] where the state can be altered by dispatching changes via the [dispatch] function.
 *
 * @see [MutableStateStore] constructor function to create an instance of this interface.
 */
interface MutableStateStore<State, Change> : StateStore<State, Change> {

    /**
     * Dispatches the provided [change] to be reduced and the resulting new [State] value to be used as the current
     * [State], updating associated values and emitting the value on the [states] [StateFlow].
     */
    suspend fun dispatch(change: Change)

    /**
     * Reverts this [StateStore] back to its original state. This function will cause the [states] [StateFlow] current
     * value to be set back to the [initialState].
     */
    fun reset()

    companion object
}

/**
 * A [MutableStateStore] that has basic Stack data structure functions that allow going back to previous [State]s.
 *
 * @see [MutableStackStateStore] constructor function to create an instance of this interface.
 */
interface MutableStackStateStore<State, Change> : MutableStateStore<State, Change> {

    /**
     * A convenience function for invoking the [dispatch] function.
     */
    suspend fun push(change: Change) = dispatch(change = change)

    /**
     * Attempts to drop the current [State] and go back to the previous [State] value before this one. If there is no
     * previous [State] value, this will have no effect.
     */
    fun pop()

    companion object
}

/**
 * A [MutableStackStateStore] that has basic backwards "time-travel" functionality that allows going back to a previous
 * [State] a certain time ago.
 *
 * @see [TimeTravelStateStore] constructor function to create an instance of this interface.
 */
@ExperimentalTime
interface TimeTravelStateStore<State, Change> : MutableStackStateStore<State, Change> {

    /**
     * Attempts to drop the [State]s on the state stack until the one that was present at the current time minus the
     * provided [duration]. If there is no previous [State], this will have no effect. If the provided [duration] is
     * back past the time when the [initialState] was added, then all items will be dropped except the [initialState]
     * and the [currentState] value will equal the [initialState]. If the provided [duration] is a negative value, this
     * will have no effect.
     */
    fun pop(duration: Duration)

    /**
     * Re-emits the [State]s in the order that they were first displayed and at the time intervals that they were first
     * displayed. Implementations may ignore mutations while the replay is occurring.
     */
    suspend fun replay()

    companion object
}

/**
 * Creates a non-mutable instance of the [StateStore] interface using the provided [initialState] and [stateFlow].
 */
fun <State, Change> StateStore(
    initialState: State? = null,
    stateFlow: StateFlow<State?>
): StateStore<State, Change> = ReadOnlyStateStore(
    initialState = initialState,
    stateFlow = stateFlow
)

/**
 * Retrieves a non-mutable [StateStore] instance of this [MutableStateStore].
 */
fun <State, Change> MutableStateStore<State, Change>.asStateStore(): StateStore<State, Change> = ReadOnlyStateStore(
    initialState = initialState,
    stateFlow = states
)

/**
 * Creates an instance of the [MutableStateStore] interface using the provided [initialState] and [reducer].
 */
fun <State, Change> MutableStateStore(
    initialState: State? = null,
    reducer: Reducer<State, Change>
): MutableStateStore<State, Change> = MutableStateStoreImpl(
    initialState = initialState,
    reducer = reducer
)

/**
 * Creates an instance of the [MutableStackStateStore] interface using the provided [initialState] and [reducer].
 */
fun <State, Change> MutableStackStateStore(
    initialState: State? = null,
    reducer: Reducer<State, Change>
): MutableStackStateStore<State, Change> = MutableStateStoreImpl(
    initialState = initialState,
    reducer = reducer
)

/**
 * Creates an instance of the [MutableStackStateStore] interface using the provided [initialState] and [reducer].
 */
@ExperimentalTime
fun <State, Change> TimeTravelStateStore(
    initialState: State? = null,
    reducer: Reducer<State, Change>
): TimeTravelStateStore<State, Change> = TimeTravelStateStoreImpl(
    initialState = initialState,
    reducer = reducer
)

/**
 * A read-only implementation of a [StateStore] used by the [StateStore] constructor function.
 */
private class ReadOnlyStateStore<State, Change>(
    override val initialState: State? = null,
    private val stateFlow: StateFlow<State?>
) : StateStore<State, Change> {

    @Suppress("UNCHECKED_CAST")
    override val states: StateFlow<State?>
        get() = try {
            (stateFlow as? MutableStateFlow<State>)?.let { stateFlow.asStateFlow() } ?: stateFlow
        } catch (_: Exception) {
            stateFlow
        }

    override fun toString(): String =
        "StateStore(initialState=$initialState, states=$states)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is ReadOnlyStateStore<*, *>) return false

        return initialState == other.initialState && currentState == other.currentState && states == other.states
    }

    override fun hashCode(): Int {
        var result = initialState?.hashCode() ?: 0

        result = 31 * result + states.hashCode()

        return result
    }
}

/**
 * A basic default implementation of the [MutableStateStore] and [MutableStackStateStore] interfaces used by the
 * [MutableStateStore] and [MutableStackStateStore] constructor functions.
 */
private class MutableStateStoreImpl<State, Change>(
    override val initialState: State? = null,
    private val reducer: Reducer<State, Change>
) : MutableStateStore<State, Change>,
    MutableStackStateStore<State, Change> {

    override val states: StateFlow<State?>
        get() = mutableStateFlow.asStateFlow()

    private val mutableStateFlow = MutableStateFlow(initialState)

    private val mutableStateEventList = mutableListOf(Event(initialState))

    override suspend fun dispatch(change: Change) {
        val newState = reducer.invoke(currentState, change)

        mutableStateEventList.add(Event(newState))

        mutableStateFlow.value = newState
    }

    override fun reset() {
        mutableStateEventList.clear()
        mutableStateEventList.add(Event(initialState))

        mutableStateFlow.value = initialState
    }

    override fun pop() {
        if (mutableStateEventList.size > 1) {
            mutableStateEventList.dropLast(1)

            mutableStateFlow.value = mutableStateEventList.last().value
        }
    }

    override fun toString(): String =
        "MutableStateStore(initialState=$initialState, reducer=$reducer, states=$states)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is MutableStateStoreImpl<*, *>) return false

        if (initialState != other.initialState) return false
        if (currentState != other.currentState) return false
        if (mutableStateEventList != other.mutableStateEventList) return false
        if (reducer != other.reducer) return false

        return states == other.states
    }

    override fun hashCode(): Int {
        var result = initialState?.hashCode() ?: 0

        result = 31 * result + reducer.hashCode()
        result = 31 * result + states.hashCode()

        return result
    }
}

/**
 * A basic default implementation of the [MutableStateStore] and [MutableStackStateStore] interfaces used by the
 * [MutableStateStore] and [MutableStackStateStore] constructor functions.
 */
@ExperimentalTime
private class TimeTravelStateStoreImpl<State, Change>(
    override val initialState: State? = null,
    private val reducer: Reducer<State, Change>
) : MutableStateStore<State, Change>,
    MutableStackStateStore<State, Change>,
    TimeTravelStateStore<State, Change> {

    override val states: StateFlow<State?>
        get() = mutableStateFlow.asStateFlow()

    private val mutableStateFlow = MutableStateFlow(initialState)

    private val mutableStateEventList = mutableListOf(Event(initialState))

    private var isReplaying = false

    override suspend fun dispatch(change: Change) {
        if (!isReplaying) {
            val newState = reducer.invoke(currentState, change)

            mutableStateEventList.add(Event(newState))

            mutableStateFlow.value = newState
        }
    }

    override fun reset() {
        if (!isReplaying) {
            mutableStateEventList.clear()
            mutableStateEventList.add(Event(initialState))

            mutableStateFlow.value = initialState
        }
    }

    override fun pop() {
        if (!isReplaying) {
            if (mutableStateEventList.size > 1) {
                mutableStateEventList.dropLast(1)

                mutableStateFlow.value = mutableStateEventList.last().value
            }
        }
    }

    override fun pop(duration: Duration) {
        if (!isReplaying) {
            if (mutableStateEventList.size > 1 && duration.isPositive()) {
                val time = currentElapsedSystemTime - duration

                val newEvents = mutableListOf<Event<State?>>()

                mutableStateEventList.forEach { event ->
                    if (event.elapsedSystemTime <= time) {
                        newEvents.add(event)
                    }
                }

                if (newEvents.isEmpty()) {
                    newEvents.add(mutableStateEventList.first())
                }

                mutableStateEventList.clear()
                mutableStateEventList.addAll(newEvents)

                mutableStateFlow.value = mutableStateEventList.last().value
            }
        }
    }

    override suspend fun replay() {
        var previousEvent: Event<State?>? = null

        mutableStateEventList.forEach { event ->
            val duration =
                (event.elapsedSystemTime - (previousEvent?.elapsedSystemTime ?: 0.milliseconds)).absoluteValue

            delay(duration)

            mutableStateFlow.value = event.value

            previousEvent = event
        }
    }

    override fun toString(): String =
        "TimeTravelStateStore(initialState=$initialState, reducer=$reducer, states=$states)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is TimeTravelStateStoreImpl<*, *>) return false

        if (initialState != other.initialState) return false
        if (currentState != other.currentState) return false
        if (mutableStateEventList != other.mutableStateEventList) return false
        if (reducer != other.reducer) return false

        return states == other.states
    }

    override fun hashCode(): Int {
        var result = initialState?.hashCode() ?: 0

        result = 31 * result + reducer.hashCode()
        result = 31 * result + states.hashCode()

        return result
    }
}
