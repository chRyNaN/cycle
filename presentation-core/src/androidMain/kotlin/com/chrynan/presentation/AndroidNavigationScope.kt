@file:Suppress("unused")

package com.chrynan.presentation

import android.app.Activity
import com.chrynan.presentation.navigation.NavigationScope

interface AndroidNavigationScope : NavigationScope {

    val activity: Activity
}

internal class SimpleAndroidNavigationScope(
    override val activity: Activity,
) : AndroidNavigationScope

@Suppress("FunctionName")
internal fun AndroidNavigationScope(
    activity: Activity,
): AndroidNavigationScope = SimpleAndroidNavigationScope(
    activity = activity
)
