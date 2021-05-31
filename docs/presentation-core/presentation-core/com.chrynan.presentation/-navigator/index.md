//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Navigator](index.md)



# Navigator  
 [common] interface [Navigator](index.md)<[I](index.md) : [NavigationIntent](../-navigation-intent/index.md), [S](index.md) : [NavigationScope](../-navigation-scope/index.md)>

A [Navigator](index.md) is responsible for changing and showing the different Screens in the application.

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/Navigator.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/Navigator.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/Navigator/navigate/#com.chrynan.presentation.NavigationEvent[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent])]/PointingToDeclaration/"></a>[navigate](navigate.md)| <a name="com.chrynan.presentation/Navigator/navigate/#com.chrynan.presentation.NavigationEvent[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent])]/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [navigate](navigate.md)(event: [NavigationEvent](../-navigation-event/index.md)<[I](index.md)>)  <br>More info  <br>Navigates to the provided [event](navigate.md).  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/Navigator/handler/#/PointingToDeclaration/"></a>[handler](handler.md)| <a name="com.chrynan.presentation/Navigator/handler/#/PointingToDeclaration/"></a> [common] abstract val [handler](handler.md): [NavigationHandler](../-navigation-handler/index.md)<[I](index.md), [S](index.md)>The [NavigationHandler](../-navigation-handler/index.md) that is used to change between the different screens of the app.   <br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.presentation.android/AndroidNavigator///PointingToDeclaration/"></a>[AndroidNavigator](../../com.chrynan.presentation.android/-android-navigator/index.md)|


## Extensions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation//goBack/com.chrynan.presentation.Navigator[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent]),TypeParam(bounds=[com.chrynan.presentation.NavigationScope])]#/PointingToDeclaration/"></a>[goBack](../go-back.md)| <a name="com.chrynan.presentation//goBack/com.chrynan.presentation.Navigator[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent]),TypeParam(bounds=[com.chrynan.presentation.NavigationScope])]#/PointingToDeclaration/"></a>[common]  <br>Content  <br>fun <[I](../go-back.md) : [NavigationIntent](../-navigation-intent/index.md), [S](../go-back.md) : [NavigationScope](../-navigation-scope/index.md)> [Navigator](index.md)<[I](../go-back.md), [S](../go-back.md)>.[goBack](../go-back.md)()  <br>More info  <br>A convenience function for calling [Navigator.navigate](navigate.md) with [NavigationEvent.Back](../-navigation-event/-back/index.md).  <br><br><br>|
| <a name="com.chrynan.presentation//goTo/com.chrynan.presentation.Navigator[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent]),TypeParam(bounds=[com.chrynan.presentation.NavigationScope])]#TypeParam(bounds=[com.chrynan.presentation.NavigationIntent])/PointingToDeclaration/"></a>[goTo](../go-to.md)| <a name="com.chrynan.presentation//goTo/com.chrynan.presentation.Navigator[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent]),TypeParam(bounds=[com.chrynan.presentation.NavigationScope])]#TypeParam(bounds=[com.chrynan.presentation.NavigationIntent])/PointingToDeclaration/"></a>[common]  <br>Content  <br>fun <[I](../go-to.md) : [NavigationIntent](../-navigation-intent/index.md), [S](../go-to.md) : [NavigationScope](../-navigation-scope/index.md)> [Navigator](index.md)<[I](../go-to.md), [S](../go-to.md)>.[goTo](../go-to.md)(intent: [I](../go-to.md))  <br>More info  <br>A convenience function for calling [Navigator.navigate](navigate.md) with [NavigationEvent.To](../-navigation-event/-to/index.md).  <br><br><br>|
| <a name="com.chrynan.presentation//goUp/com.chrynan.presentation.Navigator[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent]),TypeParam(bounds=[com.chrynan.presentation.NavigationScope])]#/PointingToDeclaration/"></a>[goUp](../go-up.md)| <a name="com.chrynan.presentation//goUp/com.chrynan.presentation.Navigator[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent]),TypeParam(bounds=[com.chrynan.presentation.NavigationScope])]#/PointingToDeclaration/"></a>[common]  <br>Content  <br>fun <[I](../go-up.md) : [NavigationIntent](../-navigation-intent/index.md), [S](../go-up.md) : [NavigationScope](../-navigation-scope/index.md)> [Navigator](index.md)<[I](../go-up.md), [S](../go-up.md)>.[goUp](../go-up.md)()  <br>More info  <br>A convenience function for calling [Navigator.navigate](navigate.md) with [NavigationEvent.Up](../-navigation-event/-up/index.md).  <br><br><br>|

