//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose.layout](../index.md)/[Layout](index.md)

# Layout

[common]\
@Stable

abstract class [Layout](index.md)&lt;[I](index.md) : [Intent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](index.md) : [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](index.md) : [Change](../../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; : [View](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)&lt;[I](index.md), [S](index.md)&gt; , [Bindable](../../../../presentation-core/presentation-core/com.chrynan.presentation/-bindable/index.md)

A component that implements the [View](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md) interface and serves as the binding between this presentation library and Jetpack Compose.

Example usage:

class HomeLayout : BaseLayout&lt;HomeIntent, HomeState, HomeChange&gt;() {\
\
    override val presenterFactory = ...\
\
    override fun OnLayout(state: HomeState) {\
        // Put Composable UI code here using the [state] value\
    }\
}

## Constructors

| | |
|---|---|
| [Layout](-layout.md) | [common]<br>fun [Layout](-layout.md)() |

## Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | [common]<br>open override fun [bind](bind.md)() |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [intents](intents.md) | [common]<br>open override fun [intents](intents.md)(): Flow&lt;[I](index.md)&gt; |
| [OnLayout](-on-layout.md) | [common]<br>@Composable<br>abstract fun [OnLayout](-on-layout.md)(state: [S](index.md)) |
| [render](render.md) | [common]<br>open override fun [render](render.md)(state: [S](index.md)) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [unbind](unbind.md) | [common]<br>open override fun [unbind](unbind.md)() |

## Properties

| Name | Summary |
|---|---|
| [isBound](is-bound.md) | [common]<br>open override val [isBound](is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [key](key.md) | [common]<br>open val [key](key.md): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? |
| [renderState](render-state.md) | [common]<br>open override val [renderState](render-state.md): [S](index.md)? |
| [states](states.md) | [common]<br>open override val [states](states.md): Flow&lt;[S](index.md)&gt; |

## Extensions

| Name | Summary |
|---|---|
| [unaryPlus](../unary-plus.md) | [common]<br>@Composable<br>inline operator fun &lt;[I](../unary-plus.md) : [Intent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](../unary-plus.md) : [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](../unary-plus.md) : [Change](../../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [Layout](index.md)&lt;[I](../unary-plus.md), [S](../unary-plus.md), [C](../unary-plus.md)&gt;.[unaryPlus](../unary-plus.md)()<br>Lays out the provided [layout](../layout.md) as a Composable. |
