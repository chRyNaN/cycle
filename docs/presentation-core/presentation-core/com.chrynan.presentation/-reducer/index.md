//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Reducer](index.md)

# Reducer

[common]\
interface [Reducer](index.md)&lt;[S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt;

A [Reducer](index.md) is responsible for determining the [State](../-state/index.md) that is displayed in the UI. A [Reducer](index.md) takes the previous [State](../-state/index.md) and a [Change](../-change/index.md) and derives a new [State](../-state/index.md). The [Reducer](index.md) performs application logic.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [reduce](reduce.md) | [common]<br>abstract suspend fun [reduce](reduce.md)(previous: [S](index.md)?, change: [C](index.md)): [S](index.md)?<br>Retrieves a new [State](../-state/index.md) of type [S](index.md) from the [previous](../-state/index.md) of type [S](index.md) and the [change](reduce.md) of type [C](index.md). |

## Extensions

| Name | Summary |
|---|---|
| [create](../create.md) | [common]<br>suspend fun &lt;[S](../create.md) : [State](../-state/index.md), [C](../create.md) : [Change](../-change/index.md)&gt; [Reducer](index.md)&lt;[S](../create.md), [C](../create.md)&gt;.[create](../create.md)(previous: [S](../create.md)?, change: [C](../create.md)): [S](../create.md)?<br>A convenience operator function that delegates to the [reduce](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html) function, so that the [Reducer](index.md) class can be invoked like a function. |
