package com.chrynan.presentation

/**
 * Represents the result of performing an [Action] and is used, along with the previous [State], to determine a new
 * [State]. A previous [State] and a [Change] should be all that is needed for a [Reducer] to be able to derive a new
 * [State]. So include all necessary information in the [Change].
 *
 * [Change]s themselves perform no logic and are typically modeled with sealed classes. A common approach is to have a
 * surrounding sealed class that extends from [Change] for a particular screen and have all of the [Change]s for that
 * screen be descendants of the sealed class. Typically, the [Change] implementations are immutable classes to conform
 * to the uni-directional flow paradigm and to avoid handling mutations.
 *
 * For example:
 * ```
 * sealed class FeedChange : Change {
 *
 *     data class Loaded(val items: List<Item>) : FeedChange()
 *
 *     data class StartedLoading(val currentItems: List<Item>) : FeedChange()
 *
 *     data class StartedRefreshing(val currentItems: List<Item>): FeedChange()
 * }
 * ```
 *
 * It's common to name the sealed class after the name of the screen that the [Change] represents ("FeedChange" ->
 * "FeedScreen"). Also, it's common to name the descendants of the sealed class in a past tense verb manner since, at
 * this point, the [Action] has already been performed ("StartedLoading", "Loaded", etc).
 */
interface Change {

    companion object
}
