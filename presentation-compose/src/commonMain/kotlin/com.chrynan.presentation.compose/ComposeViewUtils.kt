@file:Suppress("unused")

package com.chrynan.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.chrynan.presentation.View
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

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
@ExperimentalCoroutinesApi
@FlowPreview
@Composable
fun <State, Change> View<State, Change>.stateChanges(context: CoroutineContext = EmptyCoroutineContext): androidx.compose.runtime.State<State?> =
    viewModel.states.collectAsState(context = context)

/**
 * Obtains the changes to the underlying [State], starting with the provided [initial] value, as a Jetpack Compose
 * [androidx.compose.runtime.State] value, so that the changes can cause the [Composable] function to be
 * re-composed.
 *
 * Example usage:
 * ```
 * @Composable
 * override fun Content() {
 *     val state by stateChanges(initial = null)
 *
 *     // Create the UI using the 'state' variable
 * }
 * ```
 */
@ExperimentalCoroutinesApi
@FlowPreview
@Composable
fun <State, Change> View<State, Change>.stateChanges(
    initial: State?,
    context: CoroutineContext = EmptyCoroutineContext
): androidx.compose.runtime.State<State?> =
    viewModel.states.collectAsState(initial = initial, context = context)
