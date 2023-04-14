//[cycle-core](../../../../index.md)/[com.chrynan.cycle](../../index.md)/[ViewModel](../index.md)/[Companion](index.md)

# Companion

[common]\
object [Companion](index.md)

## Functions

| Name | Summary |
|---|---|
| [create](../../create.md) | [common]<br>@FlowPreview<br>@ExperimentalCoroutinesApi<br>fun &lt;[State](../../create.md), [Change](../../create.md)&gt; [ViewModel.Companion](index.md).[create](../../create.md)(stateStore: [MutableStateStore](../../-mutable-state-store/index.md)&lt;[State](../../create.md), [Change](../../create.md)&gt;, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, resetOnUnbind: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, flatMapStrategy: [FlatMapStrategy](../../-flat-map-strategy/index.md) = FlatMapStrategy.Latest): [BaseViewModel](../../-base-view-model/index.md)&lt;[State](../../create.md), [Change](../../create.md)&gt;<br>Creates a new basic [ViewModel](../index.md) instance with the provided [stateStore](../../create.md) and parameter values. Creating a [ViewModel](../index.md) this way is convenient and useful, but for more advanced use-cases and more control, consider making discrete [ViewModel](../index.md) implementations.<br>[common]<br>@FlowPreview<br>@ExperimentalCoroutinesApi<br>fun &lt;[State](../../create.md), [Change](../../create.md)&gt; [ViewModel.Companion](index.md).[create](../../create.md)(reducer: [Reducer](../../index.md#-209270086%2FClasslikes%2F1627176608)&lt;[State](../../create.md), [Change](../../create.md)&gt;, initialState: [State](../../create.md)? = null, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, resetOnUnbind: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, flatMapStrategy: [FlatMapStrategy](../../-flat-map-strategy/index.md) = FlatMapStrategy.Latest): [BaseViewModel](../../-base-view-model/index.md)&lt;[State](../../create.md), [Change](../../create.md)&gt;<br>Creates a new basic [ViewModel](../index.md) instance with the provided [reducer](../../create.md) and parameter values. Creating a [ViewModel](../index.md) this way is convenient and useful, but for more advanced use-cases and more control, consider making discrete [ViewModel](../index.md) implementations. |
