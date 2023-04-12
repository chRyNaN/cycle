@file:Suppress("unused")

package com.chrynan.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.chrynan.presentation.*

val LocalViewModelProvider: ProvidableCompositionLocal<ViewModelProvider> =
    staticCompositionLocalOf { error("No ViewModelProvider provided. Make sure to provide the ViewModelProvider before trying to access the LocalViewModelProvider value.") }

@Composable
@PublishedApi
internal expect inline fun <State, Change, reified V : ViewModel<State, Change>> internalRememberViewModel(
    key: Any?
): V

@Composable
inline fun <State, Change, reified V : ViewModel<State, Change>> rememberViewModel(
    key: Any? = null
): V = internalRememberViewModel(key = key)
