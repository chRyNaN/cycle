@file:Suppress("unused")

package com.chrynan.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.chrynan.presentation.ViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@Composable
fun <State, Change> ComposeLayout(
    viewModel: ViewModel<State, Change>,
    modifier: Modifier = Modifier,
    onBind: ComposeLayoutScope<State>.() -> Unit = {},
    onUnbind: ComposeLayoutScope<State>.() -> Unit = {},
    content: @Composable ComposeLayoutScope<State>.() -> Unit
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

interface ComposeLayoutScope<State> {

    @Composable
    fun stateChanges(context: CoroutineContext): androidx.compose.runtime.State<State?>
}

@Composable
fun <State> ComposeLayoutScope<State>.stateChanges(): androidx.compose.runtime.State<State?> =
    stateChanges(context = EmptyCoroutineContext)

private class ComposeLayoutScopeImpl<State, Change>(
    private val viewModel: ViewModel<State, Change>
) : ComposeLayoutScope<State> {

    @Composable
    override fun stateChanges(context: CoroutineContext): androidx.compose.runtime.State<State?> =
        (viewModel.states as? StateFlow<State?>)?.collectAsState(context = context)
            ?: viewModel.states.collectAsState(initial = null, context = context)
}
