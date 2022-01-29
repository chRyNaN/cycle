//[presentation-core](../../index.md)/[com.chrynan.presentation](index.md)/[Presenter](-presenter.md)

# Presenter

[common]\
fun &lt;[I](-presenter.md) : [Intent](-intent/index.md), [S](-presenter.md) : [State](-state/index.md), [C](-presenter.md) : [Change](-change/index.md)&gt; [Presenter](-presenter.md)(intents: Flow&lt;[I](-presenter.md)&gt;, initialState: [S](-presenter.md)? = null, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, onUnbind: [DelegatingPresenter](-delegating-presenter/index.md)&lt;[I](-presenter.md), [S](-presenter.md), [C](-presenter.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null, onBind: [DelegatingPresenter](-delegating-presenter/index.md)&lt;[I](-presenter.md), [S](-presenter.md), [C](-presenter.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [DelegatingPresenter](-delegating-presenter/index.md)&lt;[I](-presenter.md), [S](-presenter.md), [C](-presenter.md)&gt;

A convenience function to create a [Presenter](-presenter/index.md) without having to directly create an implementation. This could be especially useful for simple applications that don't have complex dependency management and testing requirements.

Example usage:

Presenter&lt;I, S, C&gt;(intents = intents) {\
    this.intents\
        .perform { intent, state -&gt; ... }\
        .reduce { state, change -&gt; ... }\
        .startWithInitialState()\
        .render()\
        .launchIn(coroutineScope)\
}

[common]\
fun &lt;[I](-presenter.md) : [Intent](-intent/index.md), [S](-presenter.md) : [State](-state/index.md), [C](-presenter.md) : [Change](-change/index.md)&gt; [View](-view/index.md)&lt;[I](-presenter.md), [S](-presenter.md)&gt;.[Presenter](-presenter.md)(initialState: [S](-presenter.md)? = null, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, onUnbind: [DelegatingPresenter](-delegating-presenter/index.md)&lt;[I](-presenter.md), [S](-presenter.md), [C](-presenter.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null, onBind: [DelegatingPresenter](-delegating-presenter/index.md)&lt;[I](-presenter.md), [S](-presenter.md), [C](-presenter.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [DelegatingPresenter](-delegating-presenter/index.md)&lt;[I](-presenter.md), [S](-presenter.md), [C](-presenter.md)&gt;

A convenience function to create a [Presenter](-presenter/index.md) without having to directly create an implementation. This could be especially useful for simple applications that don't have complex dependency management and testing requirements.

Example usage:

Presenter&lt;I, S, C&gt; {\
    this.intents\
        .perform { intent, state -&gt; ... }\
        .reduce { state, change -&gt; ... }\
        .startWithInitialState()\
        .render()\
        .launchIn(coroutineScope)\
}

[common]\
fun &lt;[I](-presenter.md) : [Intent](-intent/index.md), [S](-presenter.md) : [State](-state/index.md), [C](-presenter.md) : [Change](-change/index.md)&gt; [Presenter](-presenter.md)(intents: Flow&lt;[I](-presenter.md)&gt;, initialState: [S](-presenter.md)? = null, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, onUnbind: [DelegatingPresenter](-delegating-presenter/index.md)&lt;[I](-presenter.md), [S](-presenter.md), [C](-presenter.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null, onBind: [DelegatingPresenter](-delegating-presenter/index.md)&lt;[I](-presenter.md), [S](-presenter.md), [C](-presenter.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null, startWithInitialState: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, perform: suspend ([I](-presenter.md), [S](-presenter.md)?) -&gt; Flow&lt;[C](-presenter.md)&gt;, reduce: suspend ([S](-presenter.md)?, [C](-presenter.md)) -&gt; [S](-presenter.md)): [DelegatingPresenter](-delegating-presenter/index.md)&lt;[I](-presenter.md), [S](-presenter.md), [C](-presenter.md)&gt;

A convenience function to create a [Presenter](-presenter/index.md) without having to directly create an implementation. This could be especially useful for simple applications that don't have complex dependency management and testing requirements.

Example usage:

Presenter&lt;I, S, C&gt;(\
    intents = intents,\
    perform = { intent, state -&gt; ... },\
    reduce = { state, change -&gt; ... })

[common]\
fun &lt;[I](-presenter.md) : [Intent](-intent/index.md), [S](-presenter.md) : [State](-state/index.md), [C](-presenter.md) : [Change](-change/index.md)&gt; [View](-view/index.md)&lt;[I](-presenter.md), [S](-presenter.md)&gt;.[Presenter](-presenter.md)(initialState: [S](-presenter.md)? = null, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, onUnbind: [DelegatingPresenter](-delegating-presenter/index.md)&lt;[I](-presenter.md), [S](-presenter.md), [C](-presenter.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null, onBind: [DelegatingPresenter](-delegating-presenter/index.md)&lt;[I](-presenter.md), [S](-presenter.md), [C](-presenter.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null, startWithInitialState: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, perform: suspend ([I](-presenter.md), [S](-presenter.md)?) -&gt; Flow&lt;[C](-presenter.md)&gt;, reduce: suspend ([S](-presenter.md)?, [C](-presenter.md)) -&gt; [S](-presenter.md)): [DelegatingPresenter](-delegating-presenter/index.md)&lt;[I](-presenter.md), [S](-presenter.md), [C](-presenter.md)&gt;

A convenience function to create a [Presenter](-presenter/index.md) without having to directly create an implementation. This could be especially useful for simple applications that don't have complex dependency management and testing requirements.

Example usage:

Presenter&lt;I, S, C&gt;(\
    perform = { intent, state -&gt; ... },\
    reduce = { state, change -&gt; ... })
