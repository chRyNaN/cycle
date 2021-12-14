//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[DelegatingPresenter](index.md)/[performWith](perform-with.md)

# performWith

[common]\
open override fun Flow&lt;[I](index.md)&gt;.[performWith](perform-with.md)(action: [Action](../-action/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt;): Flow&lt;[C](index.md)&gt;

Converts this Flow of [Intent](../-intent/index.md)s of type [I](index.md) into a Flow of [Change](../-change/index.md)s of type [C](index.md) using the provided [action](perform-with.md).
