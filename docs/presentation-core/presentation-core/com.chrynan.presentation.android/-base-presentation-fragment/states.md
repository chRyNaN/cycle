//[presentation-core](../../../index.md)/[com.chrynan.presentation.android](../index.md)/[BasePresentationFragment](index.md)/[states](states.md)



# states  
[android]  
Content  
open override val [states](states.md): Flow<[STATE](index.md)>  
More info  


A Flow of all of the [State](../../com.chrynan.presentation/-state/index.md)s. This Flow should emit all of the distinct states provided to the [render](render.md) function.



Note that the [Presenter](../../com.chrynan.presentation/-presenter/index.md) should not subscribe to these [states](states.md) as that would create a loop.

  



