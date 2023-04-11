package com.chrynan.presentation.ksp.model

import com.chrynan.presentation.annotation.ExperimentalPresentationApi
import com.chrynan.presentation.annotation.Perform
import com.chrynan.presentation.annotation.Reduce
import com.chrynan.presentation.ksp.util.isActionPerformFunction
import com.google.devtools.ksp.symbol.KSFunctionDeclaration

sealed interface AnnotatedFunction<A : Annotation> {

    val annotation: A
    val function: KSFunctionDeclaration
}

@OptIn(ExperimentalPresentationApi::class)
data class PerformAnnotatedFunction(
    override val annotation: Perform,
    override val function: KSFunctionDeclaration
) : AnnotatedFunction<Perform> {

    private var storedActionName: String? = null

    val actionName: String
        get() {
            storedActionName?.let { return it }

            val name = if (annotation.name.isNotBlank()) {
                annotation.name
            } else if (function.isActionPerformFunction()) {
                function.parentDeclaration?.simpleName?.getShortName() ?: function.simpleName.getShortName()
            } else {
                function.simpleName.getShortName()
            }

            storedActionName = name

            return name
        }
}

@OptIn(ExperimentalPresentationApi::class)
data class ReduceAnnotatedFunction(
    override val annotation: Reduce,
    override val function: KSFunctionDeclaration
) : AnnotatedFunction<Reduce>
