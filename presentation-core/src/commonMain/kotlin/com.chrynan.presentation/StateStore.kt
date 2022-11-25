package com.chrynan.presentation

import kotlinx.coroutines.flow.StateFlow

/**
 * A component that retains the information about the current [State] for a [ViewModel].
 */
interface StateStore<I : Intent, S : State, C : Change> {

    val initialState: S?

    val currentState: S?
        get() = states.value.value

    val lastIntent: I?
        get() = intents.value?.value

    val lastChange: C?
        get() = changes.value?.value

    val isPendingStateUpdate: Boolean

    val states: StateFlow<Event<S?>>

    val intents: StateFlow<Event<I>?>

    val changes: StateFlow<Event<C>?>

    companion object
}

interface MutableStateStore<I : Intent, S : State, C : Change> : StateStore<I, S, C> {

    fun updateCurrentState(state: S?)

    fun updateLastIntent(intent: I)

    fun updateLastChange(change: C)

    fun reset()
}
