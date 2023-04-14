//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[TimeTravelStateStore](index.md)/[pop](pop.md)

# pop

[common]\
abstract fun [pop](pop.md)(duration: [Duration](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.time/-duration/index.html))

Attempts to drop the [State](index.md)s on the state stack until the one that was present at the current time minus the provided [duration](pop.md). If there is no previous [State](index.md), this will have no effect. If the provided [duration](pop.md) is back past the time when the [initialState](../../../../cycle-core/com.chrynan.cycle/-time-travel-state-store/initial-state.md) was added, then all items will be dropped except the [initialState](../../../../cycle-core/com.chrynan.cycle/-time-travel-state-store/initial-state.md) and the [currentState](../current-state.md) value will equal the [initialState](../../../../cycle-core/com.chrynan.cycle/-time-travel-state-store/initial-state.md). If the provided [duration](pop.md) is a negative value, this will have no effect.
