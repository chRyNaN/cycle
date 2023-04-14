package com.chrynan.cycle

import kotlin.js.Date
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.ExperimentalTime

@Suppress("unused")
@ExperimentalTime
// JavaScript doesn't seem to have a way to obtain the elapsed system time. So instead we just get the current Date
// instance to get the elapsed time since the epoch. This should be fine in most cases.
internal actual val currentElapsedSystemTime: Duration
    get() = Date().getTime().milliseconds
