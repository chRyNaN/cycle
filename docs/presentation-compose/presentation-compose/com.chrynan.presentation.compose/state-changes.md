//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose](index.md)/[stateChanges](state-changes.md)

# stateChanges

[common]\

@Composable

fun &lt;[I](state-changes.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](state-changes.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](state-changes.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [View](../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)&lt;[I](state-changes.md), [S](state-changes.md), [C](state-changes.md)&gt;.[stateChanges](state-changes.md)(context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): State&lt;[S](state-changes.md)?&gt;

Obtains the changes to the underlying [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md) as a Jetpack Compose androidx.compose.runtime.State value, so that the changes can cause the Composable function to be re-composed.

Example usage:

@Composable\
override fun Content() {\
    val state by stateChanges()\
\
    // Create the UI using the 'state' variable\
}

[common]\

@Composable

fun &lt;[I](state-changes.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](state-changes.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](state-changes.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [View](../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md)&lt;[I](state-changes.md), [S](state-changes.md), [C](state-changes.md)&gt;.[stateChanges](state-changes.md)(initial: [S](state-changes.md)?, context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) = EmptyCoroutineContext): State&lt;[S](state-changes.md)?&gt;

Obtains the changes to the underlying [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), starting with the provided [initial](state-changes.md) value, as a Jetpack Compose androidx.compose.runtime.State value, so that the changes can cause the Composable function to be re-composed.

Example usage:

@Composable\
override fun Content() {\
    val state by stateChanges(initial = null)\
\
    // Create the UI using the 'state' variable\
}
