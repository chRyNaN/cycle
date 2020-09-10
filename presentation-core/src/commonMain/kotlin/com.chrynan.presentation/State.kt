package com.chrynan.presentation

/**
 * A [State] is a special [ViewModel] that contains all necessary information to represent a UI. A [State] can be
 * derived from another [State] and a [Change]. Also, a [State] can be stored in a stateful component and retrieved for
 * later usage.
 *
 * A common pattern is to have a [State] represent the UI for a particular screen. So a typical approach would be to
 * have the screen's [State] be a sealed class inheriting from this [State] interface and have descendants representing
 * every possible UI state the screen could be in ("loading", "showing results", etc).
 *
 * For example:
 * ```
 * sealed class FeedState : State {
 *
 *    object LoadingInitial : FeedState()
 *
 *    data class LoadingMore(val currentItems: List<Item>) : FeedState()
 *
 *    data class Refreshing(val currentItems: List<Item>) : FeedState()
 *
 *    object DisplayingEmpty : FeedState()
 *
 *    data class DisplayingLoaded(val items: List<Item>) : FeedState()
 * }
 * ```
 *
 * It's common to name the sealed class after the name of the screen that the [State] represents ("FeedState" ->
 * "FeedScreen"). Also, it's common to name the descendants of the sealed class in a present tense verb manner since,
 * at this point, the screen is "performing" this [State] ("Loading", "Refreshing", etc).
 */
interface State : ViewModel
