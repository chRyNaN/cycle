//[cycle-core](../../../../index.md)/[com.chrynan.cycle](../../index.md)/[IntentViewModel](../index.md)/[Companion](index.md)

# Companion

[common]\
object [Companion](index.md)

## Functions

| Name | Summary |
|---|---|
| [create](../../create.md) | [common]<br>@FlowPreview<br>@ExperimentalCoroutinesApi<br>fun &lt;[Intent](../../create.md), [State](../../create.md), [Change](../../create.md)&gt; [IntentViewModel.Companion](index.md).[create](../../create.md)(performIntentAction: [State](../../create.md)?.([Intent](../../create.md)) -&gt; Flow&lt;[Change](../../create.md)&gt;, stateStore: [MutableStateStore](../../-mutable-state-store/index.md)&lt;[State](../../create.md), [Change](../../create.md)&gt;, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, resetOnUnbind: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, flatMapStrategy: [FlatMapStrategy](../../-flat-map-strategy/index.md) = FlatMapStrategy.Latest): [IntentViewModel](../index.md)&lt;[Intent](../../create.md), [State](../../create.md), [Change](../../create.md)&gt;<br>Creates a new basic [IntentViewModel](../index.md) instance with the provided [performIntentAction](../../create.md), [stateStore](../../create.md) and other parameter values. Creating an [IntentViewModel](../index.md) this way is convenient and useful, but for more advanced use-cases and more control, consider making discrete [IntentViewModel](../index.md) implementations.<br>[common]<br>@FlowPreview<br>@ExperimentalCoroutinesApi<br>fun &lt;[Intent](../../create.md), [State](../../create.md), [Change](../../create.md)&gt; [IntentViewModel.Companion](index.md).[create](../../create.md)(performIntentAction: [State](../../create.md)?.([Intent](../../create.md)) -&gt; Flow&lt;[Change](../../create.md)&gt;, reducer: [Reducer](../../index.md#-209270086%2FClasslikes%2F1627176608)&lt;[State](../../create.md), [Change](../../create.md)&gt;, initialState: [State](../../create.md)? = null, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, resetOnUnbind: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, flatMapStrategy: [FlatMapStrategy](../../-flat-map-strategy/index.md) = FlatMapStrategy.Latest): [IntentViewModel](../index.md)&lt;[Intent](../../create.md), [State](../../create.md), [Change](../../create.md)&gt;<br>Creates a new basic [IntentViewModel](../index.md) instance with the provided [performIntentAction](../../create.md), [reducer](../../create.md) and other parameter values. Creating an [IntentViewModel](../index.md) this way is convenient and useful, but for more advanced use-cases and more control, consider making discrete [IntentViewModel](../index.md) implementations. |