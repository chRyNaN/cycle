@file:Suppress("unused")

package com.chrynan.presentation

/**
 * A [Navigator] is responsible for changing and showing the different Screens in the application. When it receives
 * [ScreenIntent]s from calls to the [goTo] function and loads the appropriate Screen.
 */
interface Navigator<S : ScreenIntent> {

    /**
     * Goes back to the previous Screen.
     */
    fun goBack()

    /**
     * Goes up in the Screen stack. By default this is the same as calling [goBack]. Some platforms have differences
     * between the [goBack] and [goUp] functions for the Screen navigation flow, such as, on Android.
     */
    fun goUp() = goBack()

    /**
     * Goes to the appropriate Screen indicated by the provided [screen] [ScreenIntent].
     */
    fun goTo(screen: S)
}
