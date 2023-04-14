//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[ViewModel](index.md)

# ViewModel

@FlowPreview

@ExperimentalCoroutinesApi

abstract class [ViewModel](index.md)&lt;[State](index.md), [Change](index.md)&gt;(stateStore: [MutableStateStore](../-mutable-state-store/index.md)&lt;[State](index.md), [Change](index.md)&gt;, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, resetOnUnbind: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, flatMapStrategy: [FlatMapStrategy](../-flat-map-strategy/index.md) = FlatMapStrategy.Latest) : [PlatformViewModel](../-platform-view-model/index.md), [Bindable](../-bindable/index.md)

A [ViewModel](index.md) is a design pattern component that acts as a bridge between the [View](../-view/index.md) and the application logic. It is responsible for coordinating the application logic, in the uni-directional flow established by this design pattern, to ultimately derive a new [State](index.md) that is to be rendered by the [View](../-view/index.md). This [ViewModel](index.md) component does not have a reference to the [View](../-view/index.md), instead the [View](../-view/index.md) has a reference to a [ViewModel](index.md), and calls the [ViewModel.states](states.md) property to obtain a Flow of [State](index.md) changes that it subscribes to, so that it can update whenever the [ViewModel](index.md) derives a new [State](index.md). This simplifies the communication between the two components, by removing the cyclic dependency between the two (as is common in a traditional MVP design pattern).

A [ViewModel](index.md) wraps a [StateStore](../-state-store/index.md) component to provide more complex functionality. [ViewModel](index.md)s perform application component specific [Action](../index.md#-1083546810%2FClasslikes%2F1627176608)s to derive a Flow of [Change](index.md)s that are provided to the wrapped [StateStore](../-state-store/index.md) to reduce a new [State](index.md). Some of the [StateStore](../-state-store/index.md) functionality is exposed in a [ViewModel](index.md) by delegation, such as the [ViewModel.states](states.md) property just delegates to the [StateStore.states](../-state-store/states.md) property.

To obtain a basic [ViewModel](index.md) instance where the [Action](../index.md#-1083546810%2FClasslikes%2F1627176608)s can be provided at the call-site, use the [ViewModel.Companion.create](../create.md) functions. However, it is strongly encouraged to create [ViewModel](index.md) subclasses and provide implementation specific [Action](../index.md#-1083546810%2FClasslikes%2F1627176608) functions.

#### See also

| | |
|---|---|
| [IntentViewModel](../-intent-view-model/index.md) | for an abstract [ViewModel](index.md) implementation that works well with the MVI (Model-View-Intent) design pattern. |

#### Inheritors

| |
|---|
| [IntentViewModel](../-intent-view-model/index.md) |
| [BaseViewModel](../-base-view-model/index.md) |

## Constructors

| | |
|---|---|
| [ViewModel](-view-model.md) | [common]<br>constructor(stateStore: [MutableStateStore](../-mutable-state-store/index.md)&lt;[State](index.md), [Change](index.md)&gt;, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, resetOnUnbind: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, flatMapStrategy: [FlatMapStrategy](../-flat-map-strategy/index.md) = FlatMapStrategy.Latest) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | [common]<br>override fun [bind](bind.md)()<br>Binds this [ViewModel](index.md). |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [subscribe](subscribe.md) | [common]<br>@ExperimentalCoroutinesApi<br>@FlowPreview<br>fun [subscribe](subscribe.md)(onError: suspend () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, onState: suspend ([State](index.md)?) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>A convenience function that subscribes to [State](index.md) changes on the [ViewModel.states](states.md) property using the provided values. The [onError](subscribe.md) function is invoked when an exception was encountered, and the [onState](subscribe.md) function is invoked when a new [State](index.md) is emitted on the ViewModel.states. |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [unbind](unbind.md) | [common]<br>override fun [unbind](unbind.md)()<br>Unbinds this [ViewModel](index.md). |

## Properties

| Name | Summary |
|---|---|
| [currentState](current-state.md) | [common]<br>val [currentState](current-state.md): [State](index.md)?<br>Exposes the [stateStore](../../../../cycle-core/com.chrynan.cycle/-view-model/state-store.md)'s [StateStore.currentState](../current-state.md) property. |
| [initialState](initial-state.md) | [common]<br>val [initialState](initial-state.md): [State](index.md)?<br>Exposes the [stateStore](../../../../cycle-core/com.chrynan.cycle/-view-model/state-store.md)'s [StateStore.initialState](../-state-store/initial-state.md) property. |
| [isBound](is-bound.md) | [common]<br>override var [isBound](is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if this component is currently bound to the parent component. |
| [states](states.md) | [common]<br>val [states](states.md): StateFlow&lt;[State](index.md)?&gt;<br>Exposes the [stateStore](../../../../cycle-core/com.chrynan.cycle/-view-model/state-store.md)'s [StateStore.states](../-state-store/states.md) property. |
