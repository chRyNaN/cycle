@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.flow.Flow
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * An extension on a [PresenterFactory] that returns a [BasePresenter] instead of just a [Presenter].
 */
fun interface BasePresenterFactory<I : Intent, S : State, C : Change> : PresenterFactory<I, S, C> {

    override fun invoke(intents: Flow<I>): BasePresenter<I, S, C>

    companion object
}

operator fun <I : Intent, S : State, C : Change> BasePresenterFactory<I, S, C>.invoke(view: View<I, S>): BasePresenter<I, S, C> =
    invoke(intents = view.intents())

internal class BasePresenterFactoryDelegate<I : Intent, S : State, C : Change>(
    private val factory: BasePresenterFactory<I, S, C>,
    private val retainInstance: Boolean = true
) : ReadOnlyProperty<View<I, S>, Presenter<I, S, C>> {

    private var presenter: BasePresenter<I, S, C>? = null

    override operator fun getValue(thisRef: View<I, S>, property: KProperty<*>): BasePresenter<I, S, C> =
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

fun <I : Intent, S : State, C : Change> basePresenterFactory(
    retainInstance: Boolean = true,
    factory: BasePresenterFactory<I, S, C>
): ReadOnlyProperty<View<I, S>, Presenter<I, S, C>> =
    BasePresenterFactoryDelegate(factory = factory, retainInstance = retainInstance)

fun <I : Intent, S : State, C : Change> basePresenterFactory(
    retainInstance: Boolean = true,
    factory: (intents: Flow<I>) -> BasePresenter<I, S, C>
): ReadOnlyProperty<View<I, S>, Presenter<I, S, C>> =
    BasePresenterFactoryDelegate(factory = factory, retainInstance = retainInstance)
