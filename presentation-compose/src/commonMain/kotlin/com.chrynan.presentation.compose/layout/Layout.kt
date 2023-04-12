@file:Suppress("unused")

package com.chrynan.presentation.compose.layout

import androidx.compose.runtime.*
import com.chrynan.presentation.*

/**
 * A component that implements the [View] interface and serves as the binding between this presentation library and
 * Jetpack Compose. Typically, [Layout]s are used to represent the "Screen" components in an application.
 *
 * Example usage:
 * ```
 * class HomeLayout : Layout<HomeIntent, HomeState, HomeChange>() {
 *
 *     override val viewModel = ViewModel<I, S, C>(
 *             perform = { intent, state -> ... },
 *             reduce = { state, change -> ... })
 *
 *     @Composable
 *     override fun Content() {
 *         val state by stateChanges()
 *
 *         // Put Composable UI code here using the [state] value
 *     }
 * }
 * ```
 */
@Stable
abstract class Layout<State, Change> : View<State, Change>,
    Bindable {

    open val key: Any? = this::class.simpleName

    abstract override val viewModel: ViewModel<State, Change>

    final override val renderState: State?
        get() = viewModel.currentState

    final override val isBound: Boolean
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
        if (other !is Layout<*, *>) return false

        return this.key == other.key
    }

    override fun hashCode(): Int = key?.hashCode() ?: super.hashCode()

    override fun toString(): String = "Layout(key=$key,renderState=$renderState,isBound=$isBound)"
}

/**
 * Creates a [Layout] with the provided [key], [viewModel], and [content] parameters.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <State, Change> layout(
    key: Any? = null,
    viewModel: ViewModel<State, Change>,
    noinline content: @Composable () -> Unit
): Layout<State, Change> =
    object : Layout<State, Change>() {

        override val key: Any?
            get() = key

        override val viewModel: ViewModel<State, Change> = viewModel

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
fun <State, Change> ComposeLayout(layout: Layout<State, Change>) {
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
inline operator fun <reified State, reified Change> Layout<State, Change>.unaryPlus() {
    ComposeLayout(layout = this)
}
