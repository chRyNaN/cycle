@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlin.reflect.KClass

@ExperimentalCoroutinesApi
@FlowPreview
interface ViewModelFactory {

    fun <State, Change, V : ViewModel<State, Change>> create(
        kClass: KClass<V>,
        vararg extras: Any?
    ): V

    companion object
}

@ExperimentalCoroutinesApi
@FlowPreview
fun <State, Change, V : ViewModel<State, Change>> ViewModelFactory.createOrNull(
    kClass: KClass<V>,
    vararg extras: Any?
): V? = try {
    create(kClass = kClass, extras = extras)
} catch (_: Exception) {
    null
}

@ExperimentalCoroutinesApi
@FlowPreview
inline fun <State, Change, reified V : ViewModel<State, Change>> ViewModelFactory.create(
    vararg extras: Any?
): V = create(kClass = V::class, extras = extras)

@ExperimentalCoroutinesApi
@FlowPreview
inline fun <State, Change, reified V : ViewModel<State, Change>> ViewModelFactory.createOrNull(
    vararg extras: Any?
): V? = try {
    create(kClass = V::class, extras = extras)
} catch (_: Exception) {
    null
}
