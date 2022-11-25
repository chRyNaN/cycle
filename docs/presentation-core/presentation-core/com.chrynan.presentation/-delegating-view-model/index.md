//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[DelegatingViewModel](index.md)

# DelegatingViewModel

[common]\
class [DelegatingViewModel](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt; : [ViewModel](../-view-model/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt; 

An implementation of [ViewModel](../-view-model/index.md) that delegates the provider properties to their corresponding [ViewModel](../-view-model/index.md) equivalents. This implementation also makes a lot of the protected [ViewModel](../-view-model/index.md) functions public so that they can be called in a scoped context.

## Functions

| Name | Summary |
|---|---|
| [bind](../-view-model/bind.md) | [common]<br>override fun [bind](../-view-model/bind.md)()<br>Binds this [ViewModel](../-view-model/index.md). |
| [intent](../-view-model/intent.md) | [common]<br>open override fun [intent](../-view-model/intent.md)(to: [I](index.md))<br>Emits the provided [to](../-intent/index.md) value to trigger an action, that may eventually result in a new [State](../-state/index.md) being rendered. These can be caused by user input events (clicks, scrolls, etc.) or by other means. |
| [perform](../-view-model/perform.md) | [common]<br>open override fun Flow&lt;[I](index.md)&gt;.[perform](../-view-model/perform.md)(strategy: [FlatMapStrategy](../-flat-map-strategy/index.md), action: suspend ([I](index.md), [S](index.md)?) -&gt; Flow&lt;[C](index.md)&gt;): Flow&lt;[C](index.md)&gt;<br>Converts this Flow of [Intent](../-intent/index.md)s of type [I](../-view-model/index.md) into a Flow of [Change](../-change/index.md)s of type [C](../-view-model/index.md) using the provided [action](../-view-model/perform.md) function. |
| [performWith](../-view-model/perform-with.md) | [common]<br>open override fun Flow&lt;[I](index.md)&gt;.[performWith](../-view-model/perform-with.md)(strategy: [FlatMapStrategy](../-flat-map-strategy/index.md), action: [Action](../-action/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt;): Flow&lt;[C](index.md)&gt;<br>Converts this Flow of [Intent](../-intent/index.md)s of type [I](../-view-model/index.md) into a Flow of [Change](../-change/index.md)s of type [C](../-view-model/index.md) using the provided [action](../-view-model/perform-with.md). |
| [reduce](../-view-model/reduce.md) | [common]<br>open override fun Flow&lt;[C](index.md)&gt;.[reduce](../-view-model/reduce.md)(reducer: suspend ([S](index.md)?, [C](index.md)) -&gt; [S](index.md)?): Flow&lt;[S](index.md)?&gt;<br>Converts this Flow of [Change](../-change/index.md)s of type [C](../-view-model/index.md) into a Flow of type [S](../-view-model/index.md) using this [ViewModel](../-view-model/index.md)s [Reducer](../-reducer/index.md). |
| [reduceWith](../-view-model/reduce-with.md) | [common]<br>open override fun Flow&lt;[C](index.md)&gt;.[reduceWith](../-view-model/reduce-with.md)(reducer: [Reducer](../-reducer/index.md)&lt;[S](index.md), [C](index.md)&gt;): Flow&lt;[S](index.md)?&gt;<br>Converts this Flow of [Change](../-change/index.md)s of type [C](../-view-model/index.md) into a Flow of type [S](../-view-model/index.md) using this [ViewModel](../-view-model/index.md)s [Reducer](../-reducer/index.md). |
| [render](../-view-model/render.md) | [common]<br>open override fun Flow&lt;[S](index.md)?&gt;.[render](../-view-model/render.md)(): Flow&lt;[S](index.md)?&gt;<br>Renders the [State](../-state/index.md)s of type [S](../-view-model/index.md) from this Flow with this [ViewModel](../-view-model/index.md)s [View](../-view/index.md). |
| [startWithInitialState](../-view-model/start-with-initial-state.md) | [common]<br>open override fun Flow&lt;[S](index.md)?&gt;.[startWithInitialState](../-view-model/start-with-initial-state.md)(): Flow&lt;[S](index.md)?&gt;<br>Emits the [initialState](../../../../presentation-core/com.chrynan.presentation/-view-model/initial-state.md) value in onStart if it is not null. |
| [unbind](../-view-model/unbind.md) | [common]<br>override fun [unbind](../-view-model/unbind.md)()<br>Unbinds this [ViewModel](../-view-model/index.md). |

## Properties

| Name | Summary |
|---|---|
| [coroutineScope](../-view-model/coroutine-scope.md) | [common]<br>val [coroutineScope](../-view-model/coroutine-scope.md): CoroutineScope |
| [currentState](../-view-model/current-state.md) | [common]<br>open override val [currentState](../-view-model/current-state.md): [S](index.md)?<br>The current [State](../-state/index.md) of type [S](../-view-model/index.md) that is being displayed in the [View](../-view/index.md). |
| [intents](../-view-model/intents.md) | [common]<br>open override val [intents](../-view-model/intents.md): Flow&lt;[I](index.md)&gt;<br>A Flow of all the [Intent](../-intent/index.md)s of type [I](../-view-model/index.md) that are emitted to this [ViewModel](../-view-model/index.md). |
| [isBound](../-view-model/is-bound.md) | [common]<br>open override var [isBound](../-view-model/is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if this component is currently bound to the parent component. |
| [renderStates](../-view-model/render-states.md) | [common]<br>open override val [renderStates](../-view-model/render-states.md): Flow&lt;[S](index.md)?&gt;<br>A Flow of all the [State](../-state/index.md)s of type [S](../-view-model/index.md) that are to be rendered in the [View](../-view/index.md). |
