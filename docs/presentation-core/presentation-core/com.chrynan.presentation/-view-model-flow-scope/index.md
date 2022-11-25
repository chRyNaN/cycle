//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[ViewModelFlowScope](index.md)

# ViewModelFlowScope

[common]\
interface [ViewModelFlowScope](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [perform](perform.md) | [common]<br>@FlowPreview<br>abstract fun Flow&lt;[I](index.md)&gt;.[perform](perform.md)(strategy: [FlatMapStrategy](../-flat-map-strategy/index.md) = FlatMapStrategy.Latest, action: suspend ([I](index.md), [S](index.md)?) -&gt; Flow&lt;[C](index.md)&gt;): Flow&lt;[C](index.md)&gt; |
| [performWith](perform-with.md) | [common]<br>@FlowPreview<br>abstract fun Flow&lt;[I](index.md)&gt;.[performWith](perform-with.md)(strategy: [FlatMapStrategy](../-flat-map-strategy/index.md) = FlatMapStrategy.Latest, action: [Action](../-action/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt;): Flow&lt;[C](index.md)&gt; |
| [reduce](reduce.md) | [common]<br>abstract fun Flow&lt;[C](index.md)&gt;.[reduce](reduce.md)(reducer: suspend ([S](index.md)?, [C](index.md)) -&gt; [S](index.md)?): Flow&lt;[S](index.md)?&gt; |
| [reduceWith](reduce-with.md) | [common]<br>abstract fun Flow&lt;[C](index.md)&gt;.[reduceWith](reduce-with.md)(reducer: [Reducer](../-reducer/index.md)&lt;[S](index.md), [C](index.md)&gt;): Flow&lt;[S](index.md)?&gt; |
| [render](render.md) | [common]<br>abstract fun Flow&lt;[S](index.md)?&gt;.[render](render.md)(): Flow&lt;[S](index.md)?&gt; |
| [startWithInitialState](start-with-initial-state.md) | [common]<br>abstract fun Flow&lt;[S](index.md)?&gt;.[startWithInitialState](start-with-initial-state.md)(): Flow&lt;[S](index.md)?&gt; |

## Inheritors

| Name |
|---|
| [ViewModel](../-view-model/index.md) |
