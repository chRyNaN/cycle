//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Reducer](index.md)



# Reducer  
 [common] interface [Reducer](index.md)<[S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)>

A [Reducer](index.md) is responsible for determining the [State](../-state/index.md) that is displayed in the UI. A [Reducer](index.md) takes the previous [State](../-state/index.md) and a [Change](../-change/index.md) and derives a new [State](../-state/index.md). The [Reducer](index.md) performs application logic.

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/Reducer.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/Reducer.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/Reducer/reduce/#TypeParam(bounds=[com.chrynan.presentation.State])?#TypeParam(bounds=[com.chrynan.presentation.Change])/PointingToDeclaration/"></a>[reduce](reduce.md)| <a name="com.chrynan.presentation/Reducer/reduce/#TypeParam(bounds=[com.chrynan.presentation.State])?#TypeParam(bounds=[com.chrynan.presentation.Change])/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract suspend fun [reduce](reduce.md)(previous: [S](index.md)?, change: [C](index.md)): [S](index.md)  <br>More info  <br>Retrieves a new [State](../-state/index.md) of type [S](index.md) from the [previous](../-state/index.md) of type [S](index.md) and the [change](reduce.md) of type [C](index.md).  <br><br><br>|


## Extensions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation//invoke/com.chrynan.presentation.Reducer[TypeParam(bounds=[com.chrynan.presentation.State]),TypeParam(bounds=[com.chrynan.presentation.Change])]#TypeParam(bounds=[com.chrynan.presentation.State])?#TypeParam(bounds=[com.chrynan.presentation.Change])/PointingToDeclaration/"></a>[invoke](../invoke.md)| <a name="com.chrynan.presentation//invoke/com.chrynan.presentation.Reducer[TypeParam(bounds=[com.chrynan.presentation.State]),TypeParam(bounds=[com.chrynan.presentation.Change])]#TypeParam(bounds=[com.chrynan.presentation.State])?#TypeParam(bounds=[com.chrynan.presentation.Change])/PointingToDeclaration/"></a>[common]  <br>Content  <br>suspend operator fun <[S](../invoke.md) : [State](../-state/index.md), [C](../invoke.md) : [Change](../-change/index.md)> [Reducer](index.md)<[S](../invoke.md), [C](../invoke.md)>.[invoke](../invoke.md)(previous: [S](../invoke.md)?, change: [C](../invoke.md)): [S](../invoke.md)  <br>More info  <br>A convenience operator function that delegates to the [reduce](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html) function, so that the [Reducer](index.md) class can be invoked like a function.  <br><br><br>|

