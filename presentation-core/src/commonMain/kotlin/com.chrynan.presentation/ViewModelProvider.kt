@file:Suppress("unused")

package com.chrynan.presentation

import kotlin.reflect.KClass

interface ViewModelProvider {

    operator fun <I : Intent, S : State, C : Change, V : ViewModel<I, S, C>> get(
        key: String? = null,
        kClass: KClass<V>
    ): V

    companion object
}

fun <I : Intent, S : State, C : Change, V : ViewModel<I, S, C>> ViewModelProvider.getOrNull(
    key: String? = null,
    kClass: KClass<V>
): V? = try {
    get(key = key, kClass = kClass)
} catch (_: Exception) {
    null
}

inline fun <I : Intent, S : State, C : Change, reified V : ViewModel<I, S, C>> ViewModelProvider.get(
    key: String? = null
): V = this@get.get(key = key, kClass = V::class)

inline fun <I : Intent, S : State, C : Change, reified V : ViewModel<I, S, C>> ViewModelProvider.getOrNull(
    key: String? = null
): V? = try {
    get(key = key, kClass = V::class)
} catch (_: Exception) {
    null
}

/**
 * Constructs a [ViewModelProvider] using the provided [ViewModelFactory] to create instances of the ViewModels and
 * caching the values in a [MutableMap] by their associated keys for faster subsequent access.
 */
fun ViewModelProvider(factory: ViewModelFactory): ViewModelProvider =
    DefaultViewModelProvider(factory = factory)

internal class DefaultViewModelProvider(
    private val factory: ViewModelFactory
) : ViewModelProvider {

    private val cache = mutableMapOf<String, ViewModel<*, *, *>>()

    @Suppress("UNCHECKED_CAST")
    override fun <I : Intent, S : State, C : Change, V : ViewModel<I, S, C>> get(key: String?, kClass: KClass<V>): V {
        val cacheKey = key ?: kClass.simpleName

        if (cacheKey != null) {
            val cachedViewModel = cache[cacheKey]

            if (cachedViewModel != null) {
                return cachedViewModel as V
            }
        }

        val newViewModel = factory.create(kClass = kClass)

        if (cacheKey != null) {
            cache[cacheKey] = newViewModel
        }

        return newViewModel
    }

    override fun hashCode(): Int = factory.hashCode()

    override fun equals(other: Any?): Boolean {
        if (other !is DefaultViewModelProvider) return false

        return factory == other.factory
    }

    override fun toString(): String = "DefaultViewModelProvider"
}
