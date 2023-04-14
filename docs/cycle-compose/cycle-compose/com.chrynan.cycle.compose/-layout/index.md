//[cycle-compose](../../../index.md)/[com.chrynan.cycle.compose](../index.md)/[Layout](index.md)

# Layout

[common]\
@FlowPreview

@ExperimentalCoroutinesApi

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

abstract class [Layout](index.md)&lt;[State](index.md), [Change](index.md)&gt; : [View](../../../../cycle-core/cycle-core/com.chrynan.cycle/-view/index.md)&lt;[State](index.md), [Change](index.md)&gt; , [Bindable](../../../../cycle-core/cycle-core/com.chrynan.cycle/-bindable/index.md)

A component that implements the [View](../../../../cycle-core/cycle-core/com.chrynan.cycle/-view/index.md) interface and serves as the binding between this presentation library and Jetpack Compose. Typically, [Layout](index.md)s are used to represent the &quot;Screen&quot; components in an application.

Example usage:

```kotlin
class HomeLayout : Layout<HomeState, HomeChange>() {

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
| [Layout](-layout.md) | [common]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | [common]<br>override fun [bind](bind.md)() |
| [Content](-content.md) | [common]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>abstract fun [Content](-content.md)()<br>Renders the UI content for this Layout. Remember to subscribe to the state changes using the [stateChanges](../state-changes.md) function within this function. Using the [renderState](render-state.md) property won't work because it won't trigger a recomposition of the composable function when the state changes. |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [stateChanges](../state-changes.md) | [common]<br>@ExperimentalCoroutinesApi<br>@FlowPreview<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun &lt;[State](../state-changes.md), [Change](../state-changes.md)&gt; [View](../../../../cycle-core/cycle-core/com.chrynan.cycle/-view/index.md)&lt;[State](../state-changes.md), [Change](../state-changes.md)&gt;.[stateChanges](../state-changes.md)(context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[State](../state-changes.md)?&gt;<br>Obtains the changes to the underlying [State](../state-changes.md) as a Jetpack Compose [androidx.compose.runtime.State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html) value, so that the changes can cause the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function to be re-composed.<br>[common]<br>@ExperimentalCoroutinesApi<br>@FlowPreview<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun &lt;[State](../state-changes.md), [Change](../state-changes.md)&gt; [View](../../../../cycle-core/cycle-core/com.chrynan.cycle/-view/index.md)&lt;[State](../state-changes.md), [Change](../state-changes.md)&gt;.[stateChanges](../state-changes.md)(initial: [State](../state-changes.md)?, context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[State](../state-changes.md)?&gt;<br>Obtains the changes to the underlying [State](../state-changes.md), starting with the provided [initial](../state-changes.md) value, as a Jetpack Compose [androidx.compose.runtime.State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html) value, so that the changes can cause the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function to be re-composed. |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [unaryPlus](../unary-plus.md) | [common]<br>@ExperimentalCoroutinesApi<br>@FlowPreview<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>inline operator fun &lt;[State](../unary-plus.md), [Change](../unary-plus.md)&gt; [Layout](index.md)&lt;[State](../unary-plus.md), [Change](../unary-plus.md)&gt;.[unaryPlus](../unary-plus.md)()<br>Renders this [Layout](index.md) as a [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html). |
| [unbind](unbind.md) | [common]<br>override fun [unbind](unbind.md)() |

## Properties

| Name | Summary |
|---|---|
| [isBound](is-bound.md) | [common]<br>override val [isBound](is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [key](key.md) | [common]<br>open val [key](key.md): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? |
| [renderState](render-state.md) | [common]<br>override val [renderState](render-state.md): [State](index.md)? |
| [viewModel](view-model.md) | [common]<br>abstract override val [viewModel](view-model.md): [ViewModel](../../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md)&lt;[State](index.md), [Change](index.md)&gt; |
