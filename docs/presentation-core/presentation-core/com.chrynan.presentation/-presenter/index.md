//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Presenter](index.md)

# Presenter

[common]\
interface [Presenter](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt; : [Bindable](../-bindable/index.md)

A [Presenter](index.md) handles the presentation logic for a [View](../-view/index.md). It coordinates the different presentation components, such as, the [Action](../-action/index.md)s and the [Reducer](../-reducer/index.md). This acts as the contract interface for the [ViewModel](../-view-model/index.md) component.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [bind](../-bindable/bind.md) | [common]<br>abstract fun [bind](../-bindable/bind.md)()<br>Binds and sets up this component. |
| [intent](intent.md) | [common]<br>abstract fun [intent](intent.md)(to: [I](index.md))<br>Emits the provided [to](../-intent/index.md) value to trigger an action, that may eventually result in a new [State](../-state/index.md) being rendered. These can be caused by user input events (clicks, scrolls, etc.) or by other means. |
| [unbind](../-bindable/unbind.md) | [common]<br>abstract fun [unbind](../-bindable/unbind.md)()<br>Unbinds and cleans up the resources used by this component. |

## Properties

| Name | Summary |
|---|---|
| [currentState](current-state.md) | [common]<br>abstract val [currentState](current-state.md): [S](index.md)?<br>The current [State](../-state/index.md) of type [S](index.md) that is being displayed in the [View](../-view/index.md). |
| [intents](intents.md) | [common]<br>abstract val [intents](intents.md): Flow&lt;[I](index.md)&gt;<br>A Flow of all the [Intent](../-intent/index.md)s of type [I](index.md) that are emitted to this [ViewModel](../-view-model/index.md). |
| [isBound](../-bindable/is-bound.md) | [common]<br>abstract val [isBound](../-bindable/is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if this component is currently bound to the parent component. |
| [renderStates](render-states.md) | [common]<br>abstract val [renderStates](render-states.md): Flow&lt;[S](index.md)?&gt;<br>A Flow of all the [State](../-state/index.md)s of type [S](index.md) that are to be rendered in the [View](../-view/index.md). |

## Inheritors

| Name |
|---|
| [ViewModel](../-view-model/index.md) |
