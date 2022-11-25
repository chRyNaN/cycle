//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose](index.md)/[ComposeLayout](-compose-layout.md)

# ComposeLayout

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[I](-compose-layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](-compose-layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](-compose-layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [ComposeLayout](-compose-layout.md)(viewModel: [ViewModel](../../../presentation-core/presentation-core/com.chrynan.presentation/-view-model/index.md)&lt;[I](-compose-layout.md), [S](-compose-layout.md), [C](-compose-layout.md)&gt;, modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, onBind: [ComposeLayoutScope](-compose-layout-scope/index.md)&lt;[I](-compose-layout.md), [S](-compose-layout.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, onUnbind: [ComposeLayoutScope](-compose-layout-scope/index.md)&lt;[I](-compose-layout.md), [S](-compose-layout.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)[ComposeLayoutScope](-compose-layout-scope/index.md)&lt;[I](-compose-layout.md), [S](-compose-layout.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))
