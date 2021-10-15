//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[View](index.md)/[states](states.md)

# states

[common]\
abstract val [states](states.md): Flow&lt;[S](index.md)&gt;

A Flow of all of the [State](../-state/index.md)s. This Flow should emit all of the distinct states provided to the [render](render.md) function.

Note that the [Presenter](../-presenter/index.md) should not subscribe to these [states](states.md) as that would create a loop.
