//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[BasePresenter](index.md)



# BasePresenter  
 [common] abstract class [BasePresenter](index.md)<[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)>(**initialState**: [S](index.md)?, **dispatchers**: CoroutineDispatchers) : [Presenter](../-presenter/index.md)<[I](index.md), [S](index.md), [C](index.md)> 

A base implementation of the [Presenter](../-presenter/index.md) interface that provides functions for handling common functionality, such as, the [perform](../../../../presentation-core/com.chrynan.presentation/-base-presenter/perform.md), [reduce](../../../../presentation-core/com.chrynan.presentation/-base-presenter/reduce.md), and [render](../../../../presentation-core/com.chrynan.presentation/-base-presenter/render.md) functions.

   


## Constructors  
  
| | |
|---|---|
| <a name="com.chrynan.presentation/BasePresenter/BasePresenter/#TypeParam(bounds=[com.chrynan.presentation.State])?#com.chrynan.dispatchers.CoroutineDispatchers/PointingToDeclaration/"></a>[BasePresenter](-base-presenter.md)| <a name="com.chrynan.presentation/BasePresenter/BasePresenter/#TypeParam(bounds=[com.chrynan.presentation.State])?#com.chrynan.dispatchers.CoroutineDispatchers/PointingToDeclaration/"></a> [common] fun <[S](index.md) : [State](../-state/index.md)> [BasePresenter](-base-presenter.md)(initialState: [S](index.md)? = null, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers)   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/BasePresenter/bind/#/PointingToDeclaration/"></a>[bind](bind.md)| <a name="com.chrynan.presentation/BasePresenter/bind/#/PointingToDeclaration/"></a>[common]  <br>Content  <br>open override fun [bind](bind.md)()  <br>More info  <br>Binds and sets up this [Presenter](../-presenter/index.md) for the attached [View](../-view/index.md).  <br><br><br>|
| <a name="com.chrynan.presentation/BasePresenter/unbind/#/PointingToDeclaration/"></a>[unbind](unbind.md)| <a name="com.chrynan.presentation/BasePresenter/unbind/#/PointingToDeclaration/"></a>[common]  <br>Content  <br>open override fun [unbind](unbind.md)()  <br>More info  <br>Unbinds and cleans up the resources used by this [Presenter](../-presenter/index.md).  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/BasePresenter/coroutineScope/#/PointingToDeclaration/"></a>[coroutineScope](coroutine-scope.md)| <a name="com.chrynan.presentation/BasePresenter/coroutineScope/#/PointingToDeclaration/"></a> [common] open override val [coroutineScope](coroutine-scope.md): CoroutineScopeThe CoroutineScope available to this [Presenter](../-presenter/index.md).   <br>|
| <a name="com.chrynan.presentation/BasePresenter/currentState/#/PointingToDeclaration/"></a>[currentState](current-state.md)| <a name="com.chrynan.presentation/BasePresenter/currentState/#/PointingToDeclaration/"></a> [common] open override val [currentState](current-state.md): [S](index.md)?The current [State](../-state/index.md) of type [S](index.md) that is being displayed in the [View](../-view/index.md).   <br>|
| <a name="com.chrynan.presentation/BasePresenter/isBound/#/PointingToDeclaration/"></a>[isBound](is-bound.md)| <a name="com.chrynan.presentation/BasePresenter/isBound/#/PointingToDeclaration/"></a> [common] open override var [isBound](is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = falseDetermines if this [Presenter](../-presenter/index.md) is bound to the [View](../-view/index.md) or not.   <br>|
| <a name="com.chrynan.presentation/BasePresenter/view/#/PointingToDeclaration/"></a>[view](index.md#%5Bcom.chrynan.presentation%2FBasePresenter%2Fview%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F769169092)| <a name="com.chrynan.presentation/BasePresenter/view/#/PointingToDeclaration/"></a> [common] abstract val [view](index.md#%5Bcom.chrynan.presentation%2FBasePresenter%2Fview%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F769169092): [View](../-view/index.md)<[I](index.md), [S](index.md)>The [View](../-view/index.md) that this [Presenter](../-presenter/index.md) handles the presentation logic for.   <br>|

