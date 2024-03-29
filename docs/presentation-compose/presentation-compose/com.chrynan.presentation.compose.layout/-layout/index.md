//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose.layout](../index.md)/[Layout](index.md)

# Layout

[common]\
@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

abstract class [Layout](index.md)&lt;[I](index.md) : [Intent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](index.md) : [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](index.md) : [Change](../../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; : [View](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt; , [Bindable](../../../../presentation-core/presentation-core/com.chrynan.presentation/-bindable/index.md)

A component that implements the [View](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md) interface and serves as the binding between this presentation library and Jetpack Compose. Typically, [Layout](index.md)s are used to represent the &quot;Screen&quot; components in an application.

Example usage:

```kotlin
class HomeLayout : Layout<HomeIntent, HomeState, HomeChange>() {

    override val viewModel = ViewModel<I, S, C>(
            perform = { intent, state -> ... },
            reduce = { state, change -> ... })

    @Composable
    override fun Content() {
        val state by stateChanges()

        // Put Composable UI code here using the [state] value
    }
}
```

## Constructors

| | |
|---|---|
| [Layout](-layout.md) | [common]<br>fun [Layout](-layout.md)() |

## Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | [common]<br>override fun [bind](bind.md)() |
| [Content](-content.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>abstract fun [Content](-content.md)()<br>Renders the UI content for this Layout. |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [unbind](unbind.md) | [common]<br>override fun [unbind](unbind.md)() |

## Properties

| Name | Summary |
|---|---|
| [isBound](is-bound.md) | [common]<br>override val [isBound](is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [key](key.md) | [common]<br>open val [key](key.md): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? |
| [renderState](render-state.md) | [common]<br>override val [renderState](render-state.md): [S](index.md)? |
| [viewModel](view-model.md) | [common]<br>abstract override val [viewModel](view-model.md): [ViewModel](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view-model/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt; |

## Extensions

| Name | Summary |
|---|---|
| [stateChanges](../../com.chrynan.presentation.compose/state-changes.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun &lt;[I](../../com.chrynan.presentation.compose/state-changes.md) : [Intent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](../../com.chrynan.presentation.compose/state-changes.md) : [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](../../com.chrynan.presentation.compose/state-changes.md) : [Change](../../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [View](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)&lt;[I](../../com.chrynan.presentation.compose/state-changes.md), [S](../../com.chrynan.presentation.compose/state-changes.md), [C](../../com.chrynan.presentation.compose/state-changes.md)&gt;.[stateChanges](../../com.chrynan.presentation.compose/state-changes.md)(context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[S](../../com.chrynan.presentation.compose/state-changes.md)?&gt;<br>Obtains the changes to the underlying [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md) as a Jetpack Compose [androidx.compose.runtime.State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html) value, so that the changes can cause the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function to be re-composed.<br>[common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun &lt;[I](../../com.chrynan.presentation.compose/state-changes.md) : [Intent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](../../com.chrynan.presentation.compose/state-changes.md) : [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](../../com.chrynan.presentation.compose/state-changes.md) : [Change](../../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [View](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)&lt;[I](../../com.chrynan.presentation.compose/state-changes.md), [S](../../com.chrynan.presentation.compose/state-changes.md), [C](../../com.chrynan.presentation.compose/state-changes.md)&gt;.[stateChanges](../../com.chrynan.presentation.compose/state-changes.md)(initial: [S](../../com.chrynan.presentation.compose/state-changes.md)?, context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[S](../../com.chrynan.presentation.compose/state-changes.md)?&gt;<br>Obtains the changes to the underlying [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), starting with the provided [initial](../../com.chrynan.presentation.compose/state-changes.md) value, as a Jetpack Compose [androidx.compose.runtime.State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html) value, so that the changes can cause the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function to be re-composed. |
| [unaryPlus](../unary-plus.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>inline operator fun &lt;[I](../unary-plus.md) : [Intent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](../unary-plus.md) : [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](../unary-plus.md) : [Change](../../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [Layout](index.md)&lt;[I](../unary-plus.md), [S](../unary-plus.md), [C](../unary-plus.md)&gt;.[unaryPlus](../unary-plus.md)()<br>Lays out the provided [layout](../layout.md) as a [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html). |
