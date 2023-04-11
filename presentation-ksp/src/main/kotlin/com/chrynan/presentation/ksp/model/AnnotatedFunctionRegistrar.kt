package com.chrynan.presentation.ksp.model

import com.chrynan.presentation.State
import com.chrynan.presentation.annotation.ExperimentalPresentationApi
import com.chrynan.presentation.annotation.Perform
import com.chrynan.presentation.annotation.Reduce
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import kotlin.reflect.KClass

@OptIn(ExperimentalPresentationApi::class)
internal class AnnotatedFunctionRegistrar {

    private val annotationGroupsByStateKClass = mutableMapOf<KClass<*>, AnnotationGroup>()

    val annotationGroups: List<AnnotationGroup>
        get() = annotationGroupsByStateKClass.values.toList()

    operator fun get(
        stateKClass: KClass<State>
    ): AnnotationGroup? =
        annotationGroupsByStateKClass[stateKClass]

    operator fun <A> set(
        stateKClass: KClass<State>,
        annotation: A,
        function: KSFunctionDeclaration
    ) {
        val group = annotationGroupsByStateKClass[stateKClass] ?: AnnotationGroup(stateKClass = stateKClass)

        if (annotation is Perform) {
            group.copy(
                performFunctions = group.performFunctions + PerformAnnotatedFunction(
                    annotation = annotation,
                    function = function
                )
            )
        } else if (annotation is Reduce) {
            group.copy(
                reduceFunctions = group.reduceFunctions + ReduceAnnotatedFunction(
                    annotation = annotation,
                    function = function
                )
            )
        }

        annotationGroupsByStateKClass[stateKClass] = group
    }
}
