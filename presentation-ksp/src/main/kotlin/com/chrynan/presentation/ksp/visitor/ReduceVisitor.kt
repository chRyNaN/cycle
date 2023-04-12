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
internal class ReduceVisitor(
    private val logger: KSPLogger,
    private val registrar: AnnotatedFunctionRegistrar
) : KSVisitorVoid() {

    override fun visitFunctionDeclaration(function: KSFunctionDeclaration, data: Unit) {
        super.visitFunctionDeclaration(function, data)

        val reduceAnnotation = function.getAnnotationsByType(Reduce::class).firstOrNull() ?: return

        if (function.getAnnotationsByType(Perform::class).firstOrNull() != null) {
            logger.error(
                message = "${function.simpleName}: A function cannot be annotated with both @Perform and @Reduce as they perform separate functions.",
                symbol = function
            )

            return
        }

        if (function.annotations.any { it.shortName.asString() == "Composable" }) {
            logger.error(
                message = "${function.simpleName}: A function annotated with @Perform cannot be a @Composable function.",
                symbol = function
            )

            return
        }

        function.extensionReceiver?.let { receiver ->
            if (!receiver.resolve().declaration.isSubtypeOf(reduceAnnotation.forState)) {
                logger.error(
                    message = "${function.simpleName}: The extension receiver of a @Reduce annotated function must be a State type corresponding to the @Reduce.forState value.",
                    symbol = function.extensionReceiver
                )

                return
            }
        }

        val returnType = function.returnType
        if (returnType == null || !returnType.resolve().declaration.isSubtypeOf(reduceAnnotation.forState)) {
            logger.error(
                message = "${function.simpleName}: The return type of a @Reduce annotated function must be a State type corresponding to the @Reduce.forState value.",
                symbol = function.extensionReceiver
            )

            return
        }

        registrar.set(
            stateKClass = reduceAnnotation.forState,
            annotation = reduceAnnotation,
            function = function
        )
    }
}
