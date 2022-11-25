//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[MutableStateStore](index.md)

# MutableStateStore

[common]\
interface [MutableStateStore](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt; : [StateStore](../-state-store/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [reset](reset.md) | [common]<br>abstract fun [reset](reset.md)() |
| [updateCurrentState](update-current-state.md) | [common]<br>abstract fun [updateCurrentState](update-current-state.md)(state: [S](index.md)?) |
| [updateLastChange](update-last-change.md) | [common]<br>abstract fun [updateLastChange](update-last-change.md)(change: [C](index.md)) |
| [updateLastIntent](update-last-intent.md) | [common]<br>abstract fun [updateLastIntent](update-last-intent.md)(intent: [I](index.md)) |

## Properties

| Name | Summary |
|---|---|
| [changes](../-state-store/changes.md) | [common]<br>abstract val [changes](../-state-store/changes.md): StateFlow&lt;[Event](../-event/index.md)&lt;[C](index.md)&gt;?&gt; |
| [currentState](../-state-store/current-state.md) | [common]<br>open val [currentState](../-state-store/current-state.md): [S](index.md)? |
| [initialState](../-state-store/initial-state.md) | [common]<br>abstract val [initialState](../-state-store/initial-state.md): [S](index.md)? |
| [intents](../-state-store/intents.md) | [common]<br>abstract val [intents](../-state-store/intents.md): StateFlow&lt;[Event](../-event/index.md)&lt;[I](index.md)&gt;?&gt; |
| [isPendingStateUpdate](../-state-store/is-pending-state-update.md) | [common]<br>abstract val [isPendingStateUpdate](../-state-store/is-pending-state-update.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [lastChange](../-state-store/last-change.md) | [common]<br>open val [lastChange](../-state-store/last-change.md): [C](index.md)? |
| [lastIntent](../-state-store/last-intent.md) | [common]<br>open val [lastIntent](../-state-store/last-intent.md): [I](index.md)? |
| [states](../-state-store/states.md) | [common]<br>abstract val [states](../-state-store/states.md): StateFlow&lt;[Event](../-event/index.md)&lt;[S](index.md)?&gt;&gt; |

## Inheritors

| Name |
|---|
| [BasicStateStore](../-basic-state-store/index.md) |
