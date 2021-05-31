@file:Suppress("unused")

package com.chrynan.presentation.compose

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chrynan.presentation.NavigationEvent
import com.chrynan.presentation.NavigationHandler
import com.chrynan.presentation.NavigationIntent
import com.chrynan.presentation.Navigator

class AndroidComposeNavigator<I : NavigationIntent> internal constructor(
    override val handler: NavigationHandler<I, AndroidComposeNavigationScope>,
    private val scope: AndroidComposeNavigationScope
) : Navigator<I, AndroidComposeNavigationScope> {

    override fun navigate(event: NavigationEvent<I>) {
        handler.apply {
            scope.onNavigate(event = event)
        }
    }
}

@Composable
fun <I : NavigationIntent> navigator(
    activity: Activity? = null,
    navController: NavController? = null,
    handler: NavigationHandler<I, AndroidComposeNavigationScope>
): Navigator<I, AndroidComposeNavigationScope> {
    val localActivity = activity ?: (LocalContext.current as Activity)
    val localNavController = navController ?: rememberNavController()
    val scope =
        AndroidComposeNavigationScope(activity = localActivity, navController = localNavController)

    return AndroidComposeNavigator(handler = handler, scope = scope)
}

@Composable
fun <I : NavigationIntent> navigator(
    activity: Activity? = null,
    navController: NavController? = null,
    handler: AndroidComposeNavigationScope.(event: NavigationEvent<I>) -> Unit
): Navigator<I, AndroidComposeNavigationScope> {
    val localActivity = activity ?: (LocalContext.current as Activity)
    val localNavController = navController ?: rememberNavController()
    val scope =
        AndroidComposeNavigationScope(activity = localActivity, navController = localNavController)
    val composeHandler = object : NavigationHandler<I, AndroidComposeNavigationScope> {

        override fun AndroidComposeNavigationScope.onNavigate(event: NavigationEvent<I>) {
            handler.invoke(this, event)
        }
    }

    return AndroidComposeNavigator(handler = composeHandler, scope = scope)
}
