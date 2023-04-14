//[cycle-compose](../../../index.md)/[com.chrynan.cycle.compose](../index.md)/[Layout](index.md)/[Content](-content.md)

# Content

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

abstract fun [Content](-content.md)()

Renders the UI content for this Layout. Remember to subscribe to the state changes using the [stateChanges](../state-changes.md) function within this function. Using the [renderState](render-state.md) property won't work because it won't trigger a recomposition of the composable function when the state changes.

Example usage:

```kotlin
@Composable
override fun Content() {
    val state by stateChanges()

    Text("State = $state")
}
```
