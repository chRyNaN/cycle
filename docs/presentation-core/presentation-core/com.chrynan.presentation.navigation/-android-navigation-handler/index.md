//[presentation-core](../../../index.md)/[com.chrynan.presentation.navigation](../index.md)/[AndroidNavigationHandler](index.md)

# AndroidNavigationHandler

[android]\
fun interface [AndroidNavigationHandler](index.md)&lt;[I](index.md) : [NavigationIntent](../../../../presentation-core/presentation-core/com.chrynan.presentation.navigation/-navigation-intent/index.md)&gt; : [NavigationHandler](../../../../presentation-core/presentation-core/com.chrynan.presentation.navigation/-navigation-handler/index.md)&lt;[I](index.md), [AndroidNavigationScope](../-android-navigation-scope/index.md)&gt; 

A [NavigationHandler](../../../../presentation-core/presentation-core/com.chrynan.presentation.navigation/-navigation-handler/index.md) used on the Android platform that uses an [AndroidNavigationScope](../-android-navigation-scope/index.md).

## Functions

| Name | Summary |
|---|---|
| [onNavigate](index.md#257056606%2FFunctions%2F174188672) | [android]<br>abstract fun [AndroidNavigationScope](../-android-navigation-scope/index.md).[onNavigate](index.md#257056606%2FFunctions%2F174188672)(event: [NavigationEvent](../../../../presentation-core/presentation-core/com.chrynan.presentation.navigation/-navigation-event/index.md)&lt;[I](index.md)&gt;)<br>Handles the actual navigation to a different part of the app defined by the provided [event](index.md#257056606%2FFunctions%2F174188672) using the [S](../../../../presentation-core/com.chrynan.presentation.navigation/-navigation-handler/index.md) scope. |
