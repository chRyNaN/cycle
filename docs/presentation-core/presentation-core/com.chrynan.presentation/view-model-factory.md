//[presentation-core](../../index.md)/[com.chrynan.presentation](index.md)/[viewModelFactory](view-model-factory.md)

# viewModelFactory

[common]\
fun &lt;[I](view-model-factory.md) : [Intent](-intent/index.md), [S](view-model-factory.md) : [State](-state/index.md), [C](view-model-factory.md) : [Change](-change/index.md)&gt; [viewModelFactory](view-model-factory.md)(retainInstance: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, factory: [ViewModelFactory](-view-model-factory/index.md)&lt;[I](view-model-factory.md), [S](view-model-factory.md), [C](view-model-factory.md)&gt;): [ReadOnlyProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)&lt;[View](-view/index.md)&lt;[I](view-model-factory.md), [S](view-model-factory.md), [C](view-model-factory.md)&gt;, [ViewModel](-view-model/index.md)&lt;[I](view-model-factory.md), [S](view-model-factory.md), [C](view-model-factory.md)&gt;&gt;

fun &lt;[I](view-model-factory.md) : [Intent](-intent/index.md), [S](view-model-factory.md) : [State](-state/index.md), [C](view-model-factory.md) : [Change](-change/index.md)&gt; [viewModelFactory](view-model-factory.md)(retainInstance: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, factory: () -&gt; [ViewModel](-view-model/index.md)&lt;[I](view-model-factory.md), [S](view-model-factory.md), [C](view-model-factory.md)&gt;): [ReadOnlyProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)&lt;[View](-view/index.md)&lt;[I](view-model-factory.md), [S](view-model-factory.md), [C](view-model-factory.md)&gt;, [ViewModel](-view-model/index.md)&lt;[I](view-model-factory.md), [S](view-model-factory.md), [C](view-model-factory.md)&gt;&gt;

Creates a [ViewModelFactory](-view-model-factory/index.md) delegate.

Example usage:

val viewModel by viewModelFactory {\
    ViewModel {\
        this.view.intents()\
        .perform { intent, state -&gt; ... }\
        .reduce { state, change -&gt; ... }\
        .startWithInitialState()\
        .render()\
        .launchIn(coroutineScope)\
    }\
}
