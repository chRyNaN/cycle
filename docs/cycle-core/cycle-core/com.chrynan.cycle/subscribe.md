//[cycle-core](../../index.md)/[com.chrynan.cycle](index.md)/[subscribe](subscribe.md)

# subscribe

[common]\
fun &lt;[State](subscribe.md), [Change](subscribe.md)&gt; [StateStore](-state-store/index.md)&lt;[State](subscribe.md), [Change](subscribe.md)&gt;.[subscribe](subscribe.md)(coroutineScope: CoroutineScope, dispatchers: CoroutineDispatchers = com.chrynan.dispatchers.dispatchers, onError: suspend () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, onState: suspend ([State](subscribe.md)?) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

A convenience function that subscribes to [State](subscribe.md) changes on the [StateStore.states](-state-store/states.md) property using the provided values. The [onError](subscribe.md) function is invoked when an exception was encountered, and the [onState](subscribe.md) function is invoked when a new [State](subscribe.md) is emitted on the StateStore.states.
