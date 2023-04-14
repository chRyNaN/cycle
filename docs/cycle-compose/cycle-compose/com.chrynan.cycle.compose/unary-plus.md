//[cycle-compose](../../index.md)/[com.chrynan.cycle.compose](index.md)/[unaryPlus](unary-plus.md)

# unaryPlus

[common]\

@ExperimentalCoroutinesApi

@FlowPreview

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

inline operator fun &lt;[State](unary-plus.md), [Change](unary-plus.md)&gt; [Layout](-layout/index.md)&lt;[State](unary-plus.md), [Change](unary-plus.md)&gt;.[unaryPlus](unary-plus.md)()

Renders this [Layout](-layout/index.md) as a [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html).

This is a convenience function for calling [ComposeLayout](-compose-layout.md).

Example usage:

```kotlin
@Composable
fun Home {
    +HomeLayout()
}
```

#### See also

| |
|---|
| [ComposeLayout](-compose-layout.md) |
