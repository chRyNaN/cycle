@file:Suppress("unused")

package com.chrynan.presentation.compose

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
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
fun <I : NavigationIntent> navigator(handler: NavigationHandler<I, AndroidComposeNavigationScope>): Navigator<I, AndroidComposeNavigationScope> {
    val activity = LocalContext.current as Activity
    val navController = rememberNavController()
    val scope = AndroidComposeNavigationScope(activity = activity, navController = navController)

    return AndroidComposeNavigator(handler = handler, scope = scope)
}

@Composable
fun <I : NavigationIntent> navigator(handler: AndroidComposeNavigationScope.(event: NavigationEvent<I>) -> Unit): Navigator<I, AndroidComposeNavigationScope> {
    val activity = LocalContext.current as Activity
    val navController = rememberNavController()
    val scope = AndroidComposeNavigationScope(activity = activity, navController = navController)
    val composeHandler = object : NavigationHandler<I, AndroidComposeNavigationScope> {

        override fun AndroidComposeNavigationScope.onNavigate(event: NavigationEvent<I>) {
            handler.invoke(this, event)
        }
    }

    return AndroidComposeNavigator(handler = composeHandler, scope = scope)
}
