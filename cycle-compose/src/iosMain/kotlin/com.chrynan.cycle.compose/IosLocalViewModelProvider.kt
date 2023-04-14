package com.chrynan.cycle.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chrynan.cycle.ViewModel
import com.chrynan.cycle.ExperimentalPresentationApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
@Composable
@PublishedApi
@ExperimentalPresentationApi
internal actual inline fun <State, Change, reified V : ViewModel<S, C>> internalRememberViewModel(
    key: Any?
): V {
    val provider = LocalViewModelProvider.current

    return remember(key) { provider.get(key = key?.toString(), kClass = V::class) }
}
