//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose](index.md)/[navigator](navigator.md)



# navigator  
[android]  
Content  
@Composable()  
  
fun <[I](navigator.md) : [NavigationIntent](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-intent/index.md)> [navigator](navigator.md)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html)? = null, navController: [NavController](https://developer.android.com/reference/kotlin/androidx/navigation/NavController.html)? = null, handler: [NavigationHandler](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-handler/index.md)<[I](navigator.md), [AndroidComposeNavigationScope](-android-compose-navigation-scope/index.md)>): [Navigator](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigator/index.md)<[I](navigator.md), [AndroidComposeNavigationScope](-android-compose-navigation-scope/index.md)>  
@Composable()  
  
fun <[I](navigator.md) : [NavigationIntent](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-intent/index.md)> [navigator](navigator.md)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html)? = null, navController: [NavController](https://developer.android.com/reference/kotlin/androidx/navigation/NavController.html)? = null, handler: [AndroidComposeNavigationScope](-android-compose-navigation-scope/index.md).(event: [NavigationEvent](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-event/index.md)<[I](navigator.md)>) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Navigator](../../../presentation-core/presentation-core/com.chrynan.presentation/-navigator/index.md)<[I](navigator.md), [AndroidComposeNavigationScope](-android-compose-navigation-scope/index.md)>  



