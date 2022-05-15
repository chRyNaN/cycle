//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[View](index.md)

# View

[common]\
interface [View](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt;

Represents a piece of UI, such as a Screen, in an application. A [View](index.md) emits [Intent](../-intent/index.md)s of type [I](index.md) to a [viewModel](view-model.md) via the [ViewModel.intent](../-view-model/intent.md) function. A [View](index.md) displays the UI for a [State](../-state/index.md) by subscribing to the [ViewModel.renderStates](../-view-model/render-states.md) flow.

A [View](index.md) contains a [ViewModel](../-view-model/index.md) which is responsible for listening to the [View](index.md)s [Intent](../-intent/index.md)s and performing all the logic to derive a new [State](../-state/index.md) which the [View](index.md) then observes and updates its UI accordingly.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [renderState](render-state.md) | [common]<br>abstract val [renderState](render-state.md): [S](index.md)?<br>The currently rendered [State](../-state/index.md). This property could briefly differ from the [ViewModel.currentState](../-view-model/current-state.md) until that state is observed by this [View](index.md) and is rendered to display. |
| [viewModel](view-model.md) | [common]<br>abstract val [viewModel](view-model.md): [ViewModel](../-view-model/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt;<br>The [ViewModel](../-view-model/index.md) this [View](index.md) uses to subscribe to [State](../-state/index.md) changes and emit [Intent](../-intent/index.md)s. The [ViewModel](../-view-model/index.md) is the binding piece of this design pattern, between the [View](index.md) and itself, that handles coordinating the flow of logic to derive a new [State](../-state/index.md) that this [View](index.md) will then observe and render to the UI. |

## Inheritors

| Name |
|---|
| [PresentationFragment](../-presentation-fragment/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [intent](../intent.md) | [common]<br>fun &lt;[I](../intent.md) : [Intent](../-intent/index.md), [S](../intent.md) : [State](../-state/index.md), [C](../intent.md) : [Change](../-change/index.md)&gt; [View](index.md)&lt;[I](../intent.md), [S](../intent.md), [C](../intent.md)&gt;.[intent](../intent.md)(to: [I](../intent.md))<br>Emits the provided [to](../-intent/index.md) value to trigger an action, that may eventually result in a new [State](../-state/index.md) being rendered. |
