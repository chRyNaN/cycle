//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Intent](index.md)

# Intent

[common]\
interface [Intent](index.md)

Represents the desire to perform an action. A [View](../-view/index.md) emits [Intent](index.md)s to a [ViewModel](../-view-model/index.md) via the [ViewModel.intent](../-view-model/intent.md) function. These [Intent](index.md)s can be the result of User interaction. For instance, consider that a User scrolls to the bottom of a list, an [Intent](index.md) could be emitted to the [ViewModel.intent](../-view-model/intent.md) function indicating that we intend to load more items into the list.

[Intent](index.md)s themselves perform no logic and are typically modeled with sealed classes. A common approach is to have a surrounding sealed class that extends from [Intent](index.md) for a particular screen and have all the [Intent](index.md)s for that screen be descendants of the sealed class. Typically, the [Intent](index.md) implementations are immutable classes to conform to the uni-directional flow paradigm and to avoid handling mutations.

For example:

```kotlin
sealed class FeedIntent : Intent {

    object LoadInitial : FeedIntent()

    data class LoadMore(val currentItems: List<Item>) : FeedIntent()

    data class Refresh(val currentItems: List<Item>) : FeedIntent()
}
```

It's common to name the sealed class after the name of the screen that the [Intent](index.md) represents (&quot;FeedIntent&quot; -> &quot;FeedScreen&quot;). Also, it's common to name the descendants of the sealed class in a declarative manner (&quot;load&quot;, &quot;refresh&quot;, etc).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
