package com.chrynan.presentation.ksp.model

import kotlin.reflect.KClass

data class AnnotationGroup(
    val stateKClass: KClass<*>,
    val performFunctions: Set<PerformAnnotatedFunction> = emptySet(),
    val reduceFunctions: Set<ReduceAnnotatedFunction> = emptySet()
)
