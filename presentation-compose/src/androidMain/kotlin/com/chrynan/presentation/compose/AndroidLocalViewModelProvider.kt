package com.chrynan.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chrynan.presentation.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlin.reflect.KClass

@ExperimentalPresentationApi
@ExperimentalCoroutinesApi
@FlowPreview
@Composable
@PublishedApi
internal actual inline fun <State, Change, reified V : ViewModel<State, Change>> internalRememberViewModel(
    key: Any?
): V {
    val provider = LocalViewModelProvider.current

    @Suppress("UNCHECKED_CAST")
    val androidViewModelFactory = object : androidx.lifecycle.ViewModelProvider.Factory {

        override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T =
            provider.get(kClass = modelClass.kotlin as KClass<V>) as T
    }

    val viewModel: V = viewModel(factory = androidViewModelFactory)

    return remember(key) { viewModel }
}
