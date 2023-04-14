//[cycle-compose](../../index.md)/[com.chrynan.cycle.compose](index.md)/[stateChanges](state-changes.md)

# stateChanges

[common]\

@ExperimentalCoroutinesApi

@FlowPreview

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[State](state-changes.md), [Change](state-changes.md)&gt; [ViewModel](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md)&lt;[State](state-changes.md), [Change](state-changes.md)&gt;.[stateChanges](state-changes.md)(context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[State](state-changes.md)?&gt;

Obtains the changes to the underlying [State](state-changes.md) as a Jetpack Compose [androidx.compose.runtime.State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html) value, so that the changes can cause the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function to be re-composed.

**Note:** That this function will bind this [ViewModel](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md) to the invoking composable function's lifecycle via the [rememberAndBind](remember-and-bind.md) function. Therefore, this function should only be invoked from within the composable function that created the [ViewModel](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md).

Example usage:

```kotlin
@Composable
fun Content(viewModel: MyViewModel) {
    val state by viewModel.stateChanges()

    // Create the UI using the 'state' variable
}
```

[common]\

@ExperimentalCoroutinesApi

@FlowPreview

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[State](state-changes.md), [Change](state-changes.md)&gt; [ViewModel](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md)&lt;[State](state-changes.md), [Change](state-changes.md)&gt;.[stateChanges](state-changes.md)(initial: [State](state-changes.md)?, context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[State](state-changes.md)?&gt;

Obtains the changes to the underlying [State](state-changes.md), starting with the provided [initial](state-changes.md) value, as a Jetpack Compose [androidx.compose.runtime.State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html) value, so that the changes can cause the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function to be re-composed.

**Note:** That this function will bind this [ViewModel](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md) to the invoking composable function's lifecycle via the [rememberAndBind](remember-and-bind.md) function. Therefore, this function should only be invoked from within the composable function that it was created.

Example usage:

```kotlin
@Composable
fun Content(viewModel: MyViewModel) {
    val state by viewModel.stateChanges(initial = null)

    // Create the UI using the 'state' variable
}
```

[common]\

@ExperimentalCoroutinesApi

@FlowPreview

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[State](state-changes.md), [Change](state-changes.md)&gt; [View](../../../cycle-core/cycle-core/com.chrynan.cycle/-view/index.md)&lt;[State](state-changes.md), [Change](state-changes.md)&gt;.[stateChanges](state-changes.md)(context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[State](state-changes.md)?&gt;

Obtains the changes to the underlying [State](state-changes.md) as a Jetpack Compose [androidx.compose.runtime.State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html) value, so that the changes can cause the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function to be re-composed.

Example usage:

```kotlin
@Composable
override fun Content() {
    val state by stateChanges()

    // Create the UI using the 'state' variable
}
```

[common]\

@ExperimentalCoroutinesApi

@FlowPreview

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[State](state-changes.md), [Change](state-changes.md)&gt; [View](../../../cycle-core/cycle-core/com.chrynan.cycle/-view/index.md)&lt;[State](state-changes.md), [Change](state-changes.md)&gt;.[stateChanges](state-changes.md)(initial: [State](state-changes.md)?, context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)&lt;[State](state-changes.md)?&gt;

Obtains the changes to the underlying [State](state-changes.md), starting with the provided [initial](state-changes.md) value, as a Jetpack Compose [androidx.compose.runtime.State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html) value, so that the changes can cause the [Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html) function to be re-composed.

Example usage:

```kotlin
@Composable
override fun Content() {
    val state by stateChanges(initial = null)

    // Create the UI using the 'state' variable
}
```
