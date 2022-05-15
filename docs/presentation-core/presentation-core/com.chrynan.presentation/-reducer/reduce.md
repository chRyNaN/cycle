//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Reducer](index.md)/[reduce](reduce.md)

# reduce

[common]\
abstract suspend fun [reduce](reduce.md)(previous: [S](index.md)?, change: [C](index.md)): [S](index.md)?

Retrieves a new [State](../-state/index.md) of type [S](index.md) from the [previous](../-state/index.md) of type [S](index.md) and the [change](reduce.md) of type [C](index.md).
