package com.chrynan.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chrynan.presentation.*
import kotlin.reflect.KClass

@Composable
@PublishedApi
internal actual inline fun <I : Intent, S : State, C : Change, reified V : ViewModel<I, S, C>> internalRememberViewModel(
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
