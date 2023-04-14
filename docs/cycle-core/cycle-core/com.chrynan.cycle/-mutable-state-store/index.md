//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[MutableStateStore](index.md)

# MutableStateStore

interface [MutableStateStore](index.md)&lt;[State](index.md), [Change](index.md)&gt; : [StateStore](../-state-store/index.md)&lt;[State](index.md), [Change](index.md)&gt; 

A mutable [StateStore](../-state-store/index.md) where the state can be altered by dispatching changes via the [dispatch](dispatch.md) function.

#### See also

| | |
|---|---|
| [MutableStateStore](index.md) | constructor function to create an instance of this interface. |

#### Inheritors

| |
|---|
| [MutableStackStateStore](../-mutable-stack-state-store/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [asStateStore](../as-state-store.md) | [common]<br>fun &lt;[State](../as-state-store.md), [Change](../as-state-store.md)&gt; [MutableStateStore](index.md)&lt;[State](../as-state-store.md), [Change](../as-state-store.md)&gt;.[asStateStore](../as-state-store.md)(): [StateStore](../-state-store/index.md)&lt;[State](../as-state-store.md), [Change](../as-state-store.md)&gt;<br>Retrieves a non-mutable [StateStore](../-state-store/index.md) instance of this [MutableStateStore](index.md). |
| [dispatch](dispatch.md) | [common]<br>abstract suspend fun [dispatch](dispatch.md)(change: [Change](index.md))<br>Dispatches the provided [change](dispatch.md) to be reduced and the resulting new [State](index.md) value to be used as the current [State](index.md), updating associated values and emitting the value on the states. |
| [reset](reset.md) | [common]<br>abstract fun [reset](reset.md)()<br>Reverts this [StateStore](../-state-store/index.md) back to its original state. This function will cause the states current value to be set back to the [initialState](../../../../cycle-core/com.chrynan.cycle/-mutable-state-store/initial-state.md). |
| [subscribe](../subscribe.md) | [common]<br>fun &lt;[State](../subscribe.md), [Change](../subscribe.md)&gt; [StateStore](../-state-store/index.md)&lt;[State](../subscribe.md), [Change](../subscribe.md)&gt;.[subscribe](../subscribe.md)(coroutineScope: CoroutineScope, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, onError: suspend () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, onState: suspend ([State](../subscribe.md)?) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>A convenience function that subscribes to [State](../subscribe.md) changes on the [StateStore.states](../-state-store/states.md) property using the provided values. The [onError](../subscribe.md) function is invoked when an exception was encountered, and the [onState](../subscribe.md) function is invoked when a new [State](../subscribe.md) is emitted on the StateStore.states. |

## Properties

| Name | Summary |
|---|---|
| [currentState](../current-state.md) | [common]<br>val &lt;[State](../current-state.md), [Change](../current-state.md)&gt; [StateStore](../-state-store/index.md)&lt;[State](../current-state.md), [Change](../current-state.md)&gt;.[currentState](../current-state.md): [State](../current-state.md)?<br>Retrieves the current [State](../current-state.md) value for this [StateStore](../-state-store/index.md). This is equivalent to call StateFlow.value on the [StateStore.states](../-state-store/states.md) property, and is provided for convenience. |
| [initialState](../-state-store/initial-state.md) | [common]<br>abstract val [initialState](../-state-store/initial-state.md): [State](index.md)?<br>Retrieves the initial [State](../-state-store/index.md) value that was provided when this [StateStore](../-state-store/index.md) was created. |
| [states](../-state-store/states.md) | [common]<br>abstract val [states](../-state-store/states.md): StateFlow&lt;[State](index.md)?&gt;<br>Retrieves a StateFlow of this [StateStore](../-state-store/index.md)'s [State](../-state-store/index.md) changes. The items emitted on this StateFlow depend on mutable function calls to alter the state, such as the [MutableStateStore.dispatch](dispatch.md) function. The first value emitted will be the [initialState](../-state-store/initial-state.md) value. |
