@file:Suppress("unused")

package com.chrynan.presentation.compose

import android.app.Activity
import androidx.navigation.NavController
import com.chrynan.presentation.NavigationScope

interface AndroidComposeNavigationScope : NavigationScope {

    val activity: Activity
    val navController: NavController
}

internal class SimpleAndroidComposeNavigationScope(
    override val activity: Activity,
    override val navController: NavController
) : AndroidComposeNavigationScope

internal fun AndroidComposeNavigationScope(
    activity: Activity,
    navController: NavController
): AndroidComposeNavigationScope = SimpleAndroidComposeNavigationScope(
    activity = activity,
    navController = navController
)
