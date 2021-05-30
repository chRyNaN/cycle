//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[StateStore](index.md)



# StateStore  
 [common] interface [StateStore](index.md)<[I](index.md) : [Intent](../-intent/index.md), [C](index.md) : [Change](../-change/index.md), [S](index.md) : [State](../-state/index.md)>

A component that retains the information about the current [State](../-state/index.md) for a [Presenter](../-presenter/index.md).

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/StateStore.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/StateStore.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/StateStore/reset/#/PointingToDeclaration/"></a>[reset](reset.md)| <a name="com.chrynan.presentation/StateStore/reset/#/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [reset](reset.md)()  <br><br><br>|
| <a name="com.chrynan.presentation/StateStore/updateCurrentState/#TypeParam(bounds=[com.chrynan.presentation.State])?/PointingToDeclaration/"></a>[updateCurrentState](update-current-state.md)| <a name="com.chrynan.presentation/StateStore/updateCurrentState/#TypeParam(bounds=[com.chrynan.presentation.State])?/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [updateCurrentState](update-current-state.md)(state: [S](index.md)?)  <br><br><br>|
| <a name="com.chrynan.presentation/StateStore/updateLastChange/#TypeParam(bounds=[com.chrynan.presentation.Change])/PointingToDeclaration/"></a>[updateLastChange](update-last-change.md)| <a name="com.chrynan.presentation/StateStore/updateLastChange/#TypeParam(bounds=[com.chrynan.presentation.Change])/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [updateLastChange](update-last-change.md)(change: [C](index.md))  <br><br><br>|
| <a name="com.chrynan.presentation/StateStore/updateLastIntent/#TypeParam(bounds=[com.chrynan.presentation.Intent])/PointingToDeclaration/"></a>[updateLastIntent](update-last-intent.md)| <a name="com.chrynan.presentation/StateStore/updateLastIntent/#TypeParam(bounds=[com.chrynan.presentation.Intent])/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [updateLastIntent](update-last-intent.md)(intent: [I](index.md))  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/StateStore/currentState/#/PointingToDeclaration/"></a>[currentState](current-state.md)| <a name="com.chrynan.presentation/StateStore/currentState/#/PointingToDeclaration/"></a> [common] abstract val [currentState](current-state.md): [S](index.md)?   <br>|
| <a name="com.chrynan.presentation/StateStore/initialState/#/PointingToDeclaration/"></a>[initialState](initial-state.md)| <a name="com.chrynan.presentation/StateStore/initialState/#/PointingToDeclaration/"></a> [common] abstract val [initialState](initial-state.md): [S](index.md)?   <br>|
| <a name="com.chrynan.presentation/StateStore/isPendingStateUpdate/#/PointingToDeclaration/"></a>[isPendingStateUpdate](is-pending-state-update.md)| <a name="com.chrynan.presentation/StateStore/isPendingStateUpdate/#/PointingToDeclaration/"></a> [common] abstract val [isPendingStateUpdate](is-pending-state-update.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>|
| <a name="com.chrynan.presentation/StateStore/lastChange/#/PointingToDeclaration/"></a>[lastChange](last-change.md)| <a name="com.chrynan.presentation/StateStore/lastChange/#/PointingToDeclaration/"></a> [common] abstract val [lastChange](last-change.md): [C](index.md)?   <br>|
| <a name="com.chrynan.presentation/StateStore/lastIntent/#/PointingToDeclaration/"></a>[lastIntent](last-intent.md)| <a name="com.chrynan.presentation/StateStore/lastIntent/#/PointingToDeclaration/"></a> [common] abstract val [lastIntent](last-intent.md): [I](index.md)?   <br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.presentation/BasicStateStore///PointingToDeclaration/"></a>[BasicStateStore](../-basic-state-store/index.md)|

