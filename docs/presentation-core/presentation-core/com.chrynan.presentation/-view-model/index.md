//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[ViewModel](index.md)

# ViewModel

[common]\
abstract class [ViewModel](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt;(initialState: [S](index.md)?, dispatchers: CoroutineDispatchers) : [BaseViewModel](../-base-view-model/index.md), [Presenter](../-presenter/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt; 

A [ViewModel](index.md) is a design pattern component that acts as a bridge between the [View](../-view/index.md) and the application logic. It is responsible for coordinating the application logic, in the uni-directional flow established by this design pattern, to ultimately derive a new [State](../-state/index.md) that is to be rendered by the [View](../-view/index.md). This [ViewModel](index.md) component does not have a reference to the [View](../-view/index.md), instead the [View](../-view/index.md) has a reference to a [ViewModel](index.md), and calls the [ViewModel.renderStates](render-states.md) property to obtain a Flow of [State](../-state/index.md) changes that it subscribes to, so that it can update whenever the [ViewModel](index.md) derives a new [State](../-state/index.md). This simplifies the communication between the two components, by removing the cyclic dependency between the two (as is common in a traditional MVP design pattern).

This is a base implementation of the [Presenter](../-presenter/index.md) interface that provides functions for handling common functionality, such as, the [performWith](../../../../presentation-core/com.chrynan.presentation/-view-model/perform-with.md), [reduceWith](../../../../presentation-core/com.chrynan.presentation/-view-model/reduce-with.md), and [render](../../../../presentation-core/com.chrynan.presentation/-view-model/render.md) functions.

## Constructors

| | |
|---|---|
| [ViewModel](-view-model.md) | [common]<br>fun &lt;[S](index.md) : [State](../-state/index.md)&gt; [ViewModel](-view-model.md)(initialState: [S](index.md)? = null, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers) |

## Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | [common]<br>open override fun [bind](bind.md)()<br>Binds this [ViewModel](index.md). |
| [intent](intent.md) | [common]<br>open override fun [intent](intent.md)(to: [I](index.md))<br>Emits the provided [to](../-intent/index.md) value to trigger an action, that may eventually result in a new [State](../-state/index.md) being rendered. These can be caused by user input events (clicks, scrolls, etc.) or by other means. |
| [unbind](unbind.md) | [common]<br>open override fun [unbind](unbind.md)()<br>Unbinds this [ViewModel](index.md). |

## Properties

| Name | Summary |
|---|---|
| [coroutineScope](coroutine-scope.md) | [common]<br>val [coroutineScope](coroutine-scope.md): CoroutineScope |
| [currentState](current-state.md) | [common]<br>open override val [currentState](current-state.md): [S](index.md)?<br>The current [State](../-state/index.md) of type [S](index.md) that is being displayed in the [View](../-view/index.md). |
| [intents](intents.md) | [common]<br>open override val [intents](intents.md): Flow&lt;[I](index.md)&gt;<br>A Flow of all the [Intent](../-intent/index.md)s of type [I](index.md) that are emitted to this [ViewModel](index.md). |
| [isBound](is-bound.md) | [common]<br>open override var [isBound](is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>Determines if this component is currently bound to the parent component. |
| [renderStates](render-states.md) | [common]<br>open override val [renderStates](render-states.md): Flow&lt;[S](index.md)?&gt;<br>A Flow of all the [State](../-state/index.md)s of type [S](index.md) that are to be rendered in the [View](../-view/index.md). |

## Inheritors

| Name |
|---|
| [DelegatingViewModel](../-delegating-view-model/index.md) |
