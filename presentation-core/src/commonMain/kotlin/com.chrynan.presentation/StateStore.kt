package com.chrynan.presentation

/**
 * A component that retains the information about the current [State] for a [Presenter].
 */
interface StateStore<I : Intent, C : Change, S : State> {

    val initialState: S?

    val currentState: S?

    val lastIntent: I?

    val lastChange: C?

    val isPendingStateUpdate: Boolean

    fun updateCurrentState(state: S?)

    fun updateLastIntent(intent: I)

    fun updateLastChange(change: C)

    fun reset()

    companion object
}
