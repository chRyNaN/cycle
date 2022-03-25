@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.flow.Flow
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * A component that can create a [Presenter]. This allows lazy instantiation of a [Presenter] which
 * may be required to wait for the [View] to be created first, then passing that into the [invoke]
 * function to create the [Presenter] that will be bound to that [View].
 *
 * Note that this interface is a functional interface, so an instance can be created like so:
 * ```kotlin
 * PresenterFactory { intents -> }
 * ```
 *
 * Example usage:
 * ```kotlin
 * PresenterFactory { intents ->
 *     Presenter(intents) {
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

internal class PresenterFactoryDelegate<I : Intent, S : State, C : Change>(
    private val factory: PresenterFactory<I, S, C>,
    private val retainInstance: Boolean = true
) : ReadOnlyProperty<View<I, S>, Presenter<I, S, C>> {

    private var presenter: Presenter<I, S, C>? = null

    override operator fun getValue(thisRef: View<I, S>, property: KProperty<*>): Presenter<I, S, C> =
        if (retainInstance) {
            var currentPresenter = presenter

            if (currentPresenter == null) {
                currentPresenter = factory.invoke(thisRef.intents())

                presenter = currentPresenter

                currentPresenter
            } else {
                currentPresenter
            }
        } else {
            factory.invoke(thisRef.intents())
        }
}

/**
 * Creates a [PresenterFactory] delegate.
 *
 * Example usage:
 *
 * ```kotlin
 * val presenter by presenterFactory { intents ->
 *     Presenter(intents) {
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
fun <I : Intent, S : State, C : Change> presenterFactory(
    retainInstance: Boolean = true,
    factory: PresenterFactory<I, S, C>
): ReadOnlyProperty<View<I, S>, Presenter<I, S, C>> =
    PresenterFactoryDelegate(factory = factory, retainInstance = retainInstance)

/**
 * Creates a [PresenterFactory] delegate.
 *
 * Example usage:
 *
 * ```kotlin
 * val presenter by presenterFactory { intents ->
 *     Presenter(intents) {
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
fun <I : Intent, S : State, C : Change> presenterFactory(
    retainInstance: Boolean = true,
    factory: (intents: Flow<I>) -> Presenter<I, S, C>
): ReadOnlyProperty<View<I, S>, Presenter<I, S, C>> =
    PresenterFactoryDelegate(factory = factory, retainInstance = retainInstance)
