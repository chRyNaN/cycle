//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Action](index.md)



# Action  
 [common] interface [Action](index.md)<[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)>

An [Action](index.md) performs the function of converting an [Intent](../-intent/index.md) of type [I](index.md) into a [Change](../-change/index.md) of type [C](index.md). Unlike other components, such as, [Intent](../-intent/index.md)s and [Change](../-change/index.md)s, [Action](index.md)s are not model classes and actually perform logic. They are responsible for connecting to the business logic.



Note, however, that [Action](index.md)s shouldn't perform business logic themselves as they are still application logic components. Instead, the business logic should be handled in UseCases and Repositories and the like. The [Action](index.md) is what connects the business and application logic. It has reference to the business logic classes and invokes the appropriate functions and performs application logic on top of that to coerce the returned values into application layer components ([ViewData](../-view-data/index.md)s, [Change](../-change/index.md)s, etc).



It's common, though not required, to have [Action](index.md)s be single focused and perform a single task. For instance, if there are [Intent](../-intent/index.md)s to "Load" and "Refresh", those should be handled in separate [Action](index.md)s. Then there could either be a wrapper [Action](index.md) that properly delegates to the correct one depending on the [Intent](../-intent/index.md), or that logic could simply be handled with a Kotlin "when" condition inside the [perform](perform.md) function.

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/Action.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/Action.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/Action/perform/#TypeParam(bounds=[com.chrynan.presentation.Intent])#TypeParam(bounds=[com.chrynan.presentation.State])?/PointingToDeclaration/"></a>[perform](perform.md)| <a name="com.chrynan.presentation/Action/perform/#TypeParam(bounds=[com.chrynan.presentation.Intent])#TypeParam(bounds=[com.chrynan.presentation.State])?/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [perform](perform.md)(intent: [I](index.md), state: [S](index.md)?): Flow<[C](index.md)>  <br>More info  <br>Converts the provided [intent](perform.md) of type [I](index.md) into a Flow of type [C](index.md).  <br><br><br>|


## Extensions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation//invoke/com.chrynan.presentation.Action[TypeParam(bounds=[com.chrynan.presentation.Intent]),TypeParam(bounds=[com.chrynan.presentation.State]),TypeParam(bounds=[com.chrynan.presentation.Change])]#TypeParam(bounds=[com.chrynan.presentation.Intent])#TypeParam(bounds=[com.chrynan.presentation.State])?/PointingToDeclaration/"></a>[invoke](../invoke.md)| <a name="com.chrynan.presentation//invoke/com.chrynan.presentation.Action[TypeParam(bounds=[com.chrynan.presentation.Intent]),TypeParam(bounds=[com.chrynan.presentation.State]),TypeParam(bounds=[com.chrynan.presentation.Change])]#TypeParam(bounds=[com.chrynan.presentation.Intent])#TypeParam(bounds=[com.chrynan.presentation.State])?/PointingToDeclaration/"></a>[common]  <br>Content  <br>operator fun <[I](../invoke.md) : [Intent](../-intent/index.md), [S](../invoke.md) : [State](../-state/index.md), [C](../invoke.md) : [Change](../-change/index.md)> [Action](index.md)<[I](../invoke.md), [S](../invoke.md), [C](../invoke.md)>.[invoke](../invoke.md)(intent: [I](../invoke.md), state: [S](../invoke.md)?): Flow<[C](../invoke.md)>  <br>More info  <br>A convenience function that delegates to [Action.perform](perform.md) allowing the [Action](index.md) to be invoked like a function.  <br><br><br>|

