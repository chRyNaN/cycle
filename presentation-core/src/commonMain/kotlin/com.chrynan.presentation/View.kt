@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Represents a piece of UI, such as, a Screen. A [View] emits [Intent]s of type [I] that are accessible to callers of
 * the [intents] function. A [View] displays the UI for a provided [State] when the render function is called.
 * Other than the render function being called, a [View] should avoid updating it's UI state internally as it desires
 * (excluding non-UI state changes such as immediate and temporary reactions to [Intent]s, such as, the background
 * color briefly changing when the User clicks on a item in a list).
 *
 * A [View] typically contains a [Presenter] which is responsible for listening to the [View]s [intents] and performing
 * all the logic to derive a new [State] which it then passes back to the [View] via the render function.
 */
interface View<I : Intent, S : State> {

    /**
     * The currently rendered [State]. This property could briefly differ from the
     * [Presenter.currentState] until that state is provided to the render function and is
     * rendered to display.
     */
    val renderState: S?

    /**
     * A [Flow] of all of the [State]s. This [Flow] should emit all the distinct states provided
     * to the render function.
     *
     * Note that the [Presenter] should not subscribe to these [states] as that would create a loop.
     */
    val states: Flow<S>

    /**
     * Provides all the [Intent]s of type [I] as a [Flow] to the caller. These can be caused by user input events
     * (clicks, scrolls, etc.) or by other means.
     *
     * Note that this function should be called from the [Presenter] so that it can subscribe to the [Intent]s and
     * perform the appropriate [Action]s.
     *
     * Note that the default implementation of this function returns the result of the [intentEvents] function mapped
     * to just the [IntentEvent.intent] values.
     *
     * @see [intentEvents]
     */
    fun intents(): Flow<I> = intentEvents().map { it.intent }

    /**
     * Retrieves a [Flow] of [IntentEvent]s that are emitted by this [View].
     *
     * @see [intents]
     */
    fun intentEvents(): Flow<IntentEvent<I>>

    companion object
}
