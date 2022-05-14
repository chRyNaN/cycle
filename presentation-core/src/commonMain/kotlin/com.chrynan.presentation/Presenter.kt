package com.chrynan.presentation

import kotlinx.coroutines.flow.Flow

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
    val renderStates: Flow<S?>

    /**
     * A [Flow] of all the [Intent]s of type [I] that are emitted to this [Presenter].
     */
    val intents: Flow<I>

    /**
     * Emits the provided [to] [Intent] value to trigger an action, that may eventually result in a new [State] being
     * rendered. These can be caused by user input events (clicks, scrolls, etc.) or by other means.
     */
    fun intent(to: I)

    companion object
}
