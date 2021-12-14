package com.chrynan.presentation

import com.chrynan.presentation.navigation.NavigationHandler
import com.chrynan.presentation.navigation.NavigationIntent

fun interface AndroidNavigationHandler<I : NavigationIntent> : NavigationHandler<I, AndroidNavigationScope>
