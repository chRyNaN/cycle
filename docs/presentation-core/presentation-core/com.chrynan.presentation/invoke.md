//[presentation-core](../../index.md)/[com.chrynan.presentation](index.md)/[invoke](invoke.md)

# invoke

[common]\
operator fun &lt;[I](invoke.md) : [Intent](-intent/index.md), [S](invoke.md) : [State](-state/index.md), [C](invoke.md) : [Change](-change/index.md)&gt; [Action](-action/index.md)&lt;[I](invoke.md), [S](invoke.md), [C](invoke.md)&gt;.[invoke](invoke.md)(intent: [I](invoke.md), state: [S](invoke.md)?): Flow&lt;[C](invoke.md)&gt;

A convenience function that delegates to [Action.perform](-action/perform.md) allowing the [Action](-action/index.md) to be invoked like a function.

[common]\
suspend operator fun &lt;[S](invoke.md) : [State](-state/index.md), [C](invoke.md) : [Change](-change/index.md)&gt; [Reducer](-reducer/index.md)&lt;[S](invoke.md), [C](invoke.md)&gt;.[invoke](invoke.md)(previous: [S](invoke.md)?, change: [C](invoke.md)): [S](invoke.md)

A convenience operator function that delegates to the [reduce](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html) function, so that the [Reducer](-reducer/index.md) class can be invoked like a function.
