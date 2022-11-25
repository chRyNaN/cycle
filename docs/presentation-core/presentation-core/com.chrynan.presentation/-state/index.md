//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[State](index.md)

# State

[common]\
interface [State](index.md) : [ViewData](../-view-data/index.md)

A [State](index.md) is a special [ViewData](../-view-data/index.md) that contains all necessary information to represent a UI. A [State](index.md) can be derived from another [State](index.md) and a [Change](../-change/index.md). Also, a [State](index.md) can be stored in a stateful component and retrieved for later usage.

A common pattern is to have a [State](index.md) represent the UI for a particular screen. So a typical approach would be to have the screen's [State](index.md) be a sealed class inheriting from this [State](index.md) interface and have descendants representing every possible UI state the screen could be in (&quot;loading&quot;, &quot;showing results&quot;, etc).

For example:

```kotlin
sealed class FeedState : State {

   object LoadingInitial : FeedState()

   data class LoadingMore(val currentItems: List<Item>) : FeedState()

   data class Refreshing(val currentItems: List<Item>) : FeedState()

   object DisplayingEmpty : FeedState()

   data class DisplayingLoaded(val items: List<Item>) : FeedState()
}
```

It's common to name the sealed class after the name of the screen that the [State](index.md) represents (&quot;FeedState&quot; -> &quot;FeedScreen&quot;). Also, it's common to name the descendants of the sealed class in a present tense verb manner since, at this point, the screen is &quot;performing&quot; this [State](index.md) (&quot;Loading&quot;, &quot;Refreshing&quot;, etc).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [uniqueId](../-view-data/unique-id.md) | [common]<br>open val [uniqueId](../-view-data/unique-id.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>A unique identifier for this [ViewData](../-view-data/index.md). This allows it to be distinguished between other [ViewData](../-view-data/index.md)s, perhaps within a list. This defaults to the [hashCode](../../../../presentation-core/com.chrynan.presentation/-view-data/hash-code.md) converted to a [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) value. |
