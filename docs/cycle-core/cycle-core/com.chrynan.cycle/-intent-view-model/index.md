//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[IntentViewModel](index.md)

# IntentViewModel

[common]\
@FlowPreview

@ExperimentalCoroutinesApi

abstract class [IntentViewModel](index.md)&lt;[Intent](index.md), [State](index.md), [Change](index.md)&gt;(stateStore: [MutableStateStore](../-mutable-state-store/index.md)&lt;[State](index.md), [Change](index.md)&gt;, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, resetOnUnbind: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, flatMapStrategy: [FlatMapStrategy](../-flat-map-strategy/index.md) = FlatMapStrategy.Latest) : [ViewModel](../-view-model/index.md)&lt;[State](index.md), [Change](index.md)&gt; 

An abstract implementation of a [ViewModel](../-view-model/index.md) that supports the MVI (Model-View-Intent) design pattern. Inheritors of this class must implement the [performIntentAction](../../../../cycle-core/com.chrynan.cycle/-intent-view-model/perform-intent-action.md) function which associates an [Action](../index.md#-1083546810%2FClasslikes%2F1627176608) with an [Intent](index.md). To emit an [Intent](index.md) on an [IntentViewModel](index.md), use the [IntentViewModel.intent](intent.md) function.

## Constructors

| | |
|---|---|
| [IntentViewModel](-intent-view-model.md) | [common]<br>constructor(stateStore: [MutableStateStore](../-mutable-state-store/index.md)&lt;[State](index.md), [Change](index.md)&gt;, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, resetOnUnbind: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, flatMapStrategy: [FlatMapStrategy](../-flat-map-strategy/index.md) = FlatMapStrategy.Latest) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [bind](../-view-model/bind.md) | [common]<br>override fun [bind](../-view-model/bind.md)()<br>Binds this [ViewModel](../-view-model/index.md). |
| [equals](../-view-model/equals.md) | [common]<br>open operator override fun [equals](../-view-model/equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](../-view-model/hash-code.md) | [common]<br>open override fun [hashCode](../-view-model/hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [intent](intent.md) | [common]<br>fun [intent](intent.md)(to: [Intent](index.md))<br>Triggers the invocation of the [Action](../index.md#-1083546810%2FClasslikes%2F1627176608) associated with the provided [to](index.md). This may result in a changes to the current [State](index.md). |
| [subscribe](../-view-model/subscribe.md) | [common]<br>@ExperimentalCoroutinesApi<br>@FlowPreview<br>fun [subscribe](../-view-model/subscribe.md)(onError: suspend () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, onState: suspend ([State](index.md)?) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>A convenience function that subscribes to [State](../-view-model/index.md) changes on the [ViewModel.states](../-view-model/states.md) property using the provided values. The [onError](../-view-model/subscribe.md) function is invoked when an exception was encountered, and the [onState](../-view-model/subscribe.md) function is invoked when a new [State](../-view-model/index.md) is emitted on the ViewModel.states. |
| [toString](../-view-model/to-string.md) | [common]<br>open override fun [toString](../-view-model/to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [unbind](../-view-model/unbind.md) | [common]<br>override fun [unbind](../-view-model/unbind.md)()<br>Unbinds this [ViewModel](../-view-model/index.md). |

## Properties

| Name | Summary |
|---|---|
| [currentState](../-view-model/current-state.md) | [common]<br>val [currentState](../-view-model/current-state.md): [State](index.md)?<br>Exposes the [stateStore](../../../../cycle-core/com.chrynan.cycle/-view-model/state-store.md)'s [StateStore.currentState](../current-state.md) property. |
| [initialState](../-view-model/initial-state.md) | [common]<br>val [initialState](../-view-model/initial-state.md): [State](index.md)?<br>Exposes the [stateStore](../../../../cycle-core/com.chrynan.cycle/-view-model/state-store.md)'s [StateStore.initialState](../-state-store/initial-state.md) property. |
| [isBound](../-view-model/is-bound.md) | [common]<br>override var [isBound](../-view-model/is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if this component is currently bound to the parent component. |
| [states](../-view-model/states.md) | [common]<br>val [states](../-view-model/states.md): StateFlow&lt;[State](index.md)?&gt;<br>Exposes the [stateStore](../../../../cycle-core/com.chrynan.cycle/-view-model/state-store.md)'s [StateStore.states](../-state-store/states.md) property. |
