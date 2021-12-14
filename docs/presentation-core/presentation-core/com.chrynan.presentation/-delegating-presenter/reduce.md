//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[DelegatingPresenter](index.md)/[reduce](reduce.md)

# reduce

[common]\
open override fun Flow&lt;[C](index.md)&gt;.[reduce](reduce.md)(reducer: suspend ([S](index.md)?, [C](index.md)) -&gt; [S](index.md)): Flow&lt;[S](index.md)&gt;

Converts this Flow of [Change](../-change/index.md)s of type [C](index.md) into a Flow of type [S](index.md) using this [Presenter](../-presenter/index.md)s [Reducer](../-reducer/index.md).
