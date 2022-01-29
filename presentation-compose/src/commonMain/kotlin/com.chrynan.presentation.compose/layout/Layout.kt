@file:Suppress("unused")

package com.chrynan.presentation.compose.layout

import androidx.compose.runtime.*
import com.chrynan.presentation.*
import com.chrynan.presentation.State
import com.chrynan.presentation.Change
import kotlinx.coroutines.flow.*

/**
 * A component that implements the [View] interface and serves as the binding between this
 * presentation library and Jetpack Compose.
 *
 * Example usage:
 * ```
 * class HomeLayout : BaseLayout<HomeIntent, HomeState, HomeChange>() {
 *
 *     override val presenterFactory = ...
 *
 *     override fun Content(state: HomeState) {
 *         // Put Composable UI code here using the [state] value
 *     }
 * }
 * ```
 */
@Stable
abstract class Layout<I : Intent, S : State, C : Change> : View<I, S>,
    Bindable {

    open val key: Any? = this::class.simpleName

    protected abstract val presenter: Presenter<I, S, C>

    override val renderState: S?
        get() = statesStateFlow.value

    override val states: Flow<S>
        get() = statesStateFlow.asStateFlow().filterNotNull()

    override val isBound: Boolean
        get() = presenter.isBound

    private val intentsStateFlow = MutableStateFlow<I?>(null)
    private val statesStateFlow = MutableStateFlow<S?>(null)

    override fun intents(): Flow<I> = intentsStateFlow.asStateFlow().filterNotNull()

    @Composable
    abstract fun Content(state: S)

    override fun bind() {
        presenter.bind()

        presenter.renderStates
            .onEach { state -> statesStateFlow.value = state }
            .launchIn(presenter.coroutineScope)

        onBind()
    }

    override fun unbind() {
        onUnbind()

        presenter.unbind()
    }

    protected open fun onBind() {
    }

    protected open fun onUnbind() {
    }

    protected fun intent(to: I) {
        intentsStateFlow.value = to
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Layout<*, *, *>) return false

        return this.key == other.key
    }

    override fun hashCode(): Int = key?.hashCode() ?: super.hashCode()

    override fun toString(): String = "Layout(key=$key,renderState=$renderState,isBound=$isBound)"
}

/**
 * Creates a [Layout] with the provided [key], [presenterFactory], and [content] parameters.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <I : Intent, S : State, C : Change> layout(
    key: Any? = null,
    presenterFactory: PresenterFactory<I, S, C>,
    noinline content: @Composable (S) -> Unit
): Layout<I, S, C> =
    object : Layout<I, S, C>() {

        override val key: Any?
            get() = key

        override val presenter: Presenter<I, S, C> by presenterFactory(presenterFactory)

        @Composable
        override fun Content(state: S) {
            content.invoke(state)
        }
    }

/**
 * Creates a [Layout] with the provided [key], [presenterFactory], and [content] parameters.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <I : Intent, S : State, C : Change> layout(
    key: Any? = null,
    presenter: Presenter<I, S, C>,
    noinline content: @Composable (S) -> Unit
): Layout<I, S, C> =
    object : Layout<I, S, C>() {

        override val key: Any?
            get() = key

        override val presenter: Presenter<I, S, C> = presenter

        @Composable
        override fun Content(state: S) {
            content.invoke(state)
        }
    }

/**
 * Renders the provided [layout] as a [Composable].
 */
@Composable
@Stable
inline fun <reified I : Intent, reified S : State, reified C : Change> ComposeLayout(layout: Layout<I, S, C>) {
    val rememberedLayout by rememberUpdatedState(layout)

    val state by rememberedLayout.states.collectAsState(initial = null)

    DisposableEffect(key1 = layout.key) {
        rememberedLayout.bind()
        onDispose { rememberedLayout.unbind() }
    }

    state?.let {
        rememberedLayout.Content(it)
    }
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
 */
@Composable
inline operator fun <reified I : Intent, reified S : State, reified C : Change> Layout<I, S, C>.unaryPlus() {
    ComposeLayout(layout = this)
}
