//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[MutableStateStore](index.md)/[dispatch](dispatch.md)

# dispatch

[common]\
abstract suspend fun [dispatch](dispatch.md)(change: [Change](index.md))

Dispatches the provided [change](dispatch.md) to be reduced and the resulting new [State](index.md) value to be used as the current [State](index.md), updating associated values and emitting the value on the states.
