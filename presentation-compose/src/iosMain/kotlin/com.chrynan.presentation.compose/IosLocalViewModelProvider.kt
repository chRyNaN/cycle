package com.chrynan.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.chrynan.presentation.ViewModel
import com.chrynan.presentation.ExperimentalPresentationApi
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
