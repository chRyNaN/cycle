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
}

@PresentationComposeExperimentalApi
interface ComposeNavigatorByContent : ComposeNavigator {

    @Composable
    fun goTo(
        key: Any?,
        strategy: NavStackDuplicateContentStrategy,
        content: @Composable () -> Unit
    )
}

@PresentationComposeExperimentalApi
interface ComposeNavigatorByKey : ComposeNavigator {

    fun goTo(
        key: Any,
        strategy: NavStackDuplicateContentStrategy = NavStackDuplicateContentStrategy.CLEAR_STACK
    )
}

@Suppress("unused")
@Composable
@PresentationComposeExperimentalApi
fun ComposeNavigatorByContent.goTo(
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
fun ComposeNavigatorByContent.goTo(
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
fun ComposeNavigatorByContent.goTo(
    content: @Composable () -> Unit
) = goTo(
    key = null,
    strategy = NavStackDuplicateContentStrategy.CLEAR_STACK,
    content = content
)

@PresentationComposeExperimentalApi
interface ComposeStackNavigator : ComposeNavigator {

    fun canGoBack(): Boolean
}

@PresentationComposeExperimentalApi
interface ComposeStackNavigatorByContent : ComposeStackNavigator {

    @Composable
    fun goBack(): Boolean
}

@PresentationComposeExperimentalApi
interface ComposeStackNavigatorByKey : ComposeStackNavigator {

    fun goBack(): Boolean
}

@PresentationComposeExperimentalApi
abstract class BaseComposeNavigatorByContentViewModel : ViewModel(),
    ComposeNavigator,
    ComposeNavigatorByContent,
    ComposeStackNavigatorByContent {

    @Composable
    internal abstract fun getContent(key: Any): (@Composable () -> Unit)?
}

@PresentationComposeExperimentalApi
abstract class BaseComposeNavigatorByKeyViewModel : ViewModel(),
    ComposeNavigator,
    ComposeNavigatorByKey,
    ComposeStackNavigatorByKey {

    internal abstract val content: @Composable (key: Any) -> Unit
}

@Suppress("unused")
@PresentationComposeExperimentalApi
@Composable
fun rememberComposeNavigatorByContent(
    initialKey: Any? = null,
    initialContent: @Composable () -> Unit
): BaseComposeNavigatorByContentViewModel {
    val nonNullInitialKey = getNonNullKey(providedKey = initialKey)

    return remember {
        ComposeNavigatorByContentViewModel(
            initialKey = nonNullInitialKey,
            initialContent = initialContent
        )
    }
}

@Suppress("unused")
@PresentationComposeExperimentalApi
@Composable
fun rememberComposeNavigatorByKey(
    initialKey: Any,
    content: @Composable (key: Any) -> Unit
): BaseComposeNavigatorByKeyViewModel = remember {
    ComposeNavigatorByKeyViewModel(
        initialKey = initialKey,
        content = content
    )
}
