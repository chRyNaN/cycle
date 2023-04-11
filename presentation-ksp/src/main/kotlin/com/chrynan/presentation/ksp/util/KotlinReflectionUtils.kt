package com.chrynan.presentation.ksp.util

import kotlin.reflect.KCallable

internal val <T> KCallable<T>.simpleName: String
    get() {
        val lastDot = name.lastIndexOf('.')

        return if (lastDot != -1 && lastDot < name.lastIndex) {
            name.substring(startIndex = 0, endIndex = lastDot)
        } else {
            name
        }
    }
