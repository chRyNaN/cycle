package com.chrynan.presentation

/**
 * A [Presenter] handles the presentation logic for a [View]. It coordinates the different presentation components,
 * such as, the [Action]s and the [Reducer].
 */
interface Presenter<I : Intent, S : State, C : Change> : PresenterCoroutineScope {

    /**
     * The current [State] of type [S] that is being displayed in the [View].
     */
    val currentState: S

    /**
     * The [View] that this [Presenter] handles the presentation logic for.
     */
    val view: View<I, S>

    /**
     * The [Reducer] used to derive the [State] of the [View].
     */
    val reducer: Reducer<S, C>

    /**
     * Determines if this [Presenter] is bound to the [View] or not. A [Presenter] is bound to a [View] between calls
     * to the [bind] and [unbind] functions. Returns true if this [Presenter] is bound to the [View], false otherwise.
     */
    val isBound: Boolean

    /**
     * Binds and sets up this [Presenter] for the attached [View].
     */
    fun bind()

    /**
     * Unbinds and cleans up the resources used by this [Presenter].
     */
    fun unbind()
}
