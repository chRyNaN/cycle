//[presentation-core](../../../index.md)/[com.chrynan.presentation.android](../index.md)/[BasePresentationFragment](index.md)/[states](states.md)

# states

[android]\
open override val [states](states.md): Flow&lt;[STATE](index.md)&gt;

A Flow of all of the [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md)s. This Flow should emit all of the distinct states provided to the [render](render.md) function.

Note that the [Presenter](../../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter/index.md) should not subscribe to these [states](states.md) as that would create a loop.
