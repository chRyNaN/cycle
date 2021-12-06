@file:Suppress("unused")

package com.chrynan.presentation.compose.navigation

import androidx.compose.runtime.Composable
import com.chrynan.presentation.compose.PresentationComposeExperimentalApi

@Composable
@PresentationComposeExperimentalApi
internal expect fun <T> InternalNavContainer(navigator: BaseComposeNavigatorByContentViewModel<T>)

@Composable
@PresentationComposeExperimentalApi
internal expect fun <T> InternalNavContainer(navigator: BaseComposeNavigatorByKeyViewModel<T>)

@Composable
@PresentationComposeExperimentalApi
fun <T> NavContainer(navigator: BaseComposeNavigatorByContentViewModel<T>) {
    InternalNavContainer(navigator = navigator)
}

@Composable
@PresentationComposeExperimentalApi
fun <T> NavContainer(navigator: BaseComposeNavigatorByKeyViewModel<T>) {
    InternalNavContainer(navigator = navigator)
}
