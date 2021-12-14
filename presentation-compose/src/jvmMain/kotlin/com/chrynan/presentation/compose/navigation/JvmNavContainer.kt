package com.chrynan.presentation.compose.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.chrynan.presentation.compose.PresentationComposeExperimentalApi

@Composable
@PresentationComposeExperimentalApi
internal actual fun <T> InternalNavContainer(
    navigator: BaseComposeNavigatorByContentViewModel<T>
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    Box {
        navigator.content(contentKey)
    }
}

@Composable
@PresentationComposeExperimentalApi
internal actual fun <T> InternalNavContainer(
    navigator: BaseComposeNavigatorByKeyViewModel<T>
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    Box {
        navigator.content(contentKey)
    }
}
