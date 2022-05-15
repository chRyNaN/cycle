//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[ViewModelFactory](index.md)

# ViewModelFactory

[common]\
fun interface [ViewModelFactory](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt;

A component that can create a [ViewModel](../-view-model/index.md). This allows lazy instantiation of a [ViewModel](../-view-model/index.md) which may be required to wait for the [View](../-view/index.md) to be created first, then passing that into the [invoke](invoke.md) function to create the [ViewModel](../-view-model/index.md) that will be bound to that [View](../-view/index.md).

Note that this interface is a functional interface, so an instance can be created like so:

ViewModelFactory { ... }

Example usage:

ViewModelFactory {\
    ViewModel {\
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
| [invoke](invoke.md) | [common]<br>abstract operator fun [invoke](invoke.md)(): [ViewModel](../-view-model/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt; |
