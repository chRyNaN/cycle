//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[BasicStateStore](index.md)

# BasicStateStore

[common]\
class [BasicStateStore](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt;(val initialState: [S](index.md)? = null) : [MutableStateStore](../-mutable-state-store/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt;

## Constructors

| | |
|---|---|
| [BasicStateStore](-basic-state-store.md) | [common]<br>fun &lt;[S](index.md) : [State](../-state/index.md)&gt; [BasicStateStore](-basic-state-store.md)(initialState: [S](index.md)? = null) |

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
| [changes](changes.md) | [common]<br>open override val [changes](changes.md): StateFlow&lt;[Event](../-event/index.md)&lt;[C](index.md)&gt;?&gt; |
| [currentState](../-state-store/current-state.md) | [common]<br>open val [currentState](../-state-store/current-state.md): [S](index.md)? |
| [initialState](initial-state.md) | [common]<br>open override val [initialState](initial-state.md): [S](index.md)? = null |
| [intents](intents.md) | [common]<br>open override val [intents](intents.md): StateFlow&lt;[Event](../-event/index.md)&lt;[I](index.md)&gt;?&gt; |
| [isPendingStateUpdate](is-pending-state-update.md) | [common]<br>open override var [isPendingStateUpdate](is-pending-state-update.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [lastChange](../-state-store/last-change.md) | [common]<br>open val [lastChange](../-state-store/last-change.md): [C](index.md)? |
| [lastIntent](../-state-store/last-intent.md) | [common]<br>open val [lastIntent](../-state-store/last-intent.md): [I](index.md)? |
| [states](states.md) | [common]<br>open override val [states](states.md): StateFlow&lt;[Event](../-event/index.md)&lt;[S](index.md)?&gt;&gt; |
