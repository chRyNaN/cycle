@file:Suppress("unused")

package com.chrynan.presentation.js.react

import kotlinx.coroutines.flow.Flow

interface CallbackSubscriber<T> {

    fun subscribe(): Flow<T>
}
