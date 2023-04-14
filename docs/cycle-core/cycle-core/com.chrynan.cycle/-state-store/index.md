//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[StateStore](index.md)

# StateStore

interface [StateStore](index.md)&lt;[State](index.md), [Change](index.md)&gt;

A component that holds the whole state tree for a [ViewModel](../-view-model/index.md). The only way to change the state inside it is to dispatch a [Change](index.md) to it.

#### See also

| | |
|---|---|
| [StateStore](index.md) | constructor function to create an instance of this interface. |

#### Inheritors

| |
|---|
| [MutableStateStore](../-mutable-state-store/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [subscribe](../subscribe.md) | [common]<br>fun &lt;[State](../subscribe.md), [Change](../subscribe.md)&gt; [StateStore](index.md)&lt;[State](../subscribe.md), [Change](../subscribe.md)&gt;.[subscribe](../subscribe.md)(coroutineScope: CoroutineScope, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, onError: suspend () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, onState: suspend ([State](../subscribe.md)?) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>A convenience function that subscribes to [State](../subscribe.md) changes on the [StateStore.states](states.md) property using the provided values. The [onError](../subscribe.md) function is invoked when an exception was encountered, and the [onState](../subscribe.md) function is invoked when a new [State](../subscribe.md) is emitted on the StateStore.states. |

## Properties

| Name | Summary |
|---|---|
| [currentState](../current-state.md) | [common]<br>val &lt;[State](../current-state.md), [Change](../current-state.md)&gt; [StateStore](index.md)&lt;[State](../current-state.md), [Change](../current-state.md)&gt;.[currentState](../current-state.md): [State](../current-state.md)?<br>Retrieves the current [State](../current-state.md) value for this [StateStore](index.md). This is equivalent to call StateFlow.value on the [StateStore.states](states.md) property, and is provided for convenience. |
| [initialState](initial-state.md) | [common]<br>abstract val [initialState](initial-state.md): [State](index.md)?<br>Retrieves the initial [State](index.md) value that was provided when this [StateStore](index.md) was created. |
| [states](states.md) | [common]<br>abstract val [states](states.md): StateFlow&lt;[State](index.md)?&gt;<br>Retrieves a StateFlow of this [StateStore](index.md)'s [State](index.md) changes. The items emitted on this StateFlow depend on mutable function calls to alter the state, such as the [MutableStateStore.dispatch](../-mutable-state-store/dispatch.md) function. The first value emitted will be the [initialState](initial-state.md) value. |
