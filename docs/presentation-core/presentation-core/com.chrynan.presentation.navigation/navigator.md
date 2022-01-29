//[presentation-core](../../index.md)/[com.chrynan.presentation.navigation](index.md)/[navigator](navigator.md)

# navigator

[android]\
fun &lt;[I](navigator.md) : NavigationIntent&gt; [navigator](navigator.md)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html), handler: [AndroidNavigationHandler](-android-navigation-handler/index.md)&lt;[I](navigator.md)&gt;): Navigator&lt;[I](navigator.md)&gt;

Creates a Navigator using the provided [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html) in the [AndroidNavigationScope](-android-navigation-scope/index.md) and the provided [handler](navigator.md).

Example usage:

val navigator = navigator(activity, AndroidNavigationHandler { event -&gt;\
    when (event) {\
        is NavigationEvent.Back -&gt; activity.onBackPressed()\
        is NavigationEvent.Up -&gt; activity.onBackPressed()\
        is NavigationEvent.To -&gt; { ... }\
    }\
})\
\
navigator.goBack()

[android]\
fun &lt;[I](navigator.md) : NavigationIntent&gt; [navigator](navigator.md)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html), onGoBack: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { activity.onBackPressed() }, onGoUp: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { activity.onBackPressed() }, onGoTo: ([I](navigator.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): Navigator&lt;[I](navigator.md)&gt;

Creates a Navigator using the provided [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html) in the [AndroidNavigationScope](-android-navigation-scope/index.md) and the provided [onGoBack](navigator.md), [onGoUp](navigator.md), and [onGoTo](navigator.md) functions to construct an [AndroidNavigationHandler](-android-navigation-handler/index.md).

Example usage:

val navigator = navigator&lt;NavigationIntent&gt;(activity = activity, onGoTo = { navigationIntent -&gt;\
    activity.startActivity(...)\
})\
\
navigator.goBack()
