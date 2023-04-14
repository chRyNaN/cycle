@file:Suppress("unused")

package com.chrynan.presentation.compose

import androidx.compose.runtime.*
import com.chrynan.presentation.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Remembers the provided [viewModel] by using the [rememberUpdatedState] function and binds the [ViewModel]'s
 * lifecycle to the calling composable function's lifecycle using a [DisposableEffect].
 */
@ExperimentalCoroutinesApi
@FlowPreview
@Composable
fun <State, Change> rememberAndBind(viewModel: ViewModel<State, Change>): ViewModel<State, Change> {
    val rememberedViewModel by rememberUpdatedState(viewModel)

    DisposableEffect(rememberedViewModel) {
        rememberedViewModel.bind()

        onDispose {
            rememberedViewModel.unbind()
        }
    }

    return rememberedViewModel
}

/**
 * Obtains the changes to the underlying [State] as a Jetpack Compose [androidx.compose.runtime.State] value, so
 * that the changes can cause the [Composable] function to be re-composed.
 *
 * **Note:** That this function will bind this [ViewModel] to the invoking composable function's lifecycle via the
 * [rememberAndBind] function. Therefore, this function should only be invoked from within the composable function that
 * created the [ViewModel].
 *
 * Example usage:
 * ```
 * @Composable
 * fun Content(viewModel: MyViewModel) {
 *     val state by viewModel.stateChanges()
 *
 *     // Create the UI using the 'state' variable
 * }
 * ```
 */
@ExperimentalCoroutinesApi
@FlowPreview
@Composable
fun <State, Change> ViewModel<State, Change>.stateChanges(context: CoroutineContext = EmptyCoroutineContext): androidx.compose.runtime.State<State?> =
    rememberAndBind(this).states.collectAsState(context = context)

/**
 * Obtains the changes to the underlying [State], starting with the provided [initial] value, as a Jetpack Compose
 * [androidx.compose.runtime.State] value, so that the changes can cause the [Composable] function to be
 * re-composed.
 *
 * **Note:** That this function will bind this [ViewModel] to the invoking composable function's lifecycle via the
 * [rememberAndBind] function. Therefore, this function should only be invoked from within the composable function that
 * it was created.
 *
 * Example usage:
 * ```
 * @Composable
 * fun Content(viewModel: MyViewModel) {
 *     val state by viewModel.stateChanges(initial = null)
 *
 *     // Create the UI using the 'state' variable
 * }
 * ```
 */
@ExperimentalCoroutinesApi
@FlowPreview
@Composable
fun <State, Change> ViewModel<State, Change>.stateChanges(
    initial: State?,
    context: CoroutineContext = EmptyCoroutineContext
): androidx.compose.runtime.State<State?> =
    rememberAndBind(this).states.collectAsState(initial = initial, context = context)
