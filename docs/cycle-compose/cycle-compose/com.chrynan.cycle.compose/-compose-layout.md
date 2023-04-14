//[cycle-compose](../../index.md)/[com.chrynan.cycle.compose](index.md)/[ComposeLayout](-compose-layout.md)

# ComposeLayout

[common]\

@ExperimentalCoroutinesApi

@FlowPreview

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

fun &lt;[State](-compose-layout.md), [Change](-compose-layout.md)&gt; [ComposeLayout](-compose-layout.md)(layout: [Layout](-layout/index.md)&lt;[State](-compose-layout.md), [Change](-compose-layout.md)&gt;)

Renders the provided [layout](-compose-layout.md) as a [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html).

Example usage:

```kotlin
@Composable
fun Home {
    ComposeLayout(homeLayout)
}
```
