@file:Suppress("unused")

package com.chrynan.presentation

/**
 * Represents a class that can map from type [IN] to type [OUT] using the [map] function. This is especially useful
 * for mapping entities, or models, to [ViewModel] and [State] classes. This way each layer of the application can be
 * separate and the [Mapper] is responsible for bridging the gap and converting between the different types.
 */
interface Mapper<IN, OUT> {

    /**
     * Converts the provided [model] of type [IN] into an instance of type [OUT].
     *
     * Note that this is a suspending function and must be called from another suspending function or coroutine.
     */
    suspend fun map(model: IN): OUT
}
