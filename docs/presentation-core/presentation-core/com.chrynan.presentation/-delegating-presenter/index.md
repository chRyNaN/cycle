//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[DelegatingPresenter](index.md)

# DelegatingPresenter

[common]\
class [DelegatingPresenter](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt; : [BasePresenter](../-base-presenter/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt; 

An implementation of [BasePresenter](../-base-presenter/index.md) that delegates the provider properties to their corresponding [BasePresenter](../-base-presenter/index.md) equivalents. This implementation also makes a lot of the protected [BasePresenter](../-base-presenter/index.md) functions public so that they can be called in a scoped context.

## Functions

| Name | Summary |
|---|---|
| [bind](../-base-presenter/bind.md) | [common]<br>open override fun [bind](../-base-presenter/bind.md)()<br>Binds this [Presenter](../-presenter/index.md). |
| [perform](perform.md) | [common]<br>open override fun Flow&lt;[I](index.md)&gt;.[perform](perform.md)(action: suspend ([I](index.md), [S](index.md)?) -&gt; Flow&lt;[C](index.md)&gt;): Flow&lt;[C](index.md)&gt;<br>Converts this Flow of [Intent](../-intent/index.md)s of type [I](index.md) into a Flow of [Change](../-change/index.md)s of type [C](index.md) using the provided [action](perform.md) function. |
| [performWith](perform-with.md) | [common]<br>open override fun Flow&lt;[I](index.md)&gt;.[performWith](perform-with.md)(action: [Action](../-action/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt;): Flow&lt;[C](index.md)&gt;<br>Converts this Flow of [Intent](../-intent/index.md)s of type [I](index.md) into a Flow of [Change](../-change/index.md)s of type [C](index.md) using the provided [action](perform-with.md). |
| [reduce](reduce.md) | [common]<br>open override fun Flow&lt;[C](index.md)&gt;.[reduce](reduce.md)(reducer: suspend ([S](index.md)?, [C](index.md)) -&gt; [S](index.md)): Flow&lt;[S](index.md)&gt;<br>Converts this Flow of [Change](../-change/index.md)s of type [C](index.md) into a Flow of type [S](index.md) using this [Presenter](../-presenter/index.md)s [Reducer](../-reducer/index.md). |
| [reduceWith](reduce-with.md) | [common]<br>open override fun Flow&lt;[C](index.md)&gt;.[reduceWith](reduce-with.md)(reducer: [Reducer](../-reducer/index.md)&lt;[S](index.md), [C](index.md)&gt;): Flow&lt;[S](index.md)&gt;<br>Converts this Flow of [Change](../-change/index.md)s of type [C](index.md) into a Flow of type [S](index.md) using this [Presenter](../-presenter/index.md)s [Reducer](../-reducer/index.md). |
| [render](render.md) | [common]<br>open override fun Flow&lt;[S](index.md)&gt;.[render](render.md)(): Flow&lt;[S](index.md)&gt;<br>Renders the [State](../-state/index.md)s of type [S](index.md) from this Flow with this [Presenter](../-presenter/index.md)s [View](../-view/index.md). |
| [startWithInitialState](start-with-initial-state.md) | [common]<br>open override fun Flow&lt;[S](index.md)&gt;.[startWithInitialState](start-with-initial-state.md)(): Flow&lt;[S](index.md)&gt;<br>Emits the [initialState](../../../../presentation-core/com.chrynan.presentation/-delegating-presenter/initial-state.md) value in onStart if it is not null. |
| [unbind](../-base-presenter/unbind.md) | [common]<br>open override fun [unbind](../-base-presenter/unbind.md)()<br>Unbinds this [Presenter](../-presenter/index.md). |

## Properties

| Name | Summary |
|---|---|
| [coroutineScope](../-base-presenter/coroutine-scope.md) | [common]<br>open override val [coroutineScope](../-base-presenter/coroutine-scope.md): CoroutineScope<br>The CoroutineScope available to this [Presenter](../-presenter/index.md). |
| [currentState](../-base-presenter/current-state.md) | [common]<br>open override val [currentState](../-base-presenter/current-state.md): [S](index.md)?<br>The current [State](../-state/index.md) of type [S](../-base-presenter/index.md) that is being displayed in the [View](../-view/index.md). |
| [intents](intents.md) | [common]<br>open override val [intents](intents.md): Flow&lt;[I](index.md)&gt;<br>A Flow of all the [Intent](../-intent/index.md)s of type [I](index.md) that are emitted to this [Presenter](../-presenter/index.md). |
| [isBound](../-base-presenter/is-bound.md) | [common]<br>open override var [isBound](../-base-presenter/is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if this [Presenter](../-presenter/index.md) is bound to the [View](../-view/index.md) or not. A [Presenter](../-presenter/index.md) is bound to a [View](../-view/index.md) between calls to the [bind](../-base-presenter/bind.md) and [unbind](../-base-presenter/unbind.md) functions. Returns true if this [Presenter](../-presenter/index.md) is bound to the [View](../-view/index.md), false otherwise. |
| [renderStates](../-base-presenter/render-states.md) | [common]<br>open override val [renderStates](../-base-presenter/render-states.md): Flow&lt;[S](index.md)&gt;<br>A Flow of all the [State](../-state/index.md)s of type [S](../-base-presenter/index.md) that are to be rendered in the [View](../-view/index.md). |
