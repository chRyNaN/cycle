//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[BasicStateStore](index.md)



# BasicStateStore  
 [common] class [BasicStateStore](index.md)<[I](index.md) : [Intent](../-intent/index.md), [C](index.md) : [Change](../-change/index.md), [S](index.md) : [State](../-state/index.md)>(**initialState**: [S](index.md)?) : [StateStore](../-state-store/index.md)<[I](index.md), [C](index.md), [S](index.md)>    


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/BasicStateStore/reset/#/PointingToDeclaration/"></a>[reset](reset.md)| <a name="com.chrynan.presentation/BasicStateStore/reset/#/PointingToDeclaration/"></a>[common]  <br>Content  <br>open override fun [reset](reset.md)()  <br><br><br>|
| <a name="com.chrynan.presentation/BasicStateStore/updateCurrentState/#TypeParam(bounds=[com.chrynan.presentation.State])?/PointingToDeclaration/"></a>[updateCurrentState](update-current-state.md)| <a name="com.chrynan.presentation/BasicStateStore/updateCurrentState/#TypeParam(bounds=[com.chrynan.presentation.State])?/PointingToDeclaration/"></a>[common]  <br>Content  <br>open override fun [updateCurrentState](update-current-state.md)(state: [S](index.md)?)  <br><br><br>|
| <a name="com.chrynan.presentation/BasicStateStore/updateLastChange/#TypeParam(bounds=[com.chrynan.presentation.Change])/PointingToDeclaration/"></a>[updateLastChange](update-last-change.md)| <a name="com.chrynan.presentation/BasicStateStore/updateLastChange/#TypeParam(bounds=[com.chrynan.presentation.Change])/PointingToDeclaration/"></a>[common]  <br>Content  <br>open override fun [updateLastChange](update-last-change.md)(change: [C](index.md))  <br><br><br>|
| <a name="com.chrynan.presentation/BasicStateStore/updateLastIntent/#TypeParam(bounds=[com.chrynan.presentation.Intent])/PointingToDeclaration/"></a>[updateLastIntent](update-last-intent.md)| <a name="com.chrynan.presentation/BasicStateStore/updateLastIntent/#TypeParam(bounds=[com.chrynan.presentation.Intent])/PointingToDeclaration/"></a>[common]  <br>Content  <br>open override fun [updateLastIntent](update-last-intent.md)(intent: [I](index.md))  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/BasicStateStore/currentState/#/PointingToDeclaration/"></a>[currentState](current-state.md)| <a name="com.chrynan.presentation/BasicStateStore/currentState/#/PointingToDeclaration/"></a> [common] open override var [currentState](current-state.md): [S](index.md)?   <br>|
| <a name="com.chrynan.presentation/BasicStateStore/initialState/#/PointingToDeclaration/"></a>[initialState](initial-state.md)| <a name="com.chrynan.presentation/BasicStateStore/initialState/#/PointingToDeclaration/"></a> [common] open override val [initialState](initial-state.md): [S](index.md)? = null   <br>|
| <a name="com.chrynan.presentation/BasicStateStore/isPendingStateUpdate/#/PointingToDeclaration/"></a>[isPendingStateUpdate](is-pending-state-update.md)| <a name="com.chrynan.presentation/BasicStateStore/isPendingStateUpdate/#/PointingToDeclaration/"></a> [common] open override var [isPendingStateUpdate](is-pending-state-update.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false   <br>|
| <a name="com.chrynan.presentation/BasicStateStore/lastChange/#/PointingToDeclaration/"></a>[lastChange](last-change.md)| <a name="com.chrynan.presentation/BasicStateStore/lastChange/#/PointingToDeclaration/"></a> [common] open override var [lastChange](last-change.md): [C](index.md)? = null   <br>|
| <a name="com.chrynan.presentation/BasicStateStore/lastIntent/#/PointingToDeclaration/"></a>[lastIntent](last-intent.md)| <a name="com.chrynan.presentation/BasicStateStore/lastIntent/#/PointingToDeclaration/"></a> [common] open override var [lastIntent](last-intent.md): [I](index.md)? = null   <br>|

