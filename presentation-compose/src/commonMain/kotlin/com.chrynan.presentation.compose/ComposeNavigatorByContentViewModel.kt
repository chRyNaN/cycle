package com.chrynan.presentation.compose

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

@PresentationComposeExperimentalApi
class ComposeNavigatorByContentViewModel<T> internal constructor(
    override val initialKey: T,
    private val initialContent: @Composable () -> Unit
) : BaseComposeNavigatorByContentViewModel<T>() {

    override val keyChanges: Flow<T>
        get() = mutableKeyFlow.filterNotNull()

    override val currentKey: T?
        get() = mutableKeyFlow.value

    override var isInitialized: Boolean = false
        private set

    private val mutableKeyFlow = MutableStateFlow<T?>(value = null)

    private val contents = mutableMapOf<T, (@Composable () -> Unit)>()
    private val keyStack = mutableListOf<T>()

    @Composable
    override fun goTo(
        key: T,
        strategy: NavStackDuplicateContentStrategy,
        content: @Composable () -> Unit
    ) {
        if (contents.containsKey(key) && strategy == NavStackDuplicateContentStrategy.CLEAR_STACK) {
            // Go Back to the content with the provided key using the updated content
            var lastKey = keyStack.lastOrNull()

            while (lastKey != null && lastKey != key) {
                keyStack.removeLast()

                if (!keyStack.contains(lastKey)) {
                    contents.remove(lastKey)
                }

                lastKey = keyStack.lastOrNull()
            }

            // Replace the content with the updated content
            contents[key] = content
            mutableKeyFlow.value = key
        } else {
            // Go to the provided content
            addToStack(key = key, content = content)
        }
    }

    @Composable
    override fun goBack(): Boolean {
        val wentBack = canGoBack()

        if (wentBack) {
            removeLastFromStack()
        }

        return wentBack
    }

    override fun canGoBack(): Boolean = contents.isNotEmpty() && keyStack.isNotEmpty()

    @Composable
    override fun getContent(key: T): (@Composable () -> Unit)? {
        if (contents.isEmpty()) {
            addToStack(key = key, content = initialContent)

            isInitialized = true
        }

        return contents[key]
    }

    private fun addToStack(
        key: T,
        content: @Composable () -> Unit
    ) {
        contents[key] = content
        keyStack.add(key)
        mutableKeyFlow.value = key
    }

    private fun removeLastFromStack() {
        val removedKey = keyStack.removeLast()

        if (!keyStack.contains(removedKey)) {
            contents.remove(removedKey)
        }

        mutableKeyFlow.value = keyStack.lastOrNull()
    }
}
