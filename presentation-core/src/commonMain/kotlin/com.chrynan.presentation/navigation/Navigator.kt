@file:Suppress("unused")

package com.chrynan.presentation.navigation

/**
 * A [Navigator] is responsible for changing and showing the different Screens in the application.
 */
interface Navigator<I : NavigationIntent, S : NavigationScope> {

    /**
     * The [NavigationHandler] that is used to change between the different screens of the app.
     *
     * Note that this is provided for convenience, such as checking which handler was set, but the
     * functions of the [handler] should not be invoked directly. Instead, let this [Navigator]
     * properly handle invoking the [handler] functions.
     */
    val handler: NavigationHandler<I, S>

    /**
     * Navigates to the provided [event].
     */
    fun navigate(event: NavigationEvent<I>)

    companion object
}
