@file:Suppress("unused")

package com.chrynan.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.chrynan.presentation.Change
import com.chrynan.presentation.Intent
import com.chrynan.presentation.State
import com.chrynan.presentation.View
import kotlinx.coroutines.flow.StateFlow
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
@Composable
fun <I : Intent, S : State, C : Change> View<I, S, C>.stateChanges(context: CoroutineContext = EmptyCoroutineContext): androidx.compose.runtime.State<S?> =
    (presenter.renderStates as? StateFlow<S?>)?.collectAsState(context = context)
        ?: presenter.renderStates.collectAsState(initial = null, context = context)

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
fun <I : Intent, S : State, C : Change> View<I, S, C>.stateChanges(
    initial: S?,
    context: CoroutineContext = EmptyCoroutineContext
): androidx.compose.runtime.State<S?> =
    presenter.renderStates.collectAsState(initial = initial, context = context)
