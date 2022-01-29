//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[PresenterFactory](index.md)

# PresenterFactory

[common]\
fun interface [PresenterFactory](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt;

A component that can create a [Presenter](../-presenter/index.md). This allows lazy instantiation of a [Presenter](../-presenter/index.md) which may be required to wait for the [View](../-view/index.md) to be created first, then passing that into the [invoke](invoke.md) function to create the [Presenter](../-presenter/index.md) that will be bound to that [View](../-view/index.md).

Note that this interface is a functional interface, so an instance can be created like so:

PresenterFactory { intents -&gt; }

Example usage:

PresenterFactory { intents -&gt;\
    Presenter(intents) {\
        this.view.intents()\
        .perform { intent, state -&gt; ... }\
        .reduce { state, change -&gt; ... }\
        .startWithInitialState()\
        .render()\
        .launchIn(coroutineScope)\
    }\
}

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [common]<br>abstract operator fun [invoke](invoke.md)(intents: Flow&lt;[I](index.md)&gt;): [Presenter](../-presenter/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt; |

## Inheritors

| Name |
|---|
| [BasePresenterFactory](../-base-presenter-factory/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [invoke](../invoke.md) | [common]<br>operator fun &lt;[I](../invoke.md) : [Intent](../-intent/index.md), [S](../invoke.md) : [State](../-state/index.md), [C](../invoke.md) : [Change](../-change/index.md)&gt; [PresenterFactory](index.md)&lt;[I](../invoke.md), [S](../invoke.md), [C](../invoke.md)&gt;.[invoke](../invoke.md)(view: [View](../-view/index.md)&lt;[I](../invoke.md), [S](../invoke.md)&gt;): [Presenter](../-presenter/index.md)&lt;[I](../invoke.md), [S](../invoke.md), [C](../invoke.md)&gt; |
