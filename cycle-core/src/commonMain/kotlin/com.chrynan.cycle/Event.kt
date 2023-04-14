package com.chrynan.cycle

import kotlin.time.Duration
import kotlin.time.ExperimentalTime

/**
 * This class represents the event of a value of type [T] being emitted on a stream. It contains additional event
 * related properties, such as the [elapsedSystemTime] when this event was created.
 *
 * @property [value] The value that was emitted.
 * @property [elapsedSystemTime] The elapsed system time when the event was created.
 */
@OptIn(ExperimentalTime::class)
class Event<T>(
    val value: T,
    val elapsedSystemTime: Duration = currentElapsedSystemTime
) {

    operator fun component1(): T = value

    operator fun component2(): Duration = elapsedSystemTime

    /**
     * Creates a copy of this [Event] class while optionally overriding the values.
     */
    fun copy(
        value: T = this.value,
        elapsedSystemTime: Duration = this.elapsedSystemTime
    ): Event<T> = Event(
        value = value,
        elapsedSystemTime = elapsedSystemTime
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is Event<*>) return false

        if (value != other.value) return false

        return elapsedSystemTime == other.elapsedSystemTime
    }

    override fun hashCode(): Int {
        var result = value?.hashCode() ?: 0

        result = 31 * result + elapsedSystemTime.hashCode()

        return result
    }

    override fun toString(): String =
        "Event(value=$value, elapsedSystemTime=$elapsedSystemTime)"

    companion object
}
