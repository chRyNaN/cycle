//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[NavigationHandler](index.md)



# NavigationHandler  
 [common] interface [NavigationHandler](index.md)<[I](index.md) : [NavigationIntent](../-navigation-intent/index.md), [S](index.md) : [NavigationScope](../-navigation-scope/index.md)>

Handles the navigation from a [Navigator](../-navigator/index.md).

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/NavigationHandler.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/NavigationHandler.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/NavigationHandler/onNavigate/TypeParam(bounds=[com.chrynan.presentation.NavigationScope])#com.chrynan.presentation.NavigationEvent[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent])]/PointingToDeclaration/"></a>[onNavigate](on-navigate.md)| <a name="com.chrynan.presentation/NavigationHandler/onNavigate/TypeParam(bounds=[com.chrynan.presentation.NavigationScope])#com.chrynan.presentation.NavigationEvent[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent])]/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [S](index.md).[onNavigate](on-navigate.md)(event: [NavigationEvent](../-navigation-event/index.md)<[I](index.md)>)  <br>More info  <br>Handles the actual navigation to a different part of the app defined by the provided [event](on-navigate.md) using the [S](index.md) scope.  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.presentation.android/AndroidNavigationHandler///PointingToDeclaration/"></a>[AndroidNavigationHandler](../../com.chrynan.presentation.android/-android-navigation-handler/index.md)|
| <a name="com.chrynan.presentation/NavigationEventHandler///PointingToDeclaration/"></a>[NavigationEventHandler](../-navigation-event-handler/index.md)|

