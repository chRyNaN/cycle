package com.chrynan.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.Flow

@PresentationComposeExperimentalApi
interface ComposeNavigator {

    val initialKey: Any

    val currentKey: Any?

    val keyChanges: Flow<Any>

    val isInitialized: Boolean

    @Composable
    fun goTo(
        key: Any?,
        strategy: NavStackDuplicateContentStrategy,
        content: @Composable () -> Unit
    )
}

@Suppress("unused")
@Composable
@PresentationComposeExperimentalApi
fun ComposeNavigator.goTo(
    strategy: NavStackDuplicateContentStrategy,
    content: @Composable () -> Unit
) = goTo(
    key = null,
    strategy = strategy,
    content = content
)

@Suppress("unused")
@Composable
@PresentationComposeExperimentalApi
fun ComposeNavigator.goTo(
    key: Any? = null,
    content: @Composable () -> Unit
) = goTo(
    key = key,
    strategy = NavStackDuplicateContentStrategy.CLEAR_STACK,
    content = content
)

@Suppress("unused")
@Composable
@PresentationComposeExperimentalApi
fun ComposeNavigator.goTo(
    content: @Composable () -> Unit
) = goTo(
    key = null,
    strategy = NavStackDuplicateContentStrategy.CLEAR_STACK,
    content = content
)

@PresentationComposeExperimentalApi
interface ComposeStackNavigator : ComposeNavigator {

    @Composable
    fun goBack(): Boolean

    fun canGoBack(): Boolean
}

@PresentationComposeExperimentalApi
abstract class BaseComposeNavigatorViewModel : ViewModel(),
    ComposeNavigator,
    ComposeStackNavigator {

    @Composable
    internal abstract fun getContent(key: Any): (@Composable () -> Unit)?
}

@Suppress("unused")
@PresentationComposeExperimentalApi
@Composable
fun rememberComposeNavigator(
    initialKey: Any? = null,
    initialContent: @Composable () -> Unit
): ComposeNavigatorViewModel {
    val nonNullInitialKey = getNonNullKey(providedKey = initialKey)

    return remember {
        ComposeNavigatorViewModel(
            initialKey = nonNullInitialKey,
            initialContent = initialContent
        )
    }
}
