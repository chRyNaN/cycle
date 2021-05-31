//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose](../index.md)/[Layout](index.md)



# Layout  
 [common] @Stable()  
  
abstract class [Layout](index.md)<[I](index.md) : [Intent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](index.md) : [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](index.md) : [Change](../../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)> : [View](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)<[I](index.md), [S](index.md)> , [Bindable](../../../../presentation-core/presentation-core/com.chrynan.presentation/-bindable/index.md)

A component that implements the [View](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md) interface and serves as the binding between this presentation library and Jetpack Compose.

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.presentation.compose/Layout/Layout/#/PointingToDeclaration/"></a>[Layout](-layout.md)| <a name="com.chrynan.presentation.compose/Layout/Layout/#/PointingToDeclaration/"></a> [common] fun [Layout](-layout.md)()   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation.compose/Layout/bind/#/PointingToDeclaration/"></a>[bind](bind.md)| <a name="com.chrynan.presentation.compose/Layout/bind/#/PointingToDeclaration/"></a>[common]  <br>Content  <br>open override fun [bind](bind.md)()  <br><br><br>|
| <a name="com.chrynan.presentation.compose/Layout/intents/#/PointingToDeclaration/"></a>[intents](intents.md)| <a name="com.chrynan.presentation.compose/Layout/intents/#/PointingToDeclaration/"></a>[common]  <br>Content  <br>open override fun [intents](intents.md)(): Flow<[I](index.md)>  <br><br><br>|
| <a name="com.chrynan.presentation.compose/Layout/OnLayout/#TypeParam(bounds=[com.chrynan.presentation.State])/PointingToDeclaration/"></a>[OnLayout](-on-layout.md)| <a name="com.chrynan.presentation.compose/Layout/OnLayout/#TypeParam(bounds=[com.chrynan.presentation.State])/PointingToDeclaration/"></a>[common]  <br>Content  <br>@Composable()  <br>  <br>abstract fun [OnLayout](-on-layout.md)(state: [S](index.md))  <br><br><br>|
| <a name="com.chrynan.presentation.compose/Layout/render/#TypeParam(bounds=[com.chrynan.presentation.State])/PointingToDeclaration/"></a>[render](render.md)| <a name="com.chrynan.presentation.compose/Layout/render/#TypeParam(bounds=[com.chrynan.presentation.State])/PointingToDeclaration/"></a>[common]  <br>Content  <br>open override fun [render](render.md)(state: [S](index.md))  <br><br><br>|
| <a name="com.chrynan.presentation.compose/Layout/unbind/#/PointingToDeclaration/"></a>[unbind](unbind.md)| <a name="com.chrynan.presentation.compose/Layout/unbind/#/PointingToDeclaration/"></a>[common]  <br>Content  <br>open override fun [unbind](unbind.md)()  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation.compose/Layout/isBound/#/PointingToDeclaration/"></a>[isBound](is-bound.md)| <a name="com.chrynan.presentation.compose/Layout/isBound/#/PointingToDeclaration/"></a> [common] open override val [isBound](is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>|
| <a name="com.chrynan.presentation.compose/Layout/key/#/PointingToDeclaration/"></a>[key](key.md)| <a name="com.chrynan.presentation.compose/Layout/key/#/PointingToDeclaration/"></a> [common] abstract val [key](key.md): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?   <br>|
| <a name="com.chrynan.presentation.compose/Layout/renderState/#/PointingToDeclaration/"></a>[renderState](render-state.md)| <a name="com.chrynan.presentation.compose/Layout/renderState/#/PointingToDeclaration/"></a> [common] open override val [renderState](render-state.md): [S](index.md)?   <br>|
| <a name="com.chrynan.presentation.compose/Layout/states/#/PointingToDeclaration/"></a>[states](states.md)| <a name="com.chrynan.presentation.compose/Layout/states/#/PointingToDeclaration/"></a> [common] open override val [states](states.md): Flow<[S](index.md)>   <br>|

