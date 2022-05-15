@file:Suppress("unused")

package com.chrynan.presentation

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * A component that can create a [ViewModel]. This allows lazy instantiation of a [ViewModel] which
 * may be required to wait for the [View] to be created first, then passing that into the [invoke]
 * function to create the [ViewModel] that will be bound to that [View].
 *
 * Note that this interface is a functional interface, so an instance can be created like so:
 * ```kotlin
 * ViewModelFactory { ... }
 * ```
 *
 * Example usage:
 * ```kotlin
 * ViewModelFactory {
 *     ViewModel {
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
fun interface ViewModelFactory<I : Intent, S : State, C : Change> {

    operator fun invoke(): ViewModel<I, S, C>

    companion object
}

internal class ViewModelFactoryDelegate<I : Intent, S : State, C : Change>(
    private val factory: ViewModelFactory<I, S, C>,
    private val retainInstance: Boolean = true
) : ReadOnlyProperty<View<I, S, C>, ViewModel<I, S, C>> {

    private var viewModel: ViewModel<I, S, C>? = null

    override operator fun getValue(thisRef: View<I, S, C>, property: KProperty<*>): ViewModel<I, S, C> =
        if (retainInstance) {
            var currentViewModel = viewModel

            if (currentViewModel == null) {
                currentViewModel = factory.invoke()

                viewModel = currentViewModel

                currentViewModel
            } else {
                currentViewModel
            }
        } else {
            factory.invoke()
        }
}

/**
 * Creates a [ViewModelFactory] delegate.
 *
 * Example usage:
 *
 * ```kotlin
 * val viewModel by viewModelFactory {
 *     ViewModel {
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
fun <I : Intent, S : State, C : Change> viewModelFactory(
    retainInstance: Boolean = true,
    factory: ViewModelFactory<I, S, C>
): ReadOnlyProperty<View<I, S, C>, ViewModel<I, S, C>> =
    ViewModelFactoryDelegate(factory = factory, retainInstance = retainInstance)

/**
 * Creates a [ViewModelFactory] delegate.
 *
 * Example usage:
 *
 * ```kotlin
 * val viewModel by viewModelFactory {
 *     ViewModel {
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
fun <I : Intent, S : State, C : Change> viewModelFactory(
    retainInstance: Boolean = true,
    factory: () -> ViewModel<I, S, C>
): ReadOnlyProperty<View<I, S, C>, ViewModel<I, S, C>> =
    ViewModelFactoryDelegate(factory = factory, retainInstance = retainInstance)
