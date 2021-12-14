package com.chrynan.presentation.navigation

/**
 * A [NavigationHandler] used on the Android platform that uses an [AndroidNavigationScope].
 */
fun interface AndroidNavigationHandler<I : NavigationIntent> : NavigationHandler<I, AndroidNavigationScope>
