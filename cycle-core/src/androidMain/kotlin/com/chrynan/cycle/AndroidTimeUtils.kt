@file:Suppress("unused")

package com.chrynan.cycle

import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.ExperimentalTime

@ExperimentalTime
internal actual val currentElapsedSystemTime: Duration
    get() = System.currentTimeMillis().milliseconds
