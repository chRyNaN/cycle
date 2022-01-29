//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[BasePresenterFactory](index.md)

# BasePresenterFactory

[common]\
fun interface [BasePresenterFactory](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt; : [PresenterFactory](../-presenter-factory/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt; 

An extension on a [PresenterFactory](../-presenter-factory/index.md) that returns a [BasePresenter](../-base-presenter/index.md) instead of just a [Presenter](../-presenter/index.md).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [common]<br>abstract operator override fun [invoke](invoke.md)(intents: Flow&lt;[I](index.md)&gt;): [BasePresenter](../-base-presenter/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt; |

## Extensions

| Name | Summary |
|---|---|
| [invoke](../invoke.md) | [common]<br>operator fun &lt;[I](../invoke.md) : [Intent](../-intent/index.md), [S](../invoke.md) : [State](../-state/index.md), [C](../invoke.md) : [Change](../-change/index.md)&gt; [BasePresenterFactory](index.md)&lt;[I](../invoke.md), [S](../invoke.md), [C](../invoke.md)&gt;.[invoke](../invoke.md)(view: [View](../-view/index.md)&lt;[I](../invoke.md), [S](../invoke.md)&gt;): [BasePresenter](../-base-presenter/index.md)&lt;[I](../invoke.md), [S](../invoke.md), [C](../invoke.md)&gt; |
