package com.chrynan.presentation.ksp.util

import com.chrynan.presentation.ksp.model.AnnotationGroup
import kotlin.reflect.KCallable

internal val AnnotationGroup.stateSimpleName: String
    get() = this.stateKClass.simpleName ?: error("State class cannot be anonymous.")

internal val AnnotationGroup.coreComponentSimpleName: String
    get() = stateSimpleName.removeSuffix("State")

internal val AnnotationGroup.intentSimpleName: String
    get() = coreComponentSimpleName + "Intent"

internal val AnnotationGroup.viewModelSimpleName: String
    get() = coreComponentSimpleName + "ViewModel"

internal val <T> KCallable<T>.simpleName: String
    get() {
        val lastDot = name.lastIndexOf('.')

        return if (lastDot != -1 && lastDot < name.lastIndex) {
            name.substring(startIndex = 0, endIndex = lastDot)
        } else {
            name
        }
    }

internal fun String.titleCase(): String =
    this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }

internal fun String.camelCase(): String =
    this.replaceFirstChar { it.lowercase() }
