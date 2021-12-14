@file:Suppress("unused")

package com.chrynan.presentation.navigation

/**
 * A convenience function for calling [Navigator.navigate] with [NavigationEvent.Back].
 */
fun <I : NavigationIntent> Navigator<I>.goBack() =
    navigate(event = NavigationEvent.Back())

/**
 * A convenience function for calling [Navigator.navigate] with [NavigationEvent.Up].
 */
fun <I : NavigationIntent> Navigator<I>.goUp() =
    navigate(event = NavigationEvent.Up())

/**
 * A convenience function for calling [Navigator.navigate] with [NavigationEvent.To].
 */
fun <I : NavigationIntent> Navigator<I>.goTo(intent: I) =
    navigate(event = NavigationEvent.To(intent = intent))
