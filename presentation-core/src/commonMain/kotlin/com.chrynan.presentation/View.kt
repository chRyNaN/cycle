@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

/**
 * Represents a piece of UI, such as a Screen, in an application. A [View] contains a [ViewModel] which it binds to its
 * lifecycle and uses to subscribe to state changes to update the UI. The [View] implementation is responsible for
 * manually handling the coordination of the [ViewModel] lifecycle and subscription.
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
     * The [ViewModel] this [View] uses to subscribe to [State] changes. The [ViewModel] is the binding piece of this
     * design pattern that handles coordinating the flow of logic to derive a new [State] that this [View] will then
     * observe and render to the UI.
     */
    val viewModel: ViewModel<State, Change>

    companion object
}
