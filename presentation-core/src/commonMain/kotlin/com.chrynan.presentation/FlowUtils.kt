@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

/**
 * A sealed class that indicates an approach to polling. Each approach determines how the upstream
 * and downstream behaves. The available strategies are [Latest], [Merge], and [Concat].
 */
@FlowPreview
sealed class FlatMapStrategy {

    /**
     * Equivalent to the [Flow.flatMapLatest] function.
     *
     * @see [flatMapLatest]
     */
    object Latest : FlatMapStrategy()

    /**
     * Equivalent to the [Flow.flatMapMerge] function.
     *
     * @property [limit] The amount of concurrently running flat-mapped [Flow]s. The default value
     * is set to [DEFAULT_CONCURRENCY].
     *
     * @see [flatMapMerge]
     */
    data class Merge(val limit: Int = DEFAULT_CONCURRENCY) : FlatMapStrategy()

    /**
     * Equivalent to the [Flow.flatMapConcat] function.
     *
     * @see [flatMapConcat]
     */
    object Concat : FlatMapStrategy()
}

/**
 * Performs the appropriate flatMap call according to the provided [strategy].
 *
 * @see [FlatMapStrategy]
 * @see [flatMapLatest]
 * @see [flatMapConcat]
 * @see [flatMapMerge]
 */
@ExperimentalCoroutinesApi
@FlowPreview
inline fun <T, R> Flow<T>.flatMap(
    strategy: FlatMapStrategy = FlatMapStrategy.Latest,
    crossinline transform: suspend (value: T) -> Flow<R>
): Flow<R> = when (strategy) {
    is FlatMapStrategy.Latest -> flatMapLatest { transform(it) }
    is FlatMapStrategy.Merge -> flatMapMerge(concurrency = strategy.limit) { transform(it) }
    is FlatMapStrategy.Concat -> flatMapConcat { transform(it) }
}
