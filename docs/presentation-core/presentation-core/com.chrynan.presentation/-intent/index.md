//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Intent](index.md)

# Intent

[common]\
interface [Intent](index.md)

Represents the desire to perform an action. A [View](../-view/index.md) emits [Intent](index.md)s via the [View.intents](../-view/intents.md) function. These [Intent](index.md)s can be the result of User interaction. For instance, consider the User scrolls to the bottom of a list, an [Intent](index.md) could be emitted from the [View.intents](../-view/intents.md) function indicating that we intend to load more items into the list.

[Intent](index.md)s themselves perform no logic and are typically modeled with sealed classes. A common approach is to have a surrounding sealed class that extends from [Intent](index.md) for a particular screen and have all the [Intent](index.md)s for that screen be descendants of the sealed class. Typically, the [Intent](index.md) implementations are immutable classes to conform to the uni-directional flow paradigm and to avoid handling mutations.

For example:

sealed class FeedIntent : Intent {\
\
    object LoadInitial : FeedIntent()\
\
    data class LoadMore(val currentItems: List&lt;Item&gt;) : FeedIntent()\
\
    data class Refresh(val currentItems: List&lt;Item&gt;) : FeedIntent()\
}

It's common to name the sealed class after the name of the screen that the [Intent](index.md) represents ("FeedIntent" -> "FeedScreen"). Also, it's common to name the descendants of the sealed class in a declarative manner ("load", "refresh", etc).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
