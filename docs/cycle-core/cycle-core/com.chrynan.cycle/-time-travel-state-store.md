//[cycle-core](../../index.md)/[com.chrynan.cycle](index.md)/[TimeTravelStateStore](-time-travel-state-store.md)

# TimeTravelStateStore

[common]\

@[ExperimentalTime](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.time/-experimental-time/index.html)

fun &lt;[State](-time-travel-state-store.md), [Change](-time-travel-state-store.md)&gt; [TimeTravelStateStore](-time-travel-state-store.md)(initialState: [State](-time-travel-state-store.md)? = null, reducer: [Reducer](index.md#-209270086%2FClasslikes%2F1627176608)&lt;[State](-time-travel-state-store.md), [Change](-time-travel-state-store.md)&gt;): [TimeTravelStateStore](-time-travel-state-store/index.md)&lt;[State](-time-travel-state-store.md), [Change](-time-travel-state-store.md)&gt;

Creates an instance of the [MutableStackStateStore](-mutable-stack-state-store/index.md) interface using the provided [initialState](-time-travel-state-store.md) and [reducer](-time-travel-state-store.md).
