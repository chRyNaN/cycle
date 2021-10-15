package com.chrynan.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Suppress("unused")
@Composable
@PresentationComposeExperimentalApi
fun NavContainer(
    navigator: BaseComposeNavigatorByContentViewModel
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)
    val content = navigator.getContent(contentKey)

    Box {
        content?.invoke()
    }
}

@Suppress("unused")
@Composable
@PresentationComposeExperimentalApi
fun NavContainer(
    navigator: BaseComposeNavigatorByKeyViewModel
) {
    val contentKey by navigator.keyChanges.collectAsState(initial = navigator.initialKey)

    Box {
        navigator.content(contentKey)
    }
}
