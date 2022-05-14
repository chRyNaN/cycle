package com.chrynan.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BasicStateStore<I : Intent, C : Change, S : State>(
    override val initialState: S? = null
) : StateStore<I, C, S> {

    override var isPendingStateUpdate: Boolean = false
        private set

    override val states: StateFlow<Event<S?>>
        get() = mutableStates.asStateFlow()

    override val intents: StateFlow<Event<I>?>
        get() = mutableIntents.asStateFlow()

    override val changes: StateFlow<Event<C>?>
        get() = mutableChanges.asStateFlow()

    private val initialStateEvent by lazy { Event(value = initialState) }

    private val mutableStates = MutableStateFlow(initialStateEvent)
    private val mutableIntents = MutableStateFlow<Event<I>?>(null)
    private val mutableChanges = MutableStateFlow<Event<C>?>(null)

    override fun updateCurrentState(state: S?) {
        mutableStates.value = Event(value = state)
        isPendingStateUpdate = false
    }

    override fun updateLastIntent(intent: I) {
        mutableIntents.value = Event(value = intent)
        isPendingStateUpdate = true
    }

    override fun updateLastChange(change: C) {
        mutableChanges.value = Event(value = change)
        isPendingStateUpdate = true
    }

    override fun reset() {
        mutableStates.value = initialStateEvent
        mutableIntents.value = null
        mutableChanges.value = null
    }
}
