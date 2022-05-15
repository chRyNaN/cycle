//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[BaseViewModel](index.md)

# BaseViewModel

[common]\
expect abstract class [BaseViewModel](index.md)

[android]\
actual abstract class [BaseViewModel](index.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

[ios, js, jvm]\
actual abstract class [BaseViewModel](index.md)

## Functions

| Name | Summary |
|---|---|
| [clear](index.md#-1936886459%2FFunctions%2F174188672) | [android]<br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)<br>fun [clear](index.md#-1936886459%2FFunctions%2F174188672)() |
| [getTag](index.md#-215894976%2FFunctions%2F174188672) | [android]<br>open fun &lt;[T](index.md#-215894976%2FFunctions%2F174188672) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [getTag](index.md#-215894976%2FFunctions%2F174188672)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](index.md#-215894976%2FFunctions%2F174188672) |
| [onCleared](index.md#-1930136507%2FFunctions%2F174188672) | [android]<br>open fun [onCleared](index.md#-1930136507%2FFunctions%2F174188672)() |
| [setTagIfAbsent](index.md#-1567230750%2FFunctions%2F174188672) | [android]<br>open fun &lt;[T](index.md#-1567230750%2FFunctions%2F174188672) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [setTagIfAbsent](index.md#-1567230750%2FFunctions%2F174188672)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: [T](index.md#-1567230750%2FFunctions%2F174188672)): [T](index.md#-1567230750%2FFunctions%2F174188672) |

## Inheritors

| Name |
|---|
| [ViewModel](../-view-model/index.md) |
