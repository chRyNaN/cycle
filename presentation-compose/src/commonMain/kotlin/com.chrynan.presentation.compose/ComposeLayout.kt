@file:Suppress("unused")

package com.chrynan.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.chrynan.presentation.Intent
import com.chrynan.presentation.State
import com.chrynan.presentation.Change
import com.chrynan.presentation.ViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@Composable
fun <I : Intent, S : State, C : Change> ComposeLayout(
    viewModel: ViewModel<I, S, C>,
    modifier: Modifier = Modifier,
    onBind: ComposeLayoutScope<I, S>.() -> Unit = {},
    onUnbind: ComposeLayoutScope<I, S>.() -> Unit = {},
    content: @Composable ComposeLayoutScope<I, S>.() -> Unit
) {
    Box(modifier = modifier) {
        val rememberedViewModel by rememberUpdatedState(viewModel)
        val scope = ComposeLayoutScopeImpl(viewModel = rememberedViewModel)

        DisposableEffect(rememberedViewModel) {
            rememberedViewModel.bind()
            scope.onBind()

            onDispose {
                scope.onUnbind()
                rememberedViewModel.unbind()
            }
        }

        scope.content()
    }
}

interface ComposeLayoutScope<I : Intent, S : State> {

    @Composable
    fun stateChanges(context: CoroutineContext): androidx.compose.runtime.State<S?>

    fun intent(to: I)
}

@Composable
fun <I : Intent, S : State> ComposeLayoutScope<I, S>.stateChanges(): androidx.compose.runtime.State<S?> =
    stateChanges(context = EmptyCoroutineContext)

private class ComposeLayoutScopeImpl<I : Intent, S : State, C : Change>(
    private val viewModel: ViewModel<I, S, C>
) : ComposeLayoutScope<I, S> {

    @Composable
    override fun stateChanges(context: CoroutineContext): androidx.compose.runtime.State<S?> =
        (viewModel.renderStates as? StateFlow<S?>)?.collectAsState(context = context)
            ?: viewModel.renderStates.collectAsState(initial = null, context = context)

    override fun intent(to: I) = viewModel.intent(to = to)
}
