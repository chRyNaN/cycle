//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[NavigationIntent](index.md)



# NavigationIntent  
 [common] interface [NavigationIntent](index.md)

Represents an intent to move to a different screen in the application. This is similar to an [Intent](../-intent/index.md) but for navigation purposes.



For example:

sealed class HomeScreenIntent : NavigationIntent {  
  
    object Feed : HomeScreenIntent()  
}   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/NavigationIntent.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/NavigationIntent.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|

