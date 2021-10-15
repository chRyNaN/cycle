//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Action](index.md)/[perform](perform.md)

# perform

[common]\
abstract fun [perform](perform.md)(intent: [I](index.md), state: [S](index.md)?): Flow&lt;[C](index.md)&gt;

Converts the provided [intent](perform.md) of type [I](index.md) into a Flow of type [C](index.md). This means an [Intent](../-intent/index.md) can cause multiple [Change](../-change/index.md)s to be emitted ("StartedLoading", "FinishedLoading", etc).

## Parameters

common

| | |
|---|---|
| intent | The intent to perform an [Action](index.md). |
| state | The current state being displayed. |
