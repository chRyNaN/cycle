//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose](index.md)



# Package com.chrynan.presentation.compose  


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation.compose/AndroidComposeNavigationScope///PointingToDeclaration/"></a>[AndroidComposeNavigationScope](-android-compose-navigation-scope/index.md)| <a name="com.chrynan.presentation.compose/AndroidComposeNavigationScope///PointingToDeclaration/"></a>[android]  <br>Content  <br>interface [AndroidComposeNavigationScope](-android-compose-navigation-scope/index.md) : [NavigationScope](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-scope/index.md)  <br><br><br>|
| <a name="com.chrynan.presentation.compose/AndroidComposeNavigator///PointingToDeclaration/"></a>[AndroidComposeNavigator](-android-compose-navigator/index.md)| <a name="com.chrynan.presentation.compose/AndroidComposeNavigator///PointingToDeclaration/"></a>[android]  <br>Content  <br>class [AndroidComposeNavigator](-android-compose-navigator/index.md)<[I](-android-compose-navigator/index.md) : [NavigationIntent](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-intent/index.md)> : [Navigator](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigator/index.md)<[I](-android-compose-navigator/index.md), [AndroidComposeNavigationScope](-android-compose-navigation-scope/index.md)>   <br><br><br>|
| <a name="com.chrynan.presentation.compose/Layout///PointingToDeclaration/"></a>[Layout](-layout/index.md)| <a name="com.chrynan.presentation.compose/Layout///PointingToDeclaration/"></a>[common]  <br>Content  <br>@Stable()  <br>  <br>abstract class [Layout](-layout/index.md)<[I](-layout/index.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](-layout/index.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](-layout/index.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)> : [View](../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)<[I](-layout/index.md), [S](-layout/index.md)> , [Bindable](../../../presentation-core/presentation-core/com.chrynan.presentation/-bindable/index.md)  <br>More info  <br>A component that implements the [View](../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md) interface and serves as the binding between this presentation library and Jetpack Compose.  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation.compose//includeLayout/#com.chrynan.presentation.compose.Layout[TypeParam(bounds=[com.chrynan.presentation.Intent]),TypeParam(bounds=[com.chrynan.presentation.State]),TypeParam(bounds=[com.chrynan.presentation.Change])]/PointingToDeclaration/"></a>[includeLayout](include-layout.md)| <a name="com.chrynan.presentation.compose//includeLayout/#com.chrynan.presentation.compose.Layout[TypeParam(bounds=[com.chrynan.presentation.Intent]),TypeParam(bounds=[com.chrynan.presentation.State]),TypeParam(bounds=[com.chrynan.presentation.Change])]/PointingToDeclaration/"></a>[common]  <br>Content  <br>@Composable()  <br>  <br>inline fun <[I](include-layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](include-layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](include-layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)> [includeLayout](include-layout.md)(layout: [Layout](-layout/index.md)<[I](include-layout.md), [S](include-layout.md), [C](include-layout.md)>)  <br><br><br>|
| <a name="com.chrynan.presentation.compose//layout/#kotlin.Any?#com.chrynan.presentation.PresenterFactory[TypeParam(bounds=[com.chrynan.presentation.Intent]),TypeParam(bounds=[com.chrynan.presentation.State]),TypeParam(bounds=[com.chrynan.presentation.Change])]#kotlin.Function1[TypeParam(bounds=[com.chrynan.presentation.State]),kotlin.Unit]/PointingToDeclaration/"></a>[layout](layout.md)| <a name="com.chrynan.presentation.compose//layout/#kotlin.Any?#com.chrynan.presentation.PresenterFactory[TypeParam(bounds=[com.chrynan.presentation.Intent]),TypeParam(bounds=[com.chrynan.presentation.State]),TypeParam(bounds=[com.chrynan.presentation.Change])]#kotlin.Function1[TypeParam(bounds=[com.chrynan.presentation.State]),kotlin.Unit]/PointingToDeclaration/"></a>[common]  <br>Content  <br>@Composable()  <br>  <br>fun <[I](layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)> [layout](layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, presenterFactory: [PresenterFactory](../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter-factory/index.md)<[I](layout.md), [S](layout.md), [C](layout.md)>, onLayout: @Composable()([S](layout.md)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Layout](-layout/index.md)<[I](layout.md), [S](layout.md), [C](layout.md)>  <br>@Composable()  <br>  <br>fun <[I](layout.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](layout.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](layout.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)> [layout](layout.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null, onCreatePresenter: (view: [View](../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)<[I](layout.md), [S](layout.md)>) -> [Presenter](../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter/index.md)<[I](layout.md), [S](layout.md), [C](layout.md)>, onLayout: @Composable()([S](layout.md)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Layout](-layout/index.md)<[I](layout.md), [S](layout.md), [C](layout.md)>  <br><br><br>|
| <a name="com.chrynan.presentation.compose//navigator/#android.app.Activity?#androidx.navigation.NavController?#com.chrynan.presentation.NavigationHandler[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent]),com.chrynan.presentation.compose.AndroidComposeNavigationScope]/PointingToDeclaration/"></a>[navigator](navigator.md)| <a name="com.chrynan.presentation.compose//navigator/#android.app.Activity?#androidx.navigation.NavController?#com.chrynan.presentation.NavigationHandler[TypeParam(bounds=[com.chrynan.presentation.NavigationIntent]),com.chrynan.presentation.compose.AndroidComposeNavigationScope]/PointingToDeclaration/"></a>[android]  <br>Content  <br>@Composable()  <br>  <br>fun <[I](navigator.md) : [NavigationIntent](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-intent/index.md)> [navigator](navigator.md)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html)? = null, navController: [NavController](https://developer.android.com/reference/kotlin/androidx/navigation/NavController.html)? = null, handler: [NavigationHandler](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-handler/index.md)<[I](navigator.md), [AndroidComposeNavigationScope](-android-compose-navigation-scope/index.md)>): [Navigator](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigator/index.md)<[I](navigator.md), [AndroidComposeNavigationScope](-android-compose-navigation-scope/index.md)>  <br>@Composable()  <br>  <br>fun <[I](navigator.md) : [NavigationIntent](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-intent/index.md)> [navigator](navigator.md)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html)? = null, navController: [NavController](https://developer.android.com/reference/kotlin/androidx/navigation/NavController.html)? = null, handler: [AndroidComposeNavigationScope](-android-compose-navigation-scope/index.md).(event: [NavigationEvent](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-event/index.md)<[I](navigator.md)>) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Navigator](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigator/index.md)<[I](navigator.md), [AndroidComposeNavigationScope](-android-compose-navigation-scope/index.md)>  <br><br><br>|
