package com.chrynan.presentation.ksp.util

import com.google.devtools.ksp.symbol.KSTypeReference
import com.google.devtools.ksp.symbol.Variance
import com.squareup.kotlinpoet.ANY
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.STAR
import com.squareup.kotlinpoet.TypeName

internal fun KSTypeReference.typeName(): TypeName {
    val type = this.resolve()
    val declaration = type.declaration
    val typeName = declaration.qualifiedName?.asString() ?: declaration.simpleName.asString()
    val typeArguments = this.element
        ?.typeArguments
        ?.map { argument ->
            if (argument.variance == Variance.STAR) {
                STAR
            } else {
                argument.type?.typeName() ?: ANY
            }
        } ?: emptyList()

    return if (typeArguments.isEmpty()) {
        ClassName.bestGuess(typeName)
            .copy(nullable = type.isMarkedNullable)
    } else {
        ClassName.bestGuess(typeName)
            .parameterizedBy(typeArguments)
            .copy(nullable = type.isMarkedNullable)
    }
}
