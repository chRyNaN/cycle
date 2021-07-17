@file:Suppress("unused")

package com.chrynan.presentation

/**
 * A component that can create a [Presenter]. This allows lazy instantiation of a [Presenter] which
 * may be required to wait for the [View] to be created first, then passing that into the [invoke]
 * function to create the [Presenter] that will be bound to that [View].
 */
fun interface PresenterFactory<I : Intent, S : State, C : Change> {

    operator fun invoke(view: View<I, S>): Presenter<I, S, C>

    companion object
}
