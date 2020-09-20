@file:Suppress("unused")

package com.chrynan.presentation.js.react

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.mapNotNull

@ExperimentalCoroutinesApi
class CallbackHandler<T> : CallbackEmitter<T>,
    CallbackSubscriber<T> {

    private val stateFlow = MutableStateFlow<CallbackWrapper<T>?>(null)

    override fun emit(item: T) {
        stateFlow.value = CallbackWrapper(item = item)
    }

    override fun subscribe(): Flow<T> = stateFlow.mapNotNull { it?.item }

    private data class CallbackWrapper<T>(val item: T)
}
