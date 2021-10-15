package com.chrynan.presentation.compose

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

@PresentationComposeExperimentalApi
class ComposeNavigatorByContentViewModel internal constructor(
    override val initialKey: Any,
    private val initialContent: @Composable () -> Unit
) : BaseComposeNavigatorByContentViewModel() {

    override val keyChanges: Flow<Any>
        get() = mutableKeyFlow.filterNotNull()

    override val currentKey: Any?
        get() = mutableKeyFlow.value

    override var isInitialized: Boolean = false
        private set

    private val mutableKeyFlow = MutableStateFlow<Any?>(value = null)

    private val contents = mutableMapOf<Any, (@Composable () -> Unit)>()
    private val keyStack = mutableListOf<Any>()

    @Composable
    override fun goTo(
        key: Any?,
        strategy: NavStackDuplicateContentStrategy,
        content: @Composable () -> Unit
    ) {
        val nonNullKey = getNonNullKey(providedKey = key)

        if (contents.containsKey(nonNullKey) && strategy == NavStackDuplicateContentStrategy.CLEAR_STACK) {
            // Go Back to the content with the provided key using the updated content
            var lastKey = keyStack.lastOrNull()

            while (lastKey != null && lastKey != nonNullKey) {
                keyStack.removeLast()

                if (!keyStack.contains(lastKey)) {
                    contents.remove(lastKey)
                }

                lastKey = keyStack.lastOrNull()
            }

            // Replace the content with the updated content
            contents[nonNullKey] = content
            mutableKeyFlow.value = nonNullKey
        } else {
            // Go to the provided content
            addToStack(key = nonNullKey, content = content)
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
    override fun getContent(key: Any): (@Composable () -> Unit)? {
        if (contents.isEmpty()) {
            val initialNonNullKey = getNonNullKey(providedKey = initialKey)

            addToStack(key = initialNonNullKey, content = initialContent)

            isInitialized = true
        }

        return contents[key]
    }

    private fun addToStack(
        key: Any,
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
