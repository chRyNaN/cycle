//[cycle-core](../../index.md)/[com.chrynan.cycle](index.md)/[StateStore](-state-store.md)

# StateStore

[common]\
fun &lt;[State](-state-store.md), [Change](-state-store.md)&gt; [StateStore](-state-store.md)(initialState: [State](-state-store.md)? = null, stateFlow: StateFlow&lt;[State](-state-store.md)?&gt;): [StateStore](-state-store/index.md)&lt;[State](-state-store.md), [Change](-state-store.md)&gt;

Creates a non-mutable instance of the [StateStore](-state-store/index.md) interface using the provided [initialState](-state-store.md) and [stateFlow](-state-store.md).
