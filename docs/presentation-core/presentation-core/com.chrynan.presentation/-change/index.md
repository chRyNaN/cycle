//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Change](index.md)

# Change

[common]\
interface [Change](index.md)

Represents the result of performing an [Action](../-action/index.md) and is used, along with the previous [State](../-state/index.md), to determine a new [State](../-state/index.md). A previous [State](../-state/index.md) and a [Change](index.md) should be all that is needed for a [Reducer](../-reducer/index.md) to be able to derive a new [State](../-state/index.md). So include all necessary information in the [Change](index.md).

[Change](index.md)s themselves perform no logic and are typically modeled with sealed classes. A common approach is to have a surrounding sealed class that extends from [Change](index.md) for a particular screen and have all of the [Change](index.md)s for that screen be descendants of the sealed class. Typically, the [Change](index.md) implementations are immutable classes to conform to the uni-directional flow paradigm and to avoid handling mutations.

For example:

sealed class FeedChange : Change {\
\
    data class Loaded(val items: List&lt;Item&gt;) : FeedChange()\
\
    data class StartedLoading(val currentItems: List&lt;Item&gt;) : FeedChange()\
\
    data class StartedRefreshing(val currentItems: List&lt;Item&gt;): FeedChange()\
}

It's common to name the sealed class after the name of the screen that the [Change](index.md) represents ("FeedChange" -> "FeedScreen"). Also, it's common to name the descendants of the sealed class in a past tense verb manner since, at this point, the [Action](../-action/index.md) has already been performed ("StartedLoading", "Loaded", etc).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
