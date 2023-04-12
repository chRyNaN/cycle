package com.chrynan.presentation.ksp

import com.chrynan.presentation.annotation.ExperimentalPresentationApi
import com.chrynan.presentation.annotation.Perform
import com.chrynan.presentation.annotation.Reduce
import com.chrynan.presentation.ksp.model.AnnotatedFunctionRegistrar
import com.chrynan.presentation.ksp.util.accept
import com.chrynan.presentation.ksp.util.getSymbolsWithAnnotation
import com.chrynan.presentation.ksp.validate.AnnotationGroupValidator
import com.chrynan.presentation.ksp.visitor.PerformVisitor
import com.chrynan.presentation.ksp.visitor.ReduceVisitor
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated

@OptIn(ExperimentalPresentationApi::class)
internal class PresentationSymbolProcessor(
    private val logger: KSPLogger,
    private val codeGenerator: CodeGenerator
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val registrar = AnnotatedFunctionRegistrar()
        val performVisitor = PerformVisitor(logger = logger, registrar = registrar)
        val reduceVisitor = ReduceVisitor(logger = logger, registrar = registrar)
        val validator = AnnotationGroupValidator(logger = logger)

        resolver.getSymbolsWithAnnotation(Perform::class)
            .forEach { it.accept(performVisitor) }

        resolver.getSymbolsWithAnnotation(Reduce::class)
            .forEach { it.accept(reduceVisitor) }

        registrar.annotationGroups.forEach { group ->
            validator.validate(group)
        }

        TODO("Not yet implemented")
    }
}
