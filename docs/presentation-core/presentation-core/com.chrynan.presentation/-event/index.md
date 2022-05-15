//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Event](index.md)

# Event

[common]\
data class [Event](index.md)&lt;[T](index.md)&gt;(value: [T](index.md), elapsedSystemTime: [Duration](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.time/-duration/index.html))

An event wrapper class around an [Intent](../-intent/index.md) of type [T](index.md). This class represents the event of an [Intent](../-intent/index.md) being emitted. It contains additional event related properties, such as the [elapsedSystemTime](elapsed-system-time.md) when this event was created.

## Constructors

| | |
|---|---|
| [Event](-event.md) | [common]<br>fun &lt;[T](index.md)&gt; [Event](-event.md)(value: [T](index.md), elapsedSystemTime: [Duration](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.time/-duration/index.html) = currentElapsedSystemTime) |

## Properties

| Name | Summary |
|---|---|
| [elapsedSystemTime](elapsed-system-time.md) | [common]<br>val [elapsedSystemTime](elapsed-system-time.md): [Duration](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.time/-duration/index.html) |
| [value](value.md) | [common]<br>val [value](value.md): [T](index.md) |
