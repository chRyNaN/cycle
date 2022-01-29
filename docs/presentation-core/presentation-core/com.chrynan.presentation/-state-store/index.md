//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[StateStore](index.md)

# StateStore

[common]\
interface [StateStore](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [C](index.md) : [Change](../-change/index.md), [S](index.md) : [State](../-state/index.md)&gt;

A component that retains the information about the current [State](../-state/index.md) for a [Presenter](../-presenter/index.md).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

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
| [currentState](current-state.md) | [common]<br>abstract val [currentState](current-state.md): [S](index.md)? |
| [initialState](initial-state.md) | [common]<br>abstract val [initialState](initial-state.md): [S](index.md)? |
| [isPendingStateUpdate](is-pending-state-update.md) | [common]<br>abstract val [isPendingStateUpdate](is-pending-state-update.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [lastChange](last-change.md) | [common]<br>abstract val [lastChange](last-change.md): [C](index.md)? |
| [lastIntent](last-intent.md) | [common]<br>abstract val [lastIntent](last-intent.md): [I](index.md)? |
| [states](states.md) | [common]<br>abstract val [states](states.md): Flow&lt;[S](index.md)?&gt; |

## Inheritors

| Name |
|---|
| [BasicStateStore](../-basic-state-store/index.md) |
