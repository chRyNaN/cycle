//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose](index.md)/[layout](layout.md)

# layout

[common]\

@Composable

fun &lt;[I](layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [layout](layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, presenterFactory: [PresenterFactory](../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter-factory/index.md)&lt;[I](layout.md), [S](layout.md), [C](layout.md)&gt;, onLayout: @Composable([S](layout.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Layout](-layout/index.md)&lt;[I](layout.md), [S](layout.md), [C](layout.md)&gt;

@Composable

fun &lt;[I](layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [layout](layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, onCreatePresenter: (view: [View](../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)&lt;[I](layout.md), [S](layout.md)&gt;) -&gt; [Presenter](../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter/index.md)&lt;[I](layout.md), [S](layout.md), [C](layout.md)&gt;, onLayout: @Composable([S](layout.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Layout](-layout/index.md)&lt;[I](layout.md), [S](layout.md), [C](layout.md)&gt;
