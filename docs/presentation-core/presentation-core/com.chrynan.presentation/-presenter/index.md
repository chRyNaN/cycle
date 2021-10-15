//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Presenter](index.md)

# Presenter

[common]\
interface [Presenter](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt; : [Bindable](../-bindable/index.md)

A [Presenter](index.md) handles the presentation logic for a [View](../-view/index.md). It coordinates the different presentation components, such as, the [Action](../-action/index.md)s and the [Reducer](../-reducer/index.md).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | [common]<br>abstract override fun [bind](bind.md)()<br>Binds and sets up this [Presenter](index.md) for the attached [View](../-view/index.md). |
| [unbind](unbind.md) | [common]<br>abstract override fun [unbind](unbind.md)()<br>Unbinds and cleans up the resources used by this [Presenter](index.md). |

## Properties

| Name | Summary |
|---|---|
| [coroutineScope](coroutine-scope.md) | [common]<br>abstract val [coroutineScope](coroutine-scope.md): CoroutineScope<br>The CoroutineScope available to this [Presenter](index.md). |
| [currentState](current-state.md) | [common]<br>abstract val [currentState](current-state.md): [S](index.md)?<br>The current [State](../-state/index.md) of type [S](index.md) that is being displayed in the [View](../-view/index.md). |
| [isBound](is-bound.md) | [common]<br>abstract override val [isBound](is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if this [Presenter](index.md) is bound to the [View](../-view/index.md) or not. A [Presenter](index.md) is bound to a [View](../-view/index.md) between calls to the [bind](bind.md) and [unbind](unbind.md) functions. Returns true if this [Presenter](index.md) is bound to the [View](../-view/index.md), false otherwise. |
| [view](view.md) | [common]<br>abstract val [view](view.md): [View](../-view/index.md)&lt;[I](index.md), [S](index.md)&gt;<br>The [View](../-view/index.md) that this [Presenter](index.md) handles the presentation logic for. |

## Inheritors

| Name |
|---|
| [BasePresenter](../-base-presenter/index.md) |
