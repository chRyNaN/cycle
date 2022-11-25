//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose.layout](index.md)/[ComposeLayout](-compose-layout.md)

# ComposeLayout

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

fun &lt;[I](-compose-layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](-compose-layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](-compose-layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [ComposeLayout](-compose-layout.md)(layout: [Layout](-layout/index.md)&lt;[I](-compose-layout.md), [S](-compose-layout.md), [C](-compose-layout.md)&gt;)

Renders the provided [layout](-compose-layout.md) as a [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html).

Example usage:

```kotlin
@Composable
fun Home {
    ComposeLayout(homeLayout)
}
```
