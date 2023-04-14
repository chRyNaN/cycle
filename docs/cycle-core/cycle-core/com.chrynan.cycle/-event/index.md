//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[Event](index.md)

# Event

[common]\
class [Event](index.md)&lt;[T](index.md)&gt;(val value: [T](index.md), val elapsedSystemTime: [Duration](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.time/-duration/index.html) = currentElapsedSystemTime)

This class represents the event of a value of type [T](index.md) being emitted on a stream. It contains additional event related properties, such as the [elapsedSystemTime](elapsed-system-time.md) when this event was created.

## Constructors

| | |
|---|---|
| [Event](-event.md) | [common]<br>constructor(value: [T](index.md), elapsedSystemTime: [Duration](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.time/-duration/index.html) = currentElapsedSystemTime) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [component1](component1.md) | [common]<br>operator fun [component1](component1.md)(): [T](index.md) |
| [component2](component2.md) | [common]<br>operator fun [component2](component2.md)(): [Duration](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.time/-duration/index.html) |
| [copy](copy.md) | [common]<br>fun [copy](copy.md)(value: [T](index.md) = this.value, elapsedSystemTime: [Duration](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.time/-duration/index.html) = this.elapsedSystemTime): [Event](index.md)&lt;[T](index.md)&gt;<br>Creates a copy of this [Event](index.md) class while optionally overriding the values. |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [elapsedSystemTime](elapsed-system-time.md) | [common]<br>val [elapsedSystemTime](elapsed-system-time.md): [Duration](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.time/-duration/index.html)<br>The elapsed system time when the event was created. |
| [value](value.md) | [common]<br>val [value](value.md): [T](index.md)<br>The value that was emitted. |
