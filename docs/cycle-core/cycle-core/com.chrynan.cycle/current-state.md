//[cycle-core](../../index.md)/[com.chrynan.cycle](index.md)/[currentState](current-state.md)

# currentState

[common]\
val &lt;[State](current-state.md), [Change](current-state.md)&gt; [StateStore](-state-store/index.md)&lt;[State](current-state.md), [Change](current-state.md)&gt;.[currentState](current-state.md): [State](current-state.md)?

Retrieves the current [State](current-state.md) value for this [StateStore](-state-store/index.md). This is equivalent to call StateFlow.value on the [StateStore.states](-state-store/states.md) property, and is provided for convenience.
