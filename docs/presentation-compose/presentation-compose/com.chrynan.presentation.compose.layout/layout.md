//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose.layout](index.md)/[layout](layout.md)

# layout

[common]\
inline fun &lt;[I](layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [layout](layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, presenterFactory: [PresenterFactory](../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter-factory/index.md)&lt;[I](layout.md), [S](layout.md), [C](layout.md)&gt;, noinline content: @Composable([S](layout.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Layout](-layout/index.md)&lt;[I](layout.md), [S](layout.md), [C](layout.md)&gt;

Creates a [Layout](-layout/index.md) with the provided [key](layout.md), [presenterFactory](layout.md), and [content](layout.md) parameters.

[common]\
inline fun &lt;[I](layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [layout](layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, presenter: [Presenter](../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter/index.md)&lt;[I](layout.md), [S](layout.md), [C](layout.md)&gt;, noinline content: @Composable([S](layout.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Layout](-layout/index.md)&lt;[I](layout.md), [S](layout.md), [C](layout.md)&gt;

Creates a [Layout](-layout/index.md) with the provided [key](layout.md), [presenterFactory](../../../presentation-core/presentation-core/com.chrynan.presentation/presenter-factory.md), and [content](layout.md) parameters.
