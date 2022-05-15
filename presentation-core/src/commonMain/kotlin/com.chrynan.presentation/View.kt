@file:Suppress("unused")

package com.chrynan.presentation

/**
 * Represents a piece of UI, such as, a Screen. A [View] emits [Intent]s of type [I] that are accessible to callers of
 * the [intents] function. A [View] displays the UI for a provided [State] when the render function is called.
 * Other than the render function being called, a [View] should avoid updating its UI state internally as it desires
 * (excluding non-UI state changes such as immediate and temporary reactions to [Intent]s, such as, the background
 * color briefly changing when the User clicks on an item in a list).
 *
 * A [View] typically contains a [ViewModel] which is responsible for listening to the [View]s [intents] and performing
 * all the logic to derive a new [State] which it then passes back to the [View] via the render function.
 */
interface View<I : Intent, S : State, C : Change> {

    /**
     * The currently rendered [State]. This property could briefly differ from the
     * [ViewModel.currentState] until that state is provided to the render function of this [View] and is
     * rendered to display.
     */
    val renderState: S?

    val viewModel: ViewModel<I, S, C>

    companion object
}

/**
 * Emits the provided [to] [Intent] value to trigger an action, that may eventually result in a new [State] being
 * rendered.
 */
fun <I : Intent, S : State, C : Change> View<I, S, C>.intent(to: I) {
    viewModel.intent(to = to)
}
