//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose](../index.md)/[ComposeLayoutScope](index.md)

# ComposeLayoutScope

[common]\
interface [ComposeLayoutScope](index.md)&lt;[I](index.md) : [Intent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](index.md) : [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [intent](intent.md) | [common]<br>abstract fun [intent](intent.md)(to: [I](index.md)) |
| [stateChanges](state-changes.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>abstract fun [stateChanges](state-changes.md)(context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html)): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[S](index.md)?&gt; |

## Extensions

| Name | Summary |
|---|---|
| [stateChanges](../state-changes.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun &lt;[I](../state-changes.md) : [Intent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](../state-changes.md) : [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md)&gt; [ComposeLayoutScope](index.md)&lt;[I](../state-changes.md), [S](../state-changes.md)&gt;.[stateChanges](../state-changes.md)(): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[S](../state-changes.md)?&gt; |
