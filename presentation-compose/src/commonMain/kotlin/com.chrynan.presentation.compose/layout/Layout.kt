@file:Suppress("unused")

package com.chrynan.presentation.compose.layout

import androidx.compose.runtime.*
import com.chrynan.presentation.*
import com.chrynan.presentation.State
import com.chrynan.presentation.Change
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * A component that implements the [View] interface and serves as the binding between this presentation library and
 * Jetpack Compose. Typically, [Layout]s are used to represent the "Screen" components in an application.
 *
 * Example usage:
 * ```
 * class HomeLayout : BaseLayout<HomeIntent, HomeState, HomeChange>() {
 *
 *     override val presenter = ...
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
abstract class Layout<I : Intent, S : State, C : Change> : View<I, S>,
    Bindable {

    open val key: Any? = this::class.simpleName

    protected abstract val presenter: Presenter<I, S, C>

    override val renderState: S?
        get() = renderStates.value

    override val isBound: Boolean
        get() = presenter.isBound

    private val intentEvents = MutableStateFlow<IntentEvent<I>?>(null)
    private val renderStates = MutableStateFlow<S?>(null)

    /**
     * A [StateFlow] of all the [State]s rendered to this [Layout]. This is provided as a convenience for the [Layout]
     * implementations if they need more control over the state flow, otherwise, prefer the [stateChanges] function.
     */
    protected val states: StateFlow<S?>
        get() = presenter.renderStates

    override fun intentEvents(): Flow<IntentEvent<I>> = intentEvents.asStateFlow().filterNotNull()

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
            presenter.bind()

            onBind()
        }
    }

    final override fun unbind() {
        if (isBound) {
            onUnbind()

            presenter.unbind()
        }
    }

    protected open fun onBind() {
    }

    protected open fun onUnbind() {
    }

    /**
     * Emits the provided [to] [Intent] value to trigger an action, that may eventually result in a new [State] being
     * rendered.
     */
    protected fun intent(to: I) {
        intentEvents.value = IntentEvent(intent = to)
    }

    /**
     * Obtains the changes to the underlying [State] as a Jetpack Compose [androidx.compose.runtime.State] value, so
     * that the changes can cause the [Composable] function to be re-composed.
     *
     * Example usage:
     * ```
     * @Composable
     * override fun Content() {
     *     val state by stateChanges()
     *
     *     // Create the UI using the 'state' variable
     * }
     * ```
     */
    @Composable
    protected fun stateChanges(context: CoroutineContext = EmptyCoroutineContext): androidx.compose.runtime.State<S?> =
        renderStates.asStateFlow()
            .collectAsState(context = context)

    /**
     * Obtains the changes to the underlying [State], starting with the provided [initial] value, as a Jetpack Compose
     * [androidx.compose.runtime.State] value, so that the changes can cause the [Composable] function to be
     * re-composed.
     *
     * Example usage:
     * ```
     * @Composable
     * override fun Content() {
     *     val state by stateChanges()
     *
     *     // Create the UI using the 'state' variable
     * }
     * ```
     */
    @Composable
    protected fun stateChanges(
        initial: S?,
        context: CoroutineContext = EmptyCoroutineContext
    ): androidx.compose.runtime.State<S?> =
        renderStates.asStateFlow()
            .collectAsState(initial = initial, context = context)

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
    noinline content: @Composable () -> Unit
): Layout<I, S, C> =
    object : Layout<I, S, C>() {

        override val key: Any?
            get() = key

        override val presenter: Presenter<I, S, C> by presenterFactory(factory = presenterFactory)

        @Composable
        override fun Content() {
            content.invoke()
        }
    }

/**
 * Creates a [Layout] with the provided [key], [presenterFactory], and [content] parameters.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <I : Intent, S : State, C : Change> layout(
    key: Any? = null,
    presenter: Presenter<I, S, C>,
    noinline content: @Composable () -> Unit
): Layout<I, S, C> =
    object : Layout<I, S, C>() {

        override val key: Any?
            get() = key

        override val presenter: Presenter<I, S, C> = presenter

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
