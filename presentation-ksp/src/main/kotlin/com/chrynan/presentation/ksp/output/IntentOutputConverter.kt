package com.chrynan.presentation.ksp.output

import com.chrynan.presentation.Action
import com.chrynan.presentation.annotation.ExperimentalPresentationApi
import com.chrynan.presentation.ksp.model.AnnotationGroup
import com.chrynan.presentation.ksp.util.intentSimpleName
import com.chrynan.presentation.ksp.util.titleCase
import com.chrynan.presentation.ksp.util.typeName
import com.google.devtools.ksp.getAllSuperTypes
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeSpec
import kotlin.reflect.KClass

@OptIn(ExperimentalPresentationApi::class)
class IntentOutputConverter {

    operator fun invoke(group: AnnotationGroup): TypeSpec {
        val builder = TypeSpec.classBuilder(group.intentSimpleName)
            .addModifiers(KModifier.INTERNAL, KModifier.SEALED)

        group.performFunctions.forEach { annotatedFunction ->
            builder.addType(
                TypeSpec.classBuilder(annotatedFunction.actionName.titleCase())
                    .primaryConstructor(
                        FunSpec.constructorBuilder()
                            .addModifiers(KModifier.INTERNAL)
                            .addParameters(
                                annotatedFunction.function.parameters.map { parameter ->
                                    ParameterSpec.builder(
                                        name = parameter.name?.getShortName()!!,
                                        type = parameter.type.typeName()
                                    ).build()
                                }
                            )
                            .build()
                    )
                    .build()
            )
        }

        return builder.build()
    }
}
