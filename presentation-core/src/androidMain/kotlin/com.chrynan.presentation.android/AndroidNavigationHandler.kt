package com.chrynan.presentation.android

import com.chrynan.presentation.NavigationHandler
import com.chrynan.presentation.NavigationIntent

interface AndroidNavigationHandler<I : NavigationIntent> :
    NavigationHandler<I, AndroidNavigationScope>
