package com.chrynan.presentation.ksp.visitor

import com.chrynan.presentation.annotation.ExperimentalPresentationApi
import com.chrynan.presentation.annotation.Perform
import com.chrynan.presentation.annotation.Reduce
import com.chrynan.presentation.ksp.model.AnnotatedFunctionRegistrar
import com.chrynan.presentation.ksp.util.isSubtypeOf
import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid

@OptIn(ExperimentalPresentationApi::class, KspExperimental::class)
internal class PerformVisitor(
    private val logger: KSPLogger,
    private val registrar: AnnotatedFunctionRegistrar
) : KSVisitorVoid() {

    override fun visitFunctionDeclaration(function: KSFunctionDeclaration, data: Unit) {
        super.visitFunctionDeclaration(function, data)

        val performAnnotation = function.getAnnotationsByType(Perform::class).firstOrNull() ?: return

        if (function.getAnnotationsByType(Reduce::class).firstOrNull() != null) {
            logger.error(
                message = "${function.simpleName}: A function cannot be annotated with both @Perform and @Reduce as they perform separate functions.",
                symbol = function
            )

            return
        }

        if (function.annotations.any { it.shortName.asString() == "Composable" }) {
            logger.error(
                message = "${function.simpleName}: A function annotated with @Reduce cannot be a @Composable function.",
                symbol = function
            )

            return
        }

        function.extensionReceiver?.let { receiver ->
            if (!receiver.resolve().declaration.isSubtypeOf(performAnnotation.forState)) {
                logger.error(
                    message = "${function.simpleName}: The extension receiver of a @Perform annotated function must be a State type corresponding to the @Perform.forState value.",
                    symbol = function.extensionReceiver
                )

                return
            }
        }

        val returnTypeReference = function.returnType
        val returnType = returnTypeReference?.resolve()

        if (returnTypeReference == null || returnType?.declaration?.qualifiedName?.asString() == "kotlin.Unit" || returnType?.declaration?.qualifiedName?.asString() == "kotlin.Nothing") {
            logger.error(
                message = "${function.simpleName}: A @Perform annotated function must have a return type that is not kotlin.Unit or kotlin.Nothing.",
                symbol = function.returnType
            )

            return
        }

        registrar.set(
            stateKClass = performAnnotation.forState,
            annotation = performAnnotation,
            function = function
        )
    }
}
