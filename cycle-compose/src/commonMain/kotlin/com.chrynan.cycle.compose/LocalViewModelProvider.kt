@file:Suppress("unused")

package com.chrynan.cycle.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.chrynan.cycle.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

/**
 * A [ProvidableCompositionLocal] of [ViewModelProvider]. This allows a parent composable function to provide a
 * [ViewModelProvider] which can then be obtained from a child composable function.
 */
@ExperimentalPresentationApi
@FlowPreview
@ExperimentalCoroutinesApi
val LocalViewModelProvider: ProvidableCompositionLocal<ViewModelProvider> =
    staticCompositionLocalOf { error("No ViewModelProvider provided. Make sure to provide the ViewModelProvider before trying to access the LocalViewModelProvider value.") }

@ExperimentalPresentationApi
@ExperimentalCoroutinesApi
@FlowPreview
@Composable
@PublishedApi
internal expect inline fun <State, Change, reified V : ViewModel<State, Change>> internalRememberViewModel(
    key: Any?
): V

/**
 * Obtains and remembers the required [ViewModel] from the [LocalViewModelProvider] or throws an exception if the
 * [ViewModel] could not be found.
 *
 * ## Example usage:
 *
 * ```kotlin
 * @Composable
 * fun Home(viewModel: HomeViewModel = rememberViewModel()) { ... }
 * ```
 */
@ExperimentalPresentationApi
@ExperimentalCoroutinesApi
@FlowPreview
@Composable
inline fun <State, Change, reified V : ViewModel<State, Change>> rememberViewModel(
    key: Any? = null
): V = com.chrynan.cycle.compose.internalRememberViewModel(key = key)
