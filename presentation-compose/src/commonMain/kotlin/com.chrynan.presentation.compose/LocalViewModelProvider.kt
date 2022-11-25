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
internal expect inline fun <I : Intent, S : State, C : Change, reified V : ViewModel<I, S, C>> internalRememberViewModel(
    key: Any?
): V

@Composable
inline fun <I : Intent, S : State, C : Change, reified V : ViewModel<I, S, C>> rememberViewModel(
    key: Any? = null
): V = internalRememberViewModel(key = key)
