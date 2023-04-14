//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[TimeTravelStateStore](index.md)/[replay](replay.md)

# replay

[common]\
abstract suspend fun [replay](replay.md)()

Re-emits the [State](index.md)s in the order that they were first displayed and at the time intervals that they were first displayed. Implementations may ignore mutations while the replay is occurring.
