@file:Suppress("unused")

package com.chrynan.presentation

import android.app.Activity

class AndroidNavigator<I : NavigationIntent> internal constructor(
    override val handler: AndroidNavigationHandler<I>,
    private val scope: AndroidNavigationScope
) : Navigator<I, AndroidNavigationScope> {

    override fun navigate(event: NavigationEvent<I>) {
        handler.apply {
            scope.onNavigate(event = event)
        }
    }
}

fun <I : NavigationIntent> navigator(
    activity: Activity,
    handler: AndroidNavigationHandler<I>
): Navigator<I, AndroidNavigationScope> {
    val scope = AndroidNavigationScope(activity = activity)

    return AndroidNavigator(handler = handler, scope = scope)
}

fun <I : NavigationIntent> navigator(
    activity: Activity,
    handler: AndroidNavigationScope.(event: NavigationEvent<I>) -> Unit
): Navigator<I, AndroidNavigationScope> {
    val scope = AndroidNavigationScope(activity = activity)

    val androidHandler = AndroidNavigationHandler<I> { event -> handler.invoke(this, event) }

    return AndroidNavigator(handler = androidHandler, scope = scope)
}
