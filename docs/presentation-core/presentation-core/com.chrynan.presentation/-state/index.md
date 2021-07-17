//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[State](index.md)



# State  
 [common] interface [State](index.md) : [ViewData](../-view-data/index.md)

A [State](index.md) is a special [ViewData](../-view-data/index.md) that contains all necessary information to represent a UI. A [State](index.md) can be derived from another [State](index.md) and a [Change](../-change/index.md). Also, a [State](index.md) can be stored in a stateful component and retrieved for later usage.



A common pattern is to have a [State](index.md) represent the UI for a particular screen. So a typical approach would be to have the screen's [State](index.md) be a sealed class inheriting from this [State](index.md) interface and have descendants representing every possible UI state the screen could be in ("loading", "showing results", etc).



For example:

sealed class FeedState : State {  
  
   object LoadingInitial : FeedState()  
  
   data class LoadingMore(val currentItems: List<Item>) : FeedState()  
  
   data class Refreshing(val currentItems: List<Item>) : FeedState()  
  
   object DisplayingEmpty : FeedState()  
  
   data class DisplayingLoaded(val items: List<Item>) : FeedState()  
}

It's common to name the sealed class after the name of the screen that the [State](index.md) represents ("FeedState" -> "FeedScreen"). Also, it's common to name the descendants of the sealed class in a present tense verb manner since, at this point, the screen is "performing" this [State](index.md) ("Loading", "Refreshing", etc).

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/State.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/State.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/State/uniqueId/#/PointingToDeclaration/"></a>[uniqueId](index.md#%5Bcom.chrynan.presentation%2FState%2FuniqueId%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F769169092)| <a name="com.chrynan.presentation/State/uniqueId/#/PointingToDeclaration/"></a> [common] open val [uniqueId](index.md#%5Bcom.chrynan.presentation%2FState%2FuniqueId%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F769169092): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)A unique identifier for this [ViewData](../-view-data/index.md).   <br>|

