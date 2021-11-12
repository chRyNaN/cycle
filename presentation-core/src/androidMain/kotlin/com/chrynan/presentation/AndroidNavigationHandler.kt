package com.chrynan.presentation

interface AndroidNavigationHandler<I : NavigationIntent> :
    NavigationHandler<I, AndroidNavigationScope>
