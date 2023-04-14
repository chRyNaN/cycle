//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[ViewModel](index.md)/[subscribe](subscribe.md)

# subscribe

[common]\

@ExperimentalCoroutinesApi

@FlowPreview

fun [subscribe](subscribe.md)(onError: suspend () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, onState: suspend ([State](index.md)?) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

A convenience function that subscribes to [State](index.md) changes on the [ViewModel.states](states.md) property using the provided values. The [onError](subscribe.md) function is invoked when an exception was encountered, and the [onState](subscribe.md) function is invoked when a new [State](index.md) is emitted on the ViewModel.states.

**Note:** This function subscribes to the [ViewModel](index.md) state changes dependent on the lifecycle of the [ViewModel](index.md). Make sure the [ViewModel.isBound](is-bound.md) before calling this function.
