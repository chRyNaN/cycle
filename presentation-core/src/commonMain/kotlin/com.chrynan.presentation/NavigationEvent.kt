@file:Suppress("unused")

package com.chrynan.presentation

sealed class NavigationEvent<I : NavigationIntent> {

    class Back<I : NavigationIntent> : NavigationEvent<I>()

    class Up<I : NavigationIntent> : NavigationEvent<I>()

    data class To<I : NavigationIntent>(val intent: I) : NavigationEvent<I>()

    companion object
}
