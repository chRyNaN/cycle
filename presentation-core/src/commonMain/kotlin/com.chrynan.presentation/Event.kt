package com.chrynan.presentation

import kotlin.time.Duration
import kotlin.time.ExperimentalTime

/**
 * An event wrapper class around an [Intent] of type [T]. This class represents the event of an [Intent] being emitted.
 * It contains additional event related properties, such as the [elapsedSystemTime] when this event was created.
 */
@OptIn(ExperimentalTime::class)
data class Event<T>(
    val value: T,
    val elapsedSystemTime: Duration = currentElapsedSystemTime
)
