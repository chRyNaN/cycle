//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[View](index.md)

# View

[common]\
interface [View](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md)&gt;

Represents a piece of UI, such as, a Screen. A [View](index.md) emits [Intent](../-intent/index.md)s of type [I](index.md) that are accessible to callers of the [intents](intents.md) function. A [View](index.md) displays the UI for a provided [State](../-state/index.md) when the [render](render.md) function is called. Other than the [render](render.md) function being called, a [View](index.md) should avoid updating it's UI state internally as it desires (excluding non-UI state changes such as immediate and temporary reactions to [Intent](../-intent/index.md)s, such as, the background color briefly changing when the User clicks on a item in a list).

A [View](index.md) typically contains a [Presenter](../-presenter/index.md) which is responsible for listening to the [View](index.md)s [intents](intents.md) and performing all the logic to derive a new [State](../-state/index.md) which it then passes back to the [View](index.md) via the [render](render.md) function.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [intents](intents.md) | [common]<br>abstract fun [intents](intents.md)(): Flow&lt;[I](index.md)&gt;<br>Provides all the [Intent](../-intent/index.md)s of type [I](index.md) as a Flow to the caller. These can be caused by user input events (clicks, scrolls, etc) or by other means. |
| [render](render.md) | [common]<br>abstract fun [render](render.md)(state: [S](index.md))<br>Renders the provided [state](render.md) of type [S](index.md) into a UI. The [state](render.md) should have everything necessary for the [View](index.md) to display its UI. |

## Properties

| Name | Summary |
|---|---|
| [renderState](render-state.md) | [common]<br>abstract val [renderState](render-state.md): [S](index.md)?<br>The currently rendered [State](../-state/index.md). This property could briefly differ from the [Presenter.currentState](../-presenter/current-state.md) until that state is provided to the [render](render.md) function and is rendered to display. |
| [states](states.md) | [common]<br>abstract val [states](states.md): Flow&lt;[S](index.md)&gt;<br>A Flow of all of the [State](../-state/index.md)s. This Flow should emit all of the distinct states provided to the [render](render.md) function. |

## Inheritors

| Name |
|---|
| [BasePresentationFragment](../../com.chrynan.presentation.android/-base-presentation-fragment/index.md) |
