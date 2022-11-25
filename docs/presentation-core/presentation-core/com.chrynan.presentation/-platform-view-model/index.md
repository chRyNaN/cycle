//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[PlatformViewModel](index.md)

# PlatformViewModel

[common]\
expect abstract class [PlatformViewModel](index.md)

The base class that a [ViewModel](../-view-model/index.md) inherits from. This allows each supported platform to have a platform-specific base ViewModel component implementation. For instance, on Android this class can extend from the `androidx.lifecycle.ViewModel` component so that it can be used with the Android lifecycle.

[android]\
actual abstract class [PlatformViewModel](index.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

[ios, js, jvm]\
actual abstract class [PlatformViewModel](index.md)

## Functions

| Name | Summary |
|---|---|
| [addCloseable](index.md#264516373%2FFunctions%2F174188672) | [android]<br>open fun [addCloseable](index.md#264516373%2FFunctions%2F174188672)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |

## Inheritors

| Name |
|---|
| [ViewModel](../-view-model/index.md) |
