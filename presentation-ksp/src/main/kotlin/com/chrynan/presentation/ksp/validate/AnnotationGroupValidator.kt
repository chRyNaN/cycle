package com.chrynan.presentation.ksp.validate

import com.chrynan.presentation.ksp.model.AnnotationGroup
import com.google.devtools.ksp.processing.KSPLogger

internal class AnnotationGroupValidator(
    private val logger: KSPLogger
) {

    fun validate(group: AnnotationGroup) {
        val performOutputs = group.performFunctions.map {
            val returnTypeReference = it.function.returnType


        }
    }
}
