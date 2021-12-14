@file:Suppress("unused")

package com.chrynan.presentation.navigation

/**
 * A convenience function for calling [Navigator.navigate] with [NavigationEvent.Back].
 */
fun <I : NavigationIntent, S : NavigationScope> Navigator<I, S>.goBack() =
    navigate(event = NavigationEvent.Back())

/**
 * A convenience function for calling [Navigator.navigate] with [NavigationEvent.Up].
 */
fun <I : NavigationIntent, S : NavigationScope> Navigator<I, S>.goUp() =
    navigate(event = NavigationEvent.Up())

/**
 * A convenience function for calling [Navigator.navigate] with [NavigationEvent.To].
 */
fun <I : NavigationIntent, S : NavigationScope> Navigator<I, S>.goTo(intent: I) =
    navigate(event = NavigationEvent.To(intent = intent))
