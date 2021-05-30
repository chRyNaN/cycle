package com.chrynan.presentation

class BasicStateStore<I : Intent, C : Change, S : State>(
    override val initialState: S? = null
) : StateStore<I, C, S> {

    override var currentState: S? = initialState
        private set

    override var lastIntent: I? = null
        private set

    override var lastChange: C? = null
        private set

    override var isPendingStateUpdate: Boolean = false
        private set

    override fun updateCurrentState(state: S?) {
        currentState = state
        isPendingStateUpdate = false
    }

    override fun updateLastIntent(intent: I) {
        lastIntent = intent
        isPendingStateUpdate = true
    }

    override fun updateLastChange(change: C) {
        lastChange = change
        isPendingStateUpdate = true
    }

    override fun reset() {
        currentState = initialState
        lastIntent = null
        lastChange = null
    }
}
