@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.flow.Flow

/**
 * An extension on a [PresenterFactory] that returns a [BasePresenter] instead of just a [Presenter].
 */
fun interface BasePresenterFactory<I : Intent, S : State, C : Change> : PresenterFactory<I, S, C> {

    override fun invoke(intents: Flow<I>): BasePresenter<I, S, C>

    companion object
}

operator fun <I : Intent, S : State, C : Change> BasePresenterFactory<I, S, C>.invoke(view: View<I, S>): BasePresenter<I, S, C> =
    invoke(intents = view.intents())
