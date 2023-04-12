package com.chrynan.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chrynan.presentation.ViewModel

@Composable
@PublishedApi
internal actual inline fun <State, Change, reified V : ViewModel<State, Change>> internalRememberViewModel(
    key: Any?
): V {
    val provider = LocalViewModelProvider.current

    return remember(key) { provider.get(key = key?.toString(), kClass = V::class) }
}
