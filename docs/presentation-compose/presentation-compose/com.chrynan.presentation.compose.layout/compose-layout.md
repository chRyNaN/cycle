//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose.layout](index.md)/[composeLayout](compose-layout.md)

# composeLayout

[common]\

@Composable

@Stable

inline fun &lt;[I](compose-layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](compose-layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](compose-layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [composeLayout](compose-layout.md)(layout: [Layout](-layout/index.md)&lt;[I](compose-layout.md), [S](compose-layout.md), [C](compose-layout.md)&gt;)

Lays out the provided [layout](compose-layout.md) as a Composable.

[common]\

@Composable

inline fun &lt;[I](compose-layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](compose-layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](compose-layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [composeLayout](compose-layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, presenterFactory: [PresenterFactory](../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter-factory/index.md)&lt;[I](compose-layout.md), [S](compose-layout.md), [C](compose-layout.md)&gt;, noinline onLayout: @Composable([S](compose-layout.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Creates a [Layout](-layout/index.md) with the provided [key](compose-layout.md), [presenterFactory](compose-layout.md), and [onLayout](compose-layout.md) parameters and then lays out the layout as a Composable.
