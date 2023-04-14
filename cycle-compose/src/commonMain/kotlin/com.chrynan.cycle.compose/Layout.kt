@file:Suppress("unused")

package com.chrynan.cycle.compose

import androidx.compose.runtime.*
import com.chrynan.cycle.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

/**
 * A component that implements the [View] interface and serves as the binding between this presentation library and
 * Jetpack Compose. Typically, [Layout]s are used to represent the "Screen" components in an application.
 *
 * Example usage:
 * ```
 * class HomeLayout : Layout<HomeState, HomeChange>() {
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
@FlowPreview
@ExperimentalCoroutinesApi
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
     * Renders the UI content for this Layout. Remember to subscribe to the state changes using the [stateChanges]
     * function within this function. Using the [renderState] property won't work because it won't trigger a
     * recomposition of the composable function when the state changes.
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
    @Suppress("FunctionName")
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

    override fun toString(): String = "Layout(key=$key,renderState=$renderState,isBound=$isBound,viewModel=$viewModel)"
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
@ExperimentalCoroutinesApi
@FlowPreview
@Suppress("FunctionName")
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
 * Renders this [Layout] as a [Composable].
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
@ExperimentalCoroutinesApi
@FlowPreview
@Composable
inline operator fun <reified State, reified Change> Layout<State, Change>.unaryPlus() {
    ComposeLayout(layout = this)
}
