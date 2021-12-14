//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[DelegatingPresenter](index.md)/[perform](perform.md)

# perform

[common]\
open override fun Flow&lt;[I](index.md)&gt;.[perform](perform.md)(action: suspend ([I](index.md), [S](index.md)?) -&gt; Flow&lt;[C](index.md)&gt;): Flow&lt;[C](index.md)&gt;

Converts this Flow of [Intent](../-intent/index.md)s of type [I](index.md) into a Flow of [Change](../-change/index.md)s of type [C](index.md) using the provided [action](perform.md) function.
