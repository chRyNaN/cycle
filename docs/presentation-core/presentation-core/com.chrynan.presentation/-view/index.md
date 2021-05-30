//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[View](index.md)



# View  
 [common] interface [View](index.md)<[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md)>

Represents a piece of UI, such as, a Screen. A [View](index.md) emits [Intent](../-intent/index.md)s of type [I](index.md) that are accessible to callers of the [intents](intents.md) function. A [View](index.md) displays the UI for a provided [State](../-state/index.md) when the [render](render.md) function is called. Other than the [render](render.md) function being called, a [View](index.md) should avoid updating it's UI state internally as it desires (excluding non-UI state changes such as immediate and temporary reactions to [Intent](../-intent/index.md)s, such as, the background color briefly changing when the User clicks on a item in a list).



A [View](index.md) typically contains a [Presenter](../-presenter/index.md) which is responsible for listening to the [View](index.md)s [intents](intents.md) and performing all the logic to derive a new [State](../-state/index.md) which it then passes back to the [View](index.md) via the [render](render.md) function.

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/View.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/View.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/View/intents/#/PointingToDeclaration/"></a>[intents](intents.md)| <a name="com.chrynan.presentation/View/intents/#/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [intents](intents.md)(): Flow<[I](index.md)>  <br>More info  <br>Provides all the [Intent](../-intent/index.md)s of type [I](index.md) as a Flow to the caller.  <br><br><br>|
| <a name="com.chrynan.presentation/View/render/#TypeParam(bounds=[com.chrynan.presentation.State])/PointingToDeclaration/"></a>[render](render.md)| <a name="com.chrynan.presentation/View/render/#TypeParam(bounds=[com.chrynan.presentation.State])/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract fun [render](render.md)(state: [S](index.md))  <br>More info  <br>Renders the provided [state](render.md) of type [S](index.md) into a UI.  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/View/renderState/#/PointingToDeclaration/"></a>[renderState](render-state.md)| <a name="com.chrynan.presentation/View/renderState/#/PointingToDeclaration/"></a> [common] abstract val [renderState](render-state.md): [S](index.md)?The currently rendered [State](../-state/index.md).   <br>|
| <a name="com.chrynan.presentation/View/states/#/PointingToDeclaration/"></a>[states](states.md)| <a name="com.chrynan.presentation/View/states/#/PointingToDeclaration/"></a> [common] abstract val [states](states.md): Flow<[S](index.md)>A Flow of all of the [State](../-state/index.md)s.   <br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.presentation.android/BasePresentationFragment///PointingToDeclaration/"></a>[BasePresentationFragment](../../com.chrynan.presentation.android/-base-presentation-fragment/index.md)|

