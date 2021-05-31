//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose](index.md)/[layout](layout.md)



# layout  
[common]  
Content  
@Composable()  
  
fun <[I](layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)> [layout](layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, presenterFactory: [PresenterFactory](../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter-factory/index.md)<[I](layout.md), [S](layout.md), [C](layout.md)>, onLayout: @Composable()([S](layout.md)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Layout](-layout/index.md)<[I](layout.md), [S](layout.md), [C](layout.md)>  
@Composable()  
  
fun <[I](layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)> [layout](layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, onCreatePresenter: (view: [View](../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)<[I](layout.md), [S](layout.md)>) -> [Presenter](../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter/index.md)<[I](layout.md), [S](layout.md), [C](layout.md)>, onLayout: @Composable()([S](layout.md)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Layout](-layout/index.md)<[I](layout.md), [S](layout.md), [C](layout.md)>  



