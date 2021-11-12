package com.chrynan.presentation

fun interface AndroidNavigationHandler<I : NavigationIntent> :
    NavigationHandler<I, AndroidNavigationScope>
