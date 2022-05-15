package com.chrynan.presentation

/**
 * Represents the desire to perform an action. A [View] emits [Intent]s to a [ViewModel] via the [ViewModel.intent]
 * function. These [Intent]s can be the result of User interaction. For instance, consider that a User scrolls to the
 * bottom of a list, an [Intent] could be emitted to the [ViewModel.intent] function indicating that we intend to load
 * more items into the list.
 *
 * [Intent]s themselves perform no logic and are typically modeled with sealed classes. A common approach is to have a
 * surrounding sealed class that extends from [Intent] for a particular screen and have all the [Intent]s for that
 * screen be descendants of the sealed class. Typically, the [Intent] implementations are immutable classes to conform
 * to the uni-directional flow paradigm and to avoid handling mutations.
 *
 * For example:
 * ```
 * sealed class FeedIntent : Intent {
 *
 *     object LoadInitial : FeedIntent()
 *
 *     data class LoadMore(val currentItems: List<Item>) : FeedIntent()
 *
 *     data class Refresh(val currentItems: List<Item>) : FeedIntent()
 * }
 * ```
 *
 * It's common to name the sealed class after the name of the screen that the [Intent] represents ("FeedIntent" ->
 * "FeedScreen"). Also, it's common to name the descendants of the sealed class in a declarative manner ("load",
 * "refresh", etc).
 */
interface Intent {

    companion object
}
