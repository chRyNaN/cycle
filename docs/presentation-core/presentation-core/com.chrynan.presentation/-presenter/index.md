//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Presenter](index.md)



# Presenter  
 [common] interface [Presenter](index.md)<[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)> : [Bindable](../-bindable/index.md)

A [Presenter](index.md) handles the presentation logic for a [View](../-view/index.md). It coordinates the different presentation components, such as, the [Action](../-action/index.md)s and the [Reducer](../-reducer/index.md).

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/Presenter.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/Presenter.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/Presenter/bind/#/PointingToDeclaration/"></a>[bind](bind.md)| <a name="com.chrynan.presentation/Presenter/bind/#/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract override fun [bind](bind.md)()  <br>More info  <br>Binds and sets up this [Presenter](index.md) for the attached [View](../-view/index.md).  <br><br><br>|
| <a name="com.chrynan.presentation/Presenter/unbind/#/PointingToDeclaration/"></a>[unbind](unbind.md)| <a name="com.chrynan.presentation/Presenter/unbind/#/PointingToDeclaration/"></a>[common]  <br>Content  <br>abstract override fun [unbind](unbind.md)()  <br>More info  <br>Unbinds and cleans up the resources used by this [Presenter](index.md).  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/Presenter/coroutineScope/#/PointingToDeclaration/"></a>[coroutineScope](coroutine-scope.md)| <a name="com.chrynan.presentation/Presenter/coroutineScope/#/PointingToDeclaration/"></a> [common] abstract val [coroutineScope](coroutine-scope.md): CoroutineScopeThe CoroutineScope available to this [Presenter](index.md).   <br>|
| <a name="com.chrynan.presentation/Presenter/currentState/#/PointingToDeclaration/"></a>[currentState](current-state.md)| <a name="com.chrynan.presentation/Presenter/currentState/#/PointingToDeclaration/"></a> [common] abstract val [currentState](current-state.md): [S](index.md)?The current [State](../-state/index.md) of type [S](index.md) that is being displayed in the [View](../-view/index.md).   <br>|
| <a name="com.chrynan.presentation/Presenter/isBound/#/PointingToDeclaration/"></a>[isBound](is-bound.md)| <a name="com.chrynan.presentation/Presenter/isBound/#/PointingToDeclaration/"></a> [common] abstract override val [isBound](is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Determines if this [Presenter](index.md) is bound to the [View](../-view/index.md) or not.   <br>|
| <a name="com.chrynan.presentation/Presenter/reducer/#/PointingToDeclaration/"></a>[reducer](reducer.md)| <a name="com.chrynan.presentation/Presenter/reducer/#/PointingToDeclaration/"></a> [common] abstract val [reducer](reducer.md): [Reducer](../-reducer/index.md)<[S](index.md), [C](index.md)>?The [Reducer](../-reducer/index.md) used to derive the [State](../-state/index.md) of the [View](../-view/index.md).   <br>|
| <a name="com.chrynan.presentation/Presenter/view/#/PointingToDeclaration/"></a>[view](view.md)| <a name="com.chrynan.presentation/Presenter/view/#/PointingToDeclaration/"></a> [common] abstract val [view](view.md): [View](../-view/index.md)<[I](index.md), [S](index.md)>The [View](../-view/index.md) that this [Presenter](index.md) handles the presentation logic for.   <br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.presentation/BasePresenter///PointingToDeclaration/"></a>[BasePresenter](../-base-presenter/index.md)|

