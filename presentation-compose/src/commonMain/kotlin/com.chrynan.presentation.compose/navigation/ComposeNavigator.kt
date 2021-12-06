package com.chrynan.presentation.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.Flow
import com.chrynan.presentation.ViewModel
import com.chrynan.presentation.compose.PresentationComposeExperimentalApi

@PresentationComposeExperimentalApi
interface ComposeNavigator<T> {

    val initialKey: T

    val currentKey: T?

    val keyChanges: Flow<T>

    val isInitialized: Boolean
}

@PresentationComposeExperimentalApi
interface ComposeNavigatorByContent<T> : ComposeNavigator<T> {

    @Composable
    fun goTo(
        key: T,
        strategy: NavStackDuplicateContentStrategy,
        content: @Composable () -> Unit
    )
}

// Note: This is needed because defaults aren't working for @Composable functions for interfaces.
@Suppress("unused")
@PresentationComposeExperimentalApi
@Composable
fun <T> ComposeNavigatorByContent<T>.goTo(key: T, content: @Composable () -> Unit) =
    goTo(key = key, strategy = NavStackDuplicateContentStrategy.CLEAR_STACK, content = content)

@PresentationComposeExperimentalApi
interface ComposeNavigatorByKey<T> : ComposeNavigator<T> {

    fun goTo(
        key: T,
        strategy: NavStackDuplicateContentStrategy
    )
}

// Note: This is needed because defaults aren't working for @Composable functions for interfaces.
@Suppress("unused")
@PresentationComposeExperimentalApi
fun <T> ComposeNavigatorByKey<T>.goTo(key: T) =
    goTo(key = key, strategy = NavStackDuplicateContentStrategy.CLEAR_STACK)

@PresentationComposeExperimentalApi
interface ComposeStackNavigator<T> : ComposeNavigator<T> {

    fun canGoBack(): Boolean
}

@PresentationComposeExperimentalApi
interface ComposeStackNavigatorByContent<T> : ComposeStackNavigator<T>,
    ComposeNavigatorByContent<T> {

    @Composable
    fun goBack(): Boolean
}

@PresentationComposeExperimentalApi
interface ComposeStackNavigatorByKey<T> : ComposeStackNavigator<T>,
    ComposeNavigatorByKey<T> {

    fun goBack(): Boolean
}

@PresentationComposeExperimentalApi
abstract class BaseComposeNavigatorByContentViewModel<T> : ViewModel(),
    ComposeNavigator<T>,
    ComposeNavigatorByContent<T>,
    ComposeStackNavigatorByContent<T> {

    @Composable
    internal abstract fun getContent(key: T): (@Composable () -> Unit)?
}

@PresentationComposeExperimentalApi
abstract class BaseComposeNavigatorByKeyViewModel<T> : ViewModel(),
    ComposeNavigator<T>,
    ComposeNavigatorByKey<T>,
    ComposeStackNavigatorByKey<T> {

    internal abstract val content: @Composable (key: T) -> Unit
}

@Suppress("unused")
@PresentationComposeExperimentalApi
@Composable
fun <T> rememberComposeNavigatorByContent(
    initialKey: T,
    initialContent: @Composable () -> Unit
): ComposeNavigatorByContentViewModel<T> = remember {
    ComposeNavigatorByContentViewModel(
        initialKey = initialKey,
        initialContent = initialContent
    )
}

@Suppress("unused")
@PresentationComposeExperimentalApi
@Composable
fun <T> rememberComposeNavigatorByKey(
    initialKey: T,
    content: @Composable (key: T) -> Unit
): ComposeNavigatorByKeyViewModel<T> = remember {
    ComposeNavigatorByKeyViewModel(
        initialKey = initialKey,
        content = content
    )
}
