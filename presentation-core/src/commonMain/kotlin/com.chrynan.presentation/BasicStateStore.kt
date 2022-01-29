package com.chrynan.presentation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class BasicStateStore<I : Intent, C : Change, S : State>(
    override val initialState: S? = null
) : StateStore<I, C, S> {

    override val currentState: S?
        get() = mutableStates.value

    override val states: Flow<S?>
        get() = mutableStates.asStateFlow()

    override var lastIntent: I? = null
        private set

    override var lastChange: C? = null
        private set

    override var isPendingStateUpdate: Boolean = false
        private set

    private val mutableStates = MutableStateFlow(initialState)

    override fun updateCurrentState(state: S?) {
        mutableStates.value = state
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
        mutableStates.value = initialState
        lastIntent = null
        lastChange = null
    }
}
