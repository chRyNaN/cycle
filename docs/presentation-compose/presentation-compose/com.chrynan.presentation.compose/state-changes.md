//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose](index.md)/[stateChanges](state-changes.md)

# stateChanges

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[I](state-changes.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](state-changes.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md)&gt; [ComposeLayoutScope](-compose-layout-scope/index.md)&lt;[I](state-changes.md), [S](state-changes.md)&gt;.[stateChanges](state-changes.md)(): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[S](state-changes.md)?&gt;

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[I](state-changes.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](state-changes.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](state-changes.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [View](../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)&lt;[I](state-changes.md), [S](state-changes.md), [C](state-changes.md)&gt;.[stateChanges](state-changes.md)(context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[S](state-changes.md)?&gt;

Obtains the changes to the underlying [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md) as a Jetpack Compose [androidx.compose.runtime.State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html) value, so that the changes can cause the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function to be re-composed.

Example usage:

```kotlin
@Composable
override fun Content() {
    val state by stateChanges()

    // Create the UI using the 'state' variable
}
```

[common]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[I](state-changes.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](state-changes.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](state-changes.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [View](../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)&lt;[I](state-changes.md), [S](state-changes.md), [C](state-changes.md)&gt;.[stateChanges](state-changes.md)(initial: [S](state-changes.md)?, context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[S](state-changes.md)?&gt;

Obtains the changes to the underlying [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), starting with the provided [initial](state-changes.md) value, as a Jetpack Compose [androidx.compose.runtime.State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html) value, so that the changes can cause the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function to be re-composed.

Example usage:

```kotlin
@Composable
override fun Content() {
    val state by stateChanges(initial = null)

    // Create the UI using the 'state' variable
}
```
