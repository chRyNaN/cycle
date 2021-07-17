//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[PresenterFactory](index.md)



# PresenterFactory  
 [common] fun fun interface [PresenterFactory](index.md)<[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)>

A component that can create a [Presenter](../-presenter/index.md). This allows lazy instantiation of a [Presenter](../-presenter/index.md) which may be required to wait for the [View](../-view/index.md) to be created first, then passing that into the [invoke](invoke.md) function to create the [Presenter](../-presenter/index.md) that will be bound to that [View](../-view/index.md).

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/PresenterFactory.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/PresenterFactory.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/PresenterFactory/invoke/#com.chrynan.presentation.View[TypeParam(bounds=[com.chrynan.presentation.Intent]),TypeParam(bounds=[com.chrynan.presentation.State])]/PointingToDeclaration/"></a>[invoke](invoke.md)| <a name="com.chrynan.presentation/PresenterFactory/invoke/#com.chrynan.presentation.View[TypeParam(bounds=[com.chrynan.presentation.Intent]),TypeParam(bounds=[com.chrynan.presentation.State])]/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract operator fun [invoke](invoke.md)(view: [View](../-view/index.md)<[I](index.md), [S](index.md)>): [Presenter](../-presenter/index.md)<[I](index.md), [S](index.md), [C](index.md)>  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.presentation/BasePresenterFactory///PointingToDeclaration/"></a>[BasePresenterFactory](../-base-presenter-factory/index.md)|

