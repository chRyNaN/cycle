//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[BaseViewModel](index.md)

# BaseViewModel

[common]\
@FlowPreview

@ExperimentalCoroutinesApi

class [BaseViewModel](index.md)&lt;[State](index.md), [Change](index.md)&gt; : [ViewModel](../-view-model/index.md)&lt;[State](index.md), [Change](index.md)&gt; 

A basic implementation of the [ViewModel](../-view-model/index.md) abstract class used by the [ViewModel](../-view-model/index.md) constructor function. This implementation publicly exposes the [perform](perform.md), [performSingle](perform-single.md), and [dispatch](dispatch.md) functions. It is recommended to avoid this approach for more complex use-cases and instead create a [ViewModel](../-view-model/index.md) subclass, adding any implementation specific [Action](../index.md#-1083546810%2FClasslikes%2F1627176608) functions necessary, and leaving the [perform](perform.md), [performSingle](perform-single.md), and [dispatch](dispatch.md) functions not publicly exposed.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [bind](../-view-model/bind.md) | [common]<br>override fun [bind](../-view-model/bind.md)()<br>Binds this [ViewModel](../-view-model/index.md). |
| [dispatch](dispatch.md) | [common]<br>open override fun [dispatch](dispatch.md)(change: [Change](index.md))<br>Emits the provided [change](dispatch.md), causing it to be reduced which produces a new [State](index.md). |
| [equals](../-view-model/equals.md) | [common]<br>open operator override fun [equals](../-view-model/equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](../-view-model/hash-code.md) | [common]<br>open override fun [hashCode](../-view-model/hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [perform](perform.md) | [common]<br>open override fun [perform](perform.md)(action: [Action](../index.md#-1083546810%2FClasslikes%2F1627176608)&lt;[State](index.md), [Change](index.md)&gt;)<br>Triggers the invocation of the provided [action](perform.md) which results in the [action](perform.md)'s [Change](index.md)s being reduced and producing a new [State](index.md). |
| [performSingle](perform-single.md) | [common]<br>open override fun [performSingle](perform-single.md)(action: suspend [State](index.md)?.() -&gt; [Change](index.md))<br>Triggers the invocation of the provided [action](perform-single.md) which results in the [action](perform-single.md)'s [Change](index.md) being reduced and producing a new [State](index.md). This function differs from the [ViewModel.perform](../../../../cycle-core/com.chrynan.cycle/-view-model/perform.md) function in that the provided [action](perform-single.md) only returns a single [Change](index.md), whereas the [ViewModel.perform](../../../../cycle-core/com.chrynan.cycle/-view-model/perform.md) function returns a Flow of [Change](index.md)s. |
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
