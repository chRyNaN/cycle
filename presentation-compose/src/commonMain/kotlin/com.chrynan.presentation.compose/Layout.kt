@file:Suppress("unused")

package com.chrynan.presentation.compose

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
 */
@Stable
abstract class Layout<I : Intent, S : State, C : Change> : View<I, S>,
    Bindable {

    abstract val key: Any?

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
    }

    override fun unbind() {
        presenter?.unbind()
    }

    protected fun emit(intent: I) {
        intentsStateFlow.value = intent
    }
}

@Composable
fun <I : Intent, S : State, C : Change> layout(
    key: Any? = null,
    presenterFactory: PresenterFactory<I, S, C>,
    onLayout: @Composable (S) -> Unit
) = object : Layout<I, S, C>() {

    override val key: Any?
        get() = key

    override val presenterFactory: PresenterFactory<I, S, C>
        get() = presenterFactory

    @Composable
    override fun OnLayout(state: S) {
        onLayout.invoke(state)
    }
}

@Composable
fun <I : Intent, S : State, C : Change> layout(
    key: Any? = null,
    onCreatePresenter: (view: View<I, S>) -> Presenter<I, S, C>,
    onLayout: @Composable (S) -> Unit
) = object : Layout<I, S, C>() {

    override val key: Any?
        get() = key

    override val presenterFactory: PresenterFactory<I, S, C>
        get() = PresenterFactory { view -> onCreatePresenter.invoke(view) }

    @Composable
    override fun OnLayout(state: S) {
        onLayout.invoke(state)
    }
}

@Composable
@Suppress("unused")
inline fun <reified I : Intent, reified S : State, reified C : Change> includeLayout(layout: Layout<I, S, C>) {
    val rememberedLayout by remember { mutableStateOf(layout) }

    val state by rememberedLayout.states.collectAsState(initial = null)

    DisposableEffect(key1 = layout.key) {
        rememberedLayout.bind()
        onDispose { rememberedLayout.unbind() }
    }

    state?.let {
        rememberedLayout.OnLayout(it)
    }
}
