//[presentation-core](../../index.md)/[com.chrynan.presentation](index.md)/[create](create.md)

# create

[common]\
suspend fun &lt;[I](create.md) : [Intent](-intent/index.md), [S](create.md) : [State](-state/index.md), [C](create.md) : [Change](-change/index.md)&gt; [Action](-action/index.md)&lt;[I](create.md), [S](create.md), [C](create.md)&gt;.[create](create.md)(intent: [I](create.md), state: [S](create.md)?): Flow&lt;[C](create.md)&gt;

A convenience function that delegates to [Action.perform](-action/perform.md) allowing the [Action](-action/index.md) to be invoked like a function.

[common]\
suspend fun &lt;[S](create.md) : [State](-state/index.md), [C](create.md) : [Change](-change/index.md)&gt; [Reducer](-reducer/index.md)&lt;[S](create.md), [C](create.md)&gt;.[create](create.md)(previous: [S](create.md)?, change: [C](create.md)): [S](create.md)?

A convenience operator function that delegates to the [reduce](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html) function, so that the [Reducer](-reducer/index.md) class can be invoked like a function.

[common]\
inline fun &lt;[I](create.md) : [Intent](-intent/index.md), [S](create.md) : [State](-state/index.md), [C](create.md) : [Change](-change/index.md), [V](create.md) : [ViewModel](-view-model/index.md)&lt;[I](create.md), [S](create.md), [C](create.md)&gt;&gt; [ViewModelFactory](-view-model-factory/index.md).[create](create.md)(vararg extras: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [V](create.md)
