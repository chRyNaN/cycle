//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[TimeTravelStateStore](index.md)

# TimeTravelStateStore

@[ExperimentalTime](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.time/-experimental-time/index.html)

interface [TimeTravelStateStore](index.md)&lt;[State](index.md), [Change](index.md)&gt; : [MutableStackStateStore](../-mutable-stack-state-store/index.md)&lt;[State](index.md), [Change](index.md)&gt; 

A [MutableStackStateStore](../-mutable-stack-state-store/index.md) that has basic backwards &quot;time-travel&quot; functionality that allows going back to a previous [State](index.md) a certain time ago.

#### See also

| | |
|---|---|
| [TimeTravelStateStore](index.md) | constructor function to create an instance of this interface. |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [asStateStore](../as-state-store.md) | [common]<br>fun &lt;[State](../as-state-store.md), [Change](../as-state-store.md)&gt; [MutableStateStore](../-mutable-state-store/index.md)&lt;[State](../as-state-store.md), [Change](../as-state-store.md)&gt;.[asStateStore](../as-state-store.md)(): [StateStore](../-state-store/index.md)&lt;[State](../as-state-store.md), [Change](../as-state-store.md)&gt;<br>Retrieves a non-mutable [StateStore](../-state-store/index.md) instance of this [MutableStateStore](../-mutable-state-store/index.md). |
| [dispatch](../-mutable-state-store/dispatch.md) | [common]<br>abstract suspend fun [dispatch](../-mutable-state-store/dispatch.md)(change: [Change](index.md))<br>Dispatches the provided [change](../-mutable-state-store/dispatch.md) to be reduced and the resulting new [State](../-mutable-state-store/index.md) value to be used as the current [State](../-mutable-state-store/index.md), updating associated values and emitting the value on the states. |
| [pop](../-mutable-stack-state-store/pop.md) | [common]<br>abstract fun [pop](../-mutable-stack-state-store/pop.md)()<br>Attempts to drop the current [State](../-mutable-stack-state-store/index.md) and go back to the previous [State](../-mutable-stack-state-store/index.md) value before this one. If there is no previous [State](../-mutable-stack-state-store/index.md) value, this will have no effect.<br>[common]<br>abstract fun [pop](pop.md)(duration: [Duration](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.time/-duration/index.html))<br>Attempts to drop the [State](index.md)s on the state stack until the one that was present at the current time minus the provided [duration](pop.md). If there is no previous [State](index.md), this will have no effect. If the provided [duration](pop.md) is back past the time when the [initialState](../../../../cycle-core/com.chrynan.cycle/-time-travel-state-store/initial-state.md) was added, then all items will be dropped except the [initialState](../../../../cycle-core/com.chrynan.cycle/-time-travel-state-store/initial-state.md) and the [currentState](../current-state.md) value will equal the [initialState](../../../../cycle-core/com.chrynan.cycle/-time-travel-state-store/initial-state.md). If the provided [duration](pop.md) is a negative value, this will have no effect. |
| [push](../-mutable-stack-state-store/push.md) | [common]<br>open suspend fun [push](../-mutable-stack-state-store/push.md)(change: [Change](index.md))<br>A convenience function for invoking the [dispatch](../../../../cycle-core/com.chrynan.cycle/-mutable-stack-state-store/dispatch.md) function. |
| [replay](replay.md) | [common]<br>abstract suspend fun [replay](replay.md)()<br>Re-emits the [State](index.md)s in the order that they were first displayed and at the time intervals that they were first displayed. Implementations may ignore mutations while the replay is occurring. |
| [reset](../-mutable-state-store/reset.md) | [common]<br>abstract fun [reset](../-mutable-state-store/reset.md)()<br>Reverts this [StateStore](../-state-store/index.md) back to its original state. This function will cause the states current value to be set back to the [initialState](../../../../cycle-core/com.chrynan.cycle/-mutable-state-store/initial-state.md). |
| [subscribe](../subscribe.md) | [common]<br>fun &lt;[State](../subscribe.md), [Change](../subscribe.md)&gt; [StateStore](../-state-store/index.md)&lt;[State](../subscribe.md), [Change](../subscribe.md)&gt;.[subscribe](../subscribe.md)(coroutineScope: CoroutineScope, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, onError: suspend () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, onState: suspend ([State](../subscribe.md)?) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>A convenience function that subscribes to [State](../subscribe.md) changes on the [StateStore.states](../-state-store/states.md) property using the provided values. The [onError](../subscribe.md) function is invoked when an exception was encountered, and the [onState](../subscribe.md) function is invoked when a new [State](../subscribe.md) is emitted on the StateStore.states. |

## Properties

| Name | Summary |
|---|---|
| [currentState](../current-state.md) | [common]<br>val &lt;[State](../current-state.md), [Change](../current-state.md)&gt; [StateStore](../-state-store/index.md)&lt;[State](../current-state.md), [Change](../current-state.md)&gt;.[currentState](../current-state.md): [State](../current-state.md)?<br>Retrieves the current [State](../current-state.md) value for this [StateStore](../-state-store/index.md). This is equivalent to call StateFlow.value on the [StateStore.states](../-state-store/states.md) property, and is provided for convenience. |
| [initialState](../-state-store/initial-state.md) | [common]<br>abstract val [initialState](../-state-store/initial-state.md): [State](index.md)?<br>Retrieves the initial [State](../-state-store/index.md) value that was provided when this [StateStore](../-state-store/index.md) was created. |
| [states](../-state-store/states.md) | [common]<br>abstract val [states](../-state-store/states.md): StateFlow&lt;[State](index.md)?&gt;<br>Retrieves a StateFlow of this [StateStore](../-state-store/index.md)'s [State](../-state-store/index.md) changes. The items emitted on this StateFlow depend on mutable function calls to alter the state, such as the [MutableStateStore.dispatch](../-mutable-state-store/dispatch.md) function. The first value emitted will be the [initialState](../-state-store/initial-state.md) value. |
