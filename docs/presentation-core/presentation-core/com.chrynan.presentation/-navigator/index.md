//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Navigator](index.md)



# Navigator  
 [common] interface [Navigator](index.md)<[S](index.md) : [NavigationIntent](../-navigation-intent/index.md)>

A [Navigator](index.md) is responsible for changing and showing the different Screens in the application. When it receives [NavigationIntent](../-navigation-intent/index.md)s from calls to the [goTo](go-to.md) function and loads the appropriate Screen.

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/Navigator.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/Navigator.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/Navigator/goBack/#/PointingToDeclaration/"></a>[goBack](go-back.md)| <a name="com.chrynan.presentation/Navigator/goBack/#/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [goBack](go-back.md)()  <br>More info  <br>Goes back to the previous Screen.  <br><br><br>|
| <a name="com.chrynan.presentation/Navigator/goTo/#TypeParam(bounds=[com.chrynan.presentation.NavigationIntent])/PointingToDeclaration/"></a>[goTo](go-to.md)| <a name="com.chrynan.presentation/Navigator/goTo/#TypeParam(bounds=[com.chrynan.presentation.NavigationIntent])/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [goTo](go-to.md)(screen: [S](index.md))  <br>More info  <br>Goes to the appropriate Screen indicated by the provided [screen](../-navigation-intent/index.md).  <br><br><br>|
| <a name="com.chrynan.presentation/Navigator/goUp/#/PointingToDeclaration/"></a>[goUp](go-up.md)| <a name="com.chrynan.presentation/Navigator/goUp/#/PointingToDeclaration/"></a>[common]  <br>Content  <br>open fun [goUp](go-up.md)()  <br>More info  <br>Goes up in the Screen stack.  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.presentation.android/BasePresentationActivity///PointingToDeclaration/"></a>[BasePresentationActivity](../../com.chrynan.presentation.android/-base-presentation-activity/index.md)|
| <a name="com.chrynan.presentation.android/BasePresentationFragment///PointingToDeclaration/"></a>[BasePresentationFragment](../../com.chrynan.presentation.android/-base-presentation-fragment/index.md)|

