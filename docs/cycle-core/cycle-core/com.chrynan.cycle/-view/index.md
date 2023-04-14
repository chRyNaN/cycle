//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[View](index.md)

# View

@ExperimentalCoroutinesApi

@FlowPreview

interface [View](index.md)&lt;[State](index.md), [Change](index.md)&gt;

Represents a piece of UI, such as a Screen, in an application. A [View](index.md) contains a [ViewModel](../-view-model/index.md) which it binds to its lifecycle and uses to subscribe to state changes to update the UI. The [View](index.md) implementation is responsible for manually handling the coordination of the [ViewModel](../-view-model/index.md) lifecycle and subscription.

#### Inheritors

| |
|---|
| [PresentationFragment](../../../../cycle-core/cycle-core/com.chrynan.cycle/-presentation-fragment/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [renderState](render-state.md) | [common]<br>abstract val [renderState](render-state.md): [State](index.md)?<br>The currently rendered [State](index.md). This property could briefly differ from the [ViewModel.currentState](../-view-model/current-state.md) until that state is observed by this [View](index.md) and is rendered to display. |
| [viewModel](view-model.md) | [common]<br>abstract val [viewModel](view-model.md): [ViewModel](../-view-model/index.md)&lt;[State](index.md), [Change](index.md)&gt;<br>The [ViewModel](../-view-model/index.md) this [View](index.md) uses to subscribe to [State](index.md) changes. The [ViewModel](../-view-model/index.md) is the binding piece of this design pattern that handles coordinating the flow of logic to derive a new [State](index.md) that this [View](index.md) will then observe and render to the UI. |
