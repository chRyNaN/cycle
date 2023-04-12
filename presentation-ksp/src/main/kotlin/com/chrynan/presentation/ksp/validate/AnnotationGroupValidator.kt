package com.chrynan.presentation.ksp.validate

import com.chrynan.presentation.ksp.model.AnnotationGroup
import com.chrynan.presentation.ksp.util.isSubtypeOf
import com.google.devtools.ksp.processing.KSPLogger

internal class AnnotationGroupValidator(
    private val logger: KSPLogger
) {

    fun validate(group: AnnotationGroup) {
        val performOutputs = group.performFunctions.mapNotNull {
            it.function.returnType?.resolve()
        }
        val reduceInputs = group.reduceFunctions.flatMap {
            it.function.parameters.map { parameter -> parameter.type.resolve() }
                .filter { type -> !type.declaration.isSubtypeOf(group.stateKClass) }
        }.toSet()

        val nonReducedTypes = performOutputs.filter { !reduceInputs.contains(it) }

        // TODO: Support Flow types.

        if (nonReducedTypes.isNotEmpty()) {
            logger.error(
                message = "${group.stateKClass.qualifiedName}: There must be a @Reduce annotated function for every return type from a @Perform annotated function for an associated State type.",
                symbol = null
            )

            return
        }
    }
}
