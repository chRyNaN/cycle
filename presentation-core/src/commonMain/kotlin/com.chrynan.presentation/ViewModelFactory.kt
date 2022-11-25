@file:Suppress("unused")

package com.chrynan.presentation

import kotlin.reflect.KClass

interface ViewModelFactory {

    fun <I : Intent, S : State, C : Change, V : ViewModel<I, S, C>> create(
        kClass: KClass<V>,
        vararg extras: Any?
    ): V

    companion object
}

fun <I : Intent, S : State, C : Change, V : ViewModel<I, S, C>> ViewModelFactory.createOrNull(
    kClass: KClass<V>,
    vararg extras: Any?
): V? = try {
    create(kClass = kClass, extras = extras)
} catch (_: Exception) {
    null
}

inline fun <I : Intent, S : State, C : Change, reified V : ViewModel<I, S, C>> ViewModelFactory.create(
    vararg extras: Any?
): V = create(kClass = V::class, extras = extras)

inline fun <I : Intent, S : State, C : Change, reified V : ViewModel<I, S, C>> ViewModelFactory.createOrNull(
    vararg extras: Any?
): V? = try {
    create(kClass = V::class, extras = extras)
} catch (_: Exception) {
    null
}
