//[cycle-compose](../../index.md)/[com.chrynan.cycle.compose](index.md)/[rememberAndBind](remember-and-bind.md)

# rememberAndBind

[common]\

@ExperimentalCoroutinesApi

@FlowPreview

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[State](remember-and-bind.md), [Change](remember-and-bind.md)&gt; [rememberAndBind](remember-and-bind.md)(viewModel: [ViewModel](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md)&lt;[State](remember-and-bind.md), [Change](remember-and-bind.md)&gt;): [ViewModel](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md)&lt;[State](remember-and-bind.md), [Change](remember-and-bind.md)&gt;

Remembers the provided [viewModel](remember-and-bind.md) by using the [rememberUpdatedState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary.html) function and binds the [ViewModel](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md)'s lifecycle to the calling composable function's lifecycle using a [DisposableEffect](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary.html).
