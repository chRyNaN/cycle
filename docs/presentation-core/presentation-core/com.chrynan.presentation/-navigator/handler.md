//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Navigator](index.md)/[handler](handler.md)



# handler  
[common]  
Content  
abstract val [handler](handler.md): [NavigationHandler](../-navigation-handler/index.md)<[I](index.md), [S](index.md)>  
More info  


The [NavigationHandler](../-navigation-handler/index.md) that is used to change between the different screens of the app.



Note that this is provided for convenience, such as checking which handler was set, but the functions of the [handler](handler.md) should not be invoked directly. Instead, let this [Navigator](index.md) properly handle invoking the [handler](handler.md) functions.

  



