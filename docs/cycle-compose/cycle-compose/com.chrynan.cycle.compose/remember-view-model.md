//[cycle-compose](../../index.md)/[com.chrynan.cycle.compose](index.md)/[rememberViewModel](remember-view-model.md)

# rememberViewModel

[common]\

@[ExperimentalPresentationApi](../../../cycle-core/cycle-core/com.chrynan.cycle/-experimental-presentation-api/index.md)

@ExperimentalCoroutinesApi

@FlowPreview

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

inline fun &lt;[State](remember-view-model.md), [Change](remember-view-model.md), [V](remember-view-model.md) : [ViewModel](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md)&lt;[State](remember-view-model.md), [Change](remember-view-model.md)&gt;&gt; [rememberViewModel](remember-view-model.md)(key: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null): [V](remember-view-model.md)

Obtains and remembers the required [ViewModel](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md) from the [LocalViewModelProvider](-local-view-model-provider.md) or throws an exception if the [ViewModel](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md) could not be found.

##  Example usage:

```kotlin
@Composable
fun Home(viewModel: HomeViewModel = rememberViewModel()) { ... }
```
