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
    private val factory: PresenterFactory<I, S, C>
) : ReadOnlyProperty<View<I, S>, Presenter<I, S, C>> {

    override operator fun getValue(thisRef: View<I, S>, property: KProperty<*>): Presenter<I, S, C> =
        factory.invoke(thisRef.intents())
}

fun <I : Intent, S : State, C : Change> presenterFactory(factory: PresenterFactory<I, S, C>): ReadOnlyProperty<View<I, S>, Presenter<I, S, C>> =
    PresenterFactoryDelegate(factory = factory)

fun <I : Intent, S : State, C : Change> presenterFactory(factory: (intents: Flow<I>) -> Presenter<I, S, C>): ReadOnlyProperty<View<I, S>, Presenter<I, S, C>> =
    PresenterFactoryDelegate(factory = factory)
