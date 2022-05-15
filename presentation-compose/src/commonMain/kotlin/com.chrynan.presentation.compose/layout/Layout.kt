@file:Suppress("unused")

package com.chrynan.presentation.compose.layout

import androidx.compose.runtime.*
import com.chrynan.presentation.*
import com.chrynan.presentation.State
import com.chrynan.presentation.Change

/**
 * A component that implements the [View] interface and serves as the binding between this presentation library and
 * Jetpack Compose. Typically, [Layout]s are used to represent the "Screen" components in an application.
 *
 * Example usage:
 * ```
 * class HomeLayout : Layout<HomeIntent, HomeState, HomeChange>() {
 *
 *     override val viewModel = ...
 *
 *     override fun Content() {
 *         val state by stateChanges()
 *
 *         // Put Composable UI code here using the [state] value
 *     }
 * }
 * ```
 */
@Stable
abstract class Layout<I : Intent, S : State, C : Change> : View<I, S, C>,
    Bindable {

    open val key: Any? = this::class.simpleName

    abstract override val viewModel: ViewModel<I, S, C>

    override val renderState: S?
        get() = viewModel.currentState

    override val isBound: Boolean
        get() = viewModel.isBound

    /**
     * Renders the UI content for this Layout.
     *
     * Example usage:
     * ```
     * @Composable
     * override fun Content() {
     *     val state by stateChanges()
     *
     *     Text("State = $state")
     * }
     * ```
     */
    @Composable
    abstract fun Content()

    final override fun bind() {
        if (!isBound) {
            viewModel.bind()

            onBind()
        }
    }

    final override fun unbind() {
        if (isBound) {
            onUnbind()

            viewModel.unbind()
        }
    }

    protected open fun onBind() {
    }

    protected open fun onUnbind() {
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Layout<*, *, *>) return false

        return this.key == other.key
    }

    override fun hashCode(): Int = key?.hashCode() ?: super.hashCode()

    override fun toString(): String = "Layout(key=$key,renderState=$renderState,isBound=$isBound)"
}

/**
 * Creates a [Layout] with the provided [key], [viewModelFactory], and [content] parameters.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <I : Intent, S : State, C : Change> layout(
    key: Any? = null,
    viewModelFactory: ViewModelFactory<I, S, C>,
    noinline content: @Composable () -> Unit
): Layout<I, S, C> =
    object : Layout<I, S, C>() {

        override val key: Any?
            get() = key

        override val viewModel: ViewModel<I, S, C> by viewModelFactory(factory = viewModelFactory)

        @Composable
        override fun Content() {
            content.invoke()
        }
    }

/**
 * Creates a [Layout] with the provided [key], [viewModel], and [content] parameters.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <I : Intent, S : State, C : Change> layout(
    key: Any? = null,
    viewModel: ViewModel<I, S, C>,
    noinline content: @Composable () -> Unit
): Layout<I, S, C> =
    object : Layout<I, S, C>() {

        override val key: Any?
            get() = key

        override val viewModel: ViewModel<I, S, C> = viewModel

        @Composable
        override fun Content() {
            content.invoke()
        }
    }

/**
 * Renders the provided [layout] as a [Composable].
 *
 * Example usage:
 * ```kotlin
 * @Composable
 * fun Home {
 *     ComposeLayout(homeLayout)
 * }
 * ```
 */
@Composable
@Stable
fun <I : Intent, S : State, C : Change> ComposeLayout(layout: Layout<I, S, C>) {
    val rememberedLayout by rememberUpdatedState(layout)

    DisposableEffect(key1 = layout.key) {
        rememberedLayout.bind()
        onDispose { rememberedLayout.unbind() }
    }

    rememberedLayout.Content()
}

/**
 * Lays out the provided [layout] as a [Composable].
 *
 * This is a convenience function for calling [ComposeLayout].
 *
 * Example usage:
 * ```kotlin
 * @Composable
 * fun Home {
 *     +HomeLayout()
 * }
 * ```
 *
 * @see [ComposeLayout]
 */
@Composable
inline operator fun <reified I : Intent, reified S : State, reified C : Change> Layout<I, S, C>.unaryPlus() {
    ComposeLayout(layout = this)
}
