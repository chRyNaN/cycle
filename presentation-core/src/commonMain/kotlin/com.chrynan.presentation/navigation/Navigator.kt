@file:Suppress("unused")

package com.chrynan.presentation.navigation

/**
 * A [Navigator] is responsible for changing and showing the different Screens in the application.
 */
interface Navigator<I : NavigationIntent> {

    /**
     * Navigates to the provided [event].
     */
    fun navigate(event: NavigationEvent<I>)

    companion object
}
