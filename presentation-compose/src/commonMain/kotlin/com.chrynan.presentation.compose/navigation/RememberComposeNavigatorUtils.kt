@file:Suppress("unused")

package com.chrynan.presentation.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chrynan.presentation.compose.PresentationComposeExperimentalApi
import com.chrynan.presentation.navigation.NavigationIntent

@PresentationComposeExperimentalApi
@Composable
fun <T> rememberNavigatorByContent(
    initialKey: T,
    initialContent: @Composable () -> Unit
): ComposeNavigatorByContentViewModel<T> = remember {
    ComposeNavigatorByContentViewModel(
        initialKey = initialKey,
        initialContent = initialContent
    )
}

@PresentationComposeExperimentalApi
@Composable
fun <T> rememberNavigatorByKey(
    initialKey: T,
    content: @Composable (key: T) -> Unit
): ComposeNavigatorByKeyViewModel<T> = remember {
    ComposeNavigatorByKeyViewModel(
        initialKey = initialKey,
        content = content
    )
}

@PresentationComposeExperimentalApi
@Composable
fun <I : NavigationIntent> rememberNavigatorByIntent(
    initialIntent: I,
    content: @Composable (intent: I) -> Unit
): ComposeNavigationIntentNavigatorByKeyViewModel<I> = remember {
    ComposeNavigationIntentNavigatorByKeyViewModel(
        initialKey = initialIntent,
        content = content
    )
}
