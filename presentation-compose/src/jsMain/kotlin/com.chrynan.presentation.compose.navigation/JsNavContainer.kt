package com.chrynan.presentation.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.chrynan.presentation.compose.PresentationComposeExperimentalApi
import org.jetbrains.compose.web.dom.Div

@Composable
@PresentationComposeExperimentalApi
internal actual fun <T> InternalNavContainer(
    navigator: BaseComposeNavigatorByContentViewModel<T>
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)
    val content = navigator.getContent(contentKey)

    Div {
        content?.invoke()
    }
}

@Composable
@PresentationComposeExperimentalApi
internal actual fun <T> InternalNavContainer(
    navigator: BaseComposeNavigatorByKeyViewModel<T>
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    Div {
        navigator.content(contentKey)
    }
}
