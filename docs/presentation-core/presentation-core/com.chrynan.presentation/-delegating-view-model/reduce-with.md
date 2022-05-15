//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[DelegatingViewModel](index.md)/[reduceWith](reduce-with.md)

# reduceWith

[common]\
open override fun Flow&lt;[C](index.md)&gt;.[reduceWith](reduce-with.md)(reducer: [Reducer](../-reducer/index.md)&lt;[S](index.md), [C](index.md)&gt;): Flow&lt;[S](index.md)?&gt;

Converts this Flow of [Change](../-change/index.md)s of type [C](index.md) into a Flow of type [S](index.md) using this [ViewModel](../-view-model/index.md)s [Reducer](../-reducer/index.md).
