@file:Suppress("unused")

package com.chrynan.presentation

import kotlin.system.getTimeMillis
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.ExperimentalTime

@ExperimentalTime
internal actual val currentElapsedSystemTime: Duration
    get() = getTimeMillis().milliseconds
