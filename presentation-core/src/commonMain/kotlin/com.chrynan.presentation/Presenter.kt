package com.chrynan.presentation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

/**
 * A [Presenter] handles the presentation logic for a [View]. It coordinates the different presentation components,
 * such as, the [Action]s and the [Reducer].
 */
interface Presenter<I : Intent, S : State, C : Change> : Bindable {

    /**
     * The current [State] of type [S] that is being displayed in the [View].
     */
    val currentState: S?

    /**
     * A [Flow] of all the [State]s of type [S] that are to be rendered in the [View].
     */
    val renderStates: StateFlow<S?>

    /**
     * A [Flow] of all the [Intent]s of type [I] that are emitted to this [Presenter].
     */
    val intents: Flow<I>

    companion object
}
