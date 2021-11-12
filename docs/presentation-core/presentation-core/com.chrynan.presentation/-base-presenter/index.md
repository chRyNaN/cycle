//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[BasePresenter](index.md)

# BasePresenter

[common]\
abstract class [BasePresenter](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt;(initialState: [S](index.md)?, dispatchers: CoroutineDispatchers) : [ViewModel](../-view-model/index.md), [Presenter](../-presenter/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt; 

A base implementation of the [Presenter](../-presenter/index.md) interface that provides functions for handling common functionality, such as, the [perform](../../../../presentation-core/com.chrynan.presentation/-base-presenter/perform.md), [reduce](../../../../presentation-core/com.chrynan.presentation/-base-presenter/reduce.md), and [render](../../../../presentation-core/com.chrynan.presentation/-base-presenter/render.md) functions.

## Constructors

| | |
|---|---|
| [BasePresenter](-base-presenter.md) | [common]<br>fun &lt;[S](index.md) : [State](../-state/index.md)&gt; [BasePresenter](-base-presenter.md)(initialState: [S](index.md)? = null, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers) |

## Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | [common]<br>open override fun [bind](bind.md)()<br>Binds this [Presenter](../-presenter/index.md). |
| [unbind](unbind.md) | [common]<br>open override fun [unbind](unbind.md)()<br>Unbinds this [Presenter](../-presenter/index.md). |

## Properties

| Name | Summary |
|---|---|
| [coroutineScope](coroutine-scope.md) | [common]<br>open override val [coroutineScope](coroutine-scope.md): CoroutineScope<br>The CoroutineScope available to this [Presenter](../-presenter/index.md). |
| [currentState](current-state.md) | [common]<br>open override val [currentState](current-state.md): [S](index.md)?<br>The current [State](../-state/index.md) of type [S](index.md) that is being displayed in the [View](../-view/index.md). |
| [isBound](is-bound.md) | [common]<br>open override var [isBound](is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>Determines if this [Presenter](../-presenter/index.md) is bound to the [View](../-view/index.md) or not. A [Presenter](../-presenter/index.md) is bound to a [View](../-view/index.md) between calls to the [bind](bind.md) and [unbind](unbind.md) functions. Returns true if this [Presenter](../-presenter/index.md) is bound to the [View](../-view/index.md), false otherwise. |
| [view](../-presenter/view.md) | [common]<br>abstract val [view](../-presenter/view.md): [View](../-view/index.md)&lt;[I](index.md), [S](index.md)&gt;<br>The [View](../-view/index.md) that this [Presenter](../-presenter/index.md) handles the presentation logic for. |
