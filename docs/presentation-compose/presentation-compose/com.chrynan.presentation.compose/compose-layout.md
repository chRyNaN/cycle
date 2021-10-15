//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose](index.md)/[composeLayout](compose-layout.md)

# composeLayout

[common]\

@Composable

inline fun &lt;[I](compose-layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](compose-layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](compose-layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [composeLayout](compose-layout.md)(layout: [Layout](-layout/index.md)&lt;[I](compose-layout.md), [S](compose-layout.md), [C](compose-layout.md)&gt;)

@Composable

inline fun &lt;[I](compose-layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](compose-layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](compose-layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [composeLayout](compose-layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, presenterFactory: [PresenterFactory](../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter-factory/index.md)&lt;[I](compose-layout.md), [S](compose-layout.md), [C](compose-layout.md)&gt;, noinline onLayout: @Composable([S](compose-layout.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

@Composable

inline fun &lt;[I](compose-layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](compose-layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](compose-layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [composeLayout](compose-layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, noinline onCreatePresenter: (view: [View](../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)&lt;[I](compose-layout.md), [S](compose-layout.md)&gt;) -&gt; [Presenter](../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter/index.md)&lt;[I](compose-layout.md), [S](compose-layout.md), [C](compose-layout.md)&gt;, noinline onLayout: @Composable([S](compose-layout.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))
