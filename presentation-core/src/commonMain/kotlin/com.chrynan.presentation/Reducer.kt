package com.chrynan.presentation

/**
 * A [Reducer] is responsible for determining the [State] that is displayed in the UI. A [Reducer] takes the previous
 * [State] and a [Change] and derives a new [State]. The [Reducer] performs application logic.
 */
interface Reducer<S : State, C : Change> {

    /**
     * Retrieves a new [State] of type [S] from the [previous] [State] of type [S] and the [change] of type [C].
     */
    suspend fun reduce(previous: S?, change: C): S?

    companion object
}

/**
 * A convenience operator function that delegates to the [reduce] function, so that the [Reducer] class can be
 * invoked like a function.
 */
suspend operator fun <S : State, C : Change> Reducer<S, C>.invoke(previous: S?, change: C): S? =
    reduce(previous, change)
