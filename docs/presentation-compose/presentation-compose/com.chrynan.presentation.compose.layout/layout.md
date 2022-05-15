//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose.layout](index.md)/[layout](layout.md)

# layout

[common]\
inline fun &lt;[I](layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [layout](layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, viewModelFactory: [ViewModelFactory](../../../presentation-core/presentation-core/com.chrynan.presentation/-view-model-factory/index.md)&lt;[I](layout.md), [S](layout.md), [C](layout.md)&gt;, noinline content: @Composable() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Layout](-layout/index.md)&lt;[I](layout.md), [S](layout.md), [C](layout.md)&gt;

Creates a [Layout](-layout/index.md) with the provided [key](layout.md), [viewModelFactory](layout.md), and [content](layout.md) parameters.

[common]\
inline fun &lt;[I](layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [layout](layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, viewModel: [ViewModel](../../../presentation-core/presentation-core/com.chrynan.presentation/-view-model/index.md)&lt;[I](layout.md), [S](layout.md), [C](layout.md)&gt;, noinline content: @Composable() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Layout](-layout/index.md)&lt;[I](layout.md), [S](layout.md), [C](layout.md)&gt;

Creates a [Layout](-layout/index.md) with the provided [key](layout.md), [viewModel](layout.md), and [content](layout.md) parameters.
