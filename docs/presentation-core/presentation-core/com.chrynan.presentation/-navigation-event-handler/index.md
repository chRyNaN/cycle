//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[NavigationEventHandler](index.md)



# NavigationEventHandler  
 [common] interface [NavigationEventHandler](index.md)<[I](index.md) : [NavigationIntent](../-navigation-intent/index.md), [S](index.md) : [NavigationScope](../-navigation-scope/index.md)> : [NavigationHandler](../-navigation-handler/index.md)<[I](index.md), [S](index.md)> 

A [NavigationHandler](../-navigation-handler/index.md) that provides distinct functions for each of the possible [NavigationEvent](../-navigation-event/index.md)s.

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/NavigationEventHandler.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/NavigationEventHandler.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/NavigationEventHandler/onGoBack/TypeParam(bounds=[com.chrynan.presentation.NavigationScope])#/PointingToDeclaration/"></a>[onGoBack](on-go-back.md)| <a name="com.chrynan.presentation/NavigationEventHandler/onGoBack/TypeParam(bounds=[com.chrynan.presentation.NavigationScope])#/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [S](index.md).[onGoBack](on-go-back.md)()  <br><br><br>|
| <a name="com.chrynan.presentation/NavigationEventHandler/onGoTo/TypeParam(bounds=[com.chrynan.presentation.NavigationScope])#TypeParam(bounds=[com.chrynan.presentation.NavigationIntent])/PointingToDeclaration/"></a>[onGoTo](on-go-to.md)| <a name="com.chrynan.presentation/NavigationEventHandler/onGoTo/TypeParam(bounds=[com.chrynan.presentation.NavigationScope])#TypeParam(bounds=[com.chrynan.presentation.NavigationIntent])/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [S](index.md).[onGoTo](on-go-to.md)(intent: [I](index.md))  <br><br><br>|
| <a name="com.chrynan.presentation/NavigationEventHandler/onGoUp/TypeParam(bounds=[com.chrynan.presentation.NavigationScope])#/PointingToDeclaration/"></a>[onGoUp](on-go-up.md)| <a name="com.chrynan.presentation/NavigationEventHandler/onGoUp/TypeParam(bounds=[com.chrynan.presentation.NavigationScope])#/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [S](index.md).[onGoUp](on-go-up.md)()  <br><br><br>|
| <a name="com.chrynan.presentation/NavigationEventHandler/onNavigate/TypeParam(bounds=[com.chrynan.presentation.NavigationScope])#com.chrynan.presentation.NavigationEvent[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent])]/PointingToDeclaration/"></a>[onNavigate](on-navigate.md)| <a name="com.chrynan.presentation/NavigationEventHandler/onNavigate/TypeParam(bounds=[com.chrynan.presentation.NavigationScope])#com.chrynan.presentation.NavigationEvent[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent])]/PointingToDeclaration/"></a>[common]  <br>Content  <br>open override fun [S](index.md).[onNavigate](on-navigate.md)(event: [NavigationEvent](../-navigation-event/index.md)<[I](index.md)>)  <br>More info  <br>Handles the actual navigation to a different part of the app defined by the provided [event](on-navigate.md) using the [S](index.md) scope.  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.presentation.android/BasePresentationActivity///PointingToDeclaration/"></a>[BasePresentationActivity](../../com.chrynan.presentation.android/-base-presentation-activity/index.md)|
| <a name="com.chrynan.presentation.android/BasePresentationFragment///PointingToDeclaration/"></a>[BasePresentationFragment](../../com.chrynan.presentation.android/-base-presentation-fragment/index.md)|

