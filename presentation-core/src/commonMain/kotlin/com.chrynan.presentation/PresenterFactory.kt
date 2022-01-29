@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.flow.Flow

/**
 * A component that can create a [Presenter]. This allows lazy instantiation of a [Presenter] which
 * may be required to wait for the [View] to be created first, then passing that into the [invoke]
 * function to create the [Presenter] that will be bound to that [View].
 *
 * Note that this interface is a functional interface, so an instance can be created like so:
 * ```kotlin
 * PresenterFactory { view -> }
 * ```
 *
 * Example usage:
 * ```kotlin
 * PresenterFactory { view ->
 *     Presenter(view) {
 *         this.view.intents()
 *         .perform { intent, state -> ... }
 *         .reduce { state, change -> ... }
 *         .startWithInitialState()
 *         .render()
 *         .launchIn(coroutineScope)
 *     }
 * }
 * ```
 */
fun interface PresenterFactory<I : Intent, S : State, C : Change> {

    operator fun invoke(intents: Flow<I>): Presenter<I, S, C>

    companion object
}

operator fun <I : Intent, S : State, C : Change> PresenterFactory<I, S, C>.invoke(view: View<I, S>): Presenter<I, S, C> =
    invoke(intents = view.intents())
