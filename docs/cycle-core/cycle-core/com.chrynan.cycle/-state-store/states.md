//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[StateStore](index.md)/[states](states.md)

# states

[common]\
abstract val [states](states.md): StateFlow&lt;[State](index.md)?&gt;

Retrieves a StateFlow of this [StateStore](index.md)'s [State](index.md) changes. The items emitted on this StateFlow depend on mutable function calls to alter the state, such as the [MutableStateStore.dispatch](../-mutable-state-store/dispatch.md) function. The first value emitted will be the [initialState](initial-state.md) value.
