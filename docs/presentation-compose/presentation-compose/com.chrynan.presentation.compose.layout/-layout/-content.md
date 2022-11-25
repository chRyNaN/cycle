//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose.layout](../index.md)/[Layout](index.md)/[Content](-content.md)

# Content

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

abstract fun [Content](-content.md)()

Renders the UI content for this Layout.

Example usage:

```kotlin
@Composable
override fun Content() {
    val state by stateChanges()

    Text("State = $state")
}
```
