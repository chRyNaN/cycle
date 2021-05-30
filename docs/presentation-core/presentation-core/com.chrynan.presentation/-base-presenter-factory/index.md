//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[BasePresenterFactory](index.md)



# BasePresenterFactory  
 [common] fun fun interface [BasePresenterFactory](index.md)<[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)> : [PresenterFactory](../-presenter-factory/index.md)<[I](index.md), [S](index.md), [C](index.md)> 

An extension on a [PresenterFactory](../-presenter-factory/index.md) that returns a [BasePresenter](../-base-presenter/index.md) instead of just a [Presenter](../-presenter/index.md).

   


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/BasePresenterFactory/invoke/#com.chrynan.presentation.View[TypeParam(bounds=[com.chrynan.presentation.Intent]),TypeParam(bounds=[com.chrynan.presentation.State])]/PointingToDeclaration/"></a>[invoke](invoke.md)| <a name="com.chrynan.presentation/BasePresenterFactory/invoke/#com.chrynan.presentation.View[TypeParam(bounds=[com.chrynan.presentation.Intent]),TypeParam(bounds=[com.chrynan.presentation.State])]/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract operator override fun [invoke](invoke.md)(view: [View](../-view/index.md)<[I](index.md), [S](index.md)>): [BasePresenter](../-base-presenter/index.md)<[I](index.md), [S](index.md), [C](index.md)>  <br><br><br>|

