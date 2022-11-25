package com.chrynan.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chrynan.presentation.Change
import com.chrynan.presentation.Intent
import com.chrynan.presentation.State
import com.chrynan.presentation.ViewModel

@Composable
@PublishedApi
internal actual inline fun <I : Intent, S : State, C : Change, reified V : ViewModel<I, S, C>> internalRememberViewModel(
    key: Any?
): V {
    val provider = LocalViewModelProvider.current

    return remember(key) { provider.get(key = key?.toString(), kClass = V::class) }
}
