@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

/**
 * Represents a piece of UI, such as a Screen, in an application. A [View] emits [Intent]s of type [I] to a [viewModel]
 * via the [ViewModel.intent] function. A [View] displays the UI for a [State] by subscribing to the
 * [ViewModel.states] flow.
 *
 * A [View] contains a [ViewModel] which is responsible for listening to the [View]s [Intent]s and performing all the
 * logic to derive a new [State] which the [View] then observes and updates its UI accordingly.
 */
@ExperimentalCoroutinesApi
@FlowPreview
interface View<State, Change> {

    /**
     * The currently rendered [State]. This property could briefly differ from the [ViewModel.currentState] until that
     * state is observed by this [View] and is rendered to display.
     */
    val renderState: State?

    /**
     * The [ViewModel] this [View] uses to subscribe to [State] changes and emit [Intent]s. The [ViewModel] is the
     * binding piece of this design pattern, between the [View] and itself, that handles coordinating the flow of logic
     * to derive a new [State] that this [View] will then observe and render to the UI.
     */
    val viewModel: ViewModel<State, Change>

    companion object
}
