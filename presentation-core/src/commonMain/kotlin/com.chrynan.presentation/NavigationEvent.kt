@file:Suppress("unused")

package com.chrynan.presentation

sealed class NavigationEvent<I : NavigationIntent> {

    object Back : NavigationEvent<NavigationIntent>()

    object Up : NavigationEvent<NavigationIntent>()

    data class To<I : NavigationIntent>(val intent: I) : NavigationEvent<I>()
}
