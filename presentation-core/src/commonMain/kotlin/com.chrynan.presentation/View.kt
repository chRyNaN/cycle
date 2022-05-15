@file:Suppress("unused")

package com.chrynan.presentation

/**
 * Represents a piece of UI, such as a Screen, in an application. A [View] emits [Intent]s of type [I] to a [viewModel]
 * via the [ViewModel.intent] function. A [View] displays the UI for a [State] by subscribing to the
 * [ViewModel.renderStates] flow.
 *
 * A [View] contains a [ViewModel] which is responsible for listening to the [View]s [Intent]s and performing all the
 * logic to derive a new [State] which the [View] then observes and updates its UI accordingly.
 */
interface View<I : Intent, S : State, C : Change> {

    /**
     * The currently rendered [State]. This property could briefly differ from the [ViewModel.currentState] until that
     * state is observed by this [View] and is rendered to display.
     */
    val renderState: S?

    /**
     * The [ViewModel] this [View] uses to subscribe to [State] changes and emit [Intent]s. The [ViewModel] is the
     * binding piece of this design pattern, between the [View] and itself, that handles coordinating the flow of logic
     * to derive a new [State] that this [View] will then observe and render to the UI.
     */
    val viewModel: ViewModel<I, S, C>

    companion object
}

/**
 * Emits the provided [to] [Intent] value to trigger an action, that may eventually result in a new [State] being
 * rendered.
 *
 * This is a convenience function for calling [ViewModel.intent] on the [View.viewModel] property.
 */
fun <I : Intent, S : State, C : Change> View<I, S, C>.intent(to: I) {
    viewModel.intent(to = to)
}
