//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[BasicStateStore](index.md)

# BasicStateStore

[common]\
class [BasicStateStore](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [C](index.md) : [Change](../-change/index.md), [S](index.md) : [State](../-state/index.md)&gt;(initialState: [S](index.md)?) : [StateStore](../-state-store/index.md)&lt;[I](index.md), [C](index.md), [S](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [reset](reset.md) | [common]<br>open override fun [reset](reset.md)() |
| [updateCurrentState](update-current-state.md) | [common]<br>open override fun [updateCurrentState](update-current-state.md)(state: [S](index.md)?) |
| [updateLastChange](update-last-change.md) | [common]<br>open override fun [updateLastChange](update-last-change.md)(change: [C](index.md)) |
| [updateLastIntent](update-last-intent.md) | [common]<br>open override fun [updateLastIntent](update-last-intent.md)(intent: [I](index.md)) |

## Properties

| Name | Summary |
|---|---|
| [currentState](current-state.md) | [common]<br>open override val [currentState](current-state.md): [S](index.md)? |
| [initialState](initial-state.md) | [common]<br>open override val [initialState](initial-state.md): [S](index.md)? = null |
| [isPendingStateUpdate](is-pending-state-update.md) | [common]<br>open override var [isPendingStateUpdate](is-pending-state-update.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [lastChange](last-change.md) | [common]<br>open override var [lastChange](last-change.md): [C](index.md)? = null |
| [lastIntent](last-intent.md) | [common]<br>open override var [lastIntent](last-intent.md): [I](index.md)? = null |
| [states](states.md) | [common]<br>open override val [states](states.md): Flow&lt;[S](index.md)?&gt; |
