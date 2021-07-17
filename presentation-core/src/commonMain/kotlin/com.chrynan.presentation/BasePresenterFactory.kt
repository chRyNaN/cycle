@file:Suppress("unused")

package com.chrynan.presentation

/**
 * An extension on a [PresenterFactory] that returns a [BasePresenter] instead of just a [Presenter].
 */
fun interface BasePresenterFactory<I : Intent, S : State, C : Change> : PresenterFactory<I, S, C> {

    override fun invoke(view: View<I, S>): BasePresenter<I, S, C>

    companion object
}
