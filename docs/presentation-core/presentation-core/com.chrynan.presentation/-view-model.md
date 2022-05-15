//[presentation-core](../../index.md)/[com.chrynan.presentation](index.md)/[ViewModel](-view-model.md)

# ViewModel

[common]\
fun &lt;[I](-view-model.md) : [Intent](-intent/index.md), [S](-view-model.md) : [State](-state/index.md), [C](-view-model.md) : [Change](-change/index.md)&gt; [ViewModel](-view-model.md)(initialState: [S](-view-model.md)? = null, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, onUnbind: [DelegatingViewModel](-delegating-view-model/index.md)&lt;[I](-view-model.md), [S](-view-model.md), [C](-view-model.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null, onBind: [DelegatingViewModel](-delegating-view-model/index.md)&lt;[I](-view-model.md), [S](-view-model.md), [C](-view-model.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [DelegatingViewModel](-delegating-view-model/index.md)&lt;[I](-view-model.md), [S](-view-model.md), [C](-view-model.md)&gt;

A convenience function to create a [ViewModel](-view-model/index.md) without having to directly create an implementation. This could be especially useful for simple applications that don't have complex dependency management and testing requirements.

Example usage:

ViewModel&lt;I, S, C&gt; {\
    this.intents\
        .perform { intent, state -&gt; ... }\
        .reduce { state, change -&gt; ... }\
        .startWithInitialState()\
        .render()\
        .launchIn(coroutineScope)\
}

[common]\
fun &lt;[I](-view-model.md) : [Intent](-intent/index.md), [S](-view-model.md) : [State](-state/index.md), [C](-view-model.md) : [Change](-change/index.md)&gt; [ViewModel](-view-model.md)(initialState: [S](-view-model.md)? = null, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, onUnbind: [DelegatingViewModel](-delegating-view-model/index.md)&lt;[I](-view-model.md), [S](-view-model.md), [C](-view-model.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null, onBind: [DelegatingViewModel](-delegating-view-model/index.md)&lt;[I](-view-model.md), [S](-view-model.md), [C](-view-model.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null, onError: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null, startWithInitialState: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, flatMapStrategy: [FlatMapStrategy](-flat-map-strategy/index.md) = FlatMapStrategy.Latest, perform: suspend ([I](-view-model.md), [S](-view-model.md)?) -&gt; Flow&lt;[C](-view-model.md)&gt;, reduce: suspend ([S](-view-model.md)?, [C](-view-model.md)) -&gt; [S](-view-model.md)): [DelegatingViewModel](-delegating-view-model/index.md)&lt;[I](-view-model.md), [S](-view-model.md), [C](-view-model.md)&gt;

A convenience function to create a [ViewModel](-view-model/index.md) without having to directly create an implementation. This could be especially useful for simple applications that don't have complex dependency management and testing requirements.

Example usage:

ViewModel&lt;I, S, C&gt;(\
    perform = { intent, state -&gt; ... },\
    reduce = { state, change -&gt; ... })
