@file:Suppress("unused")

package com.chrynan.presentation.compose.layout

import androidx.compose.runtime.*
import com.chrynan.presentation.*
import com.chrynan.presentation.State
import com.chrynan.presentation.Change
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull

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
 *     override fun OnLayout(state: HomeState) {
 *         // Put Composable UI code here using the [state] value
 *     }
 * }
 * ```
 */
@Stable
abstract class Layout<I : Intent, S : State, C : Change> : View<I, S>,
    Bindable {

    open val key: Any? = this::class.simpleName

    protected abstract val presenterFactory: PresenterFactory<I, S, C>

    override val renderState: S?
        get() = statesStateFlow.value

    override val states: Flow<S>
        get() = statesStateFlow.asStateFlow().filterNotNull()

    override val isBound: Boolean
        get() = presenter?.isBound ?: false

    private val intentsStateFlow = MutableStateFlow<I?>(null)
    private val statesStateFlow = MutableStateFlow<S?>(null)

    private var presenter: Presenter<I, S, C>? = null

    override fun intents(): Flow<I> = intentsStateFlow.asStateFlow().filterNotNull()

    @Composable
    abstract fun OnLayout(state: S)

    override fun render(state: S) {
        statesStateFlow.value = state
    }

    override fun bind() {
        if (presenter == null) {
            presenter = presenterFactory.invoke(this)
        }

        presenter?.bind()

        onBind()
    }

    override fun unbind() {
        onUnbind()

        presenter?.unbind()
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
 * Creates a [Layout] with the provided [key], [presenterFactory], and [onLayout] parameters.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <I : Intent, S : State, C : Change> layout(
    key: Any? = null,
    presenterFactory: PresenterFactory<I, S, C>,
    noinline onLayout: @Composable (S) -> Unit
): Layout<I, S, C> =
    object : Layout<I, S, C>() {

        override val key: Any?
            get() = key

        override val presenterFactory: PresenterFactory<I, S, C>
            get() = presenterFactory

        @Composable
        override fun OnLayout(state: S) {
            onLayout.invoke(state)
        }
    }

/**
 * Lays out the provided [layout] as a [Composable].
 */
@Composable
@Stable
inline fun <reified I : Intent, reified S : State, reified C : Change> composeLayout(layout: Layout<I, S, C>) {
    val rememberedLayout by rememberUpdatedState(layout)

    val state by rememberedLayout.states.collectAsState(initial = null)

    DisposableEffect(key1 = layout.key) {
        rememberedLayout.bind()
        onDispose { rememberedLayout.unbind() }
    }

    state?.let {
        rememberedLayout.OnLayout(it)
    }
}

/**
 * Creates a [Layout] with the provided [key], [presenterFactory], and [onLayout] parameters and then lays out the
 * layout as a [Composable].
 */
@Composable
inline fun <reified I : Intent, reified S : State, reified C : Change> composeLayout(
    key: Any? = null,
    presenterFactory: PresenterFactory<I, S, C>,
    noinline onLayout: @Composable (S) -> Unit
) {
    val layout = layout(key = key, presenterFactory = presenterFactory, onLayout = onLayout)

    composeLayout(layout = layout)
}
