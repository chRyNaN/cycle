package com.chrynan.presentation.ksp.util

import com.chrynan.presentation.Action
import com.chrynan.presentation.Reducer
import com.google.devtools.ksp.getAllSuperTypes
import com.google.devtools.ksp.symbol.*
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.KParameter

internal fun KSNode.accept(visitor: KSVisitorVoid) =
    this.accept(visitor = visitor, data = Unit)

internal fun KSDeclaration.isSubtypeOf(kClass: KClass<*>): Boolean =
    kClass.qualifiedName?.let { isSubtypeOf(qualifiedName = it) } ?: false

internal fun KSDeclaration.isSubtypeOf(qualifiedName: String): Boolean {
    val isKClass = (this.qualifiedName?.asString() ?: this.simpleName.asString()) == qualifiedName

    if (isKClass) return true

    val parentClassDeclaration = (this.parentDeclaration as? KSClassDeclaration) ?: return false

    return parentClassDeclaration.getAllSuperTypes()
        .any { type ->
            (type.declaration.qualifiedName?.asString()
                ?: type.declaration.simpleName.asString()) == qualifiedName
        }
}

internal fun KParameter.kClass(): KClass<*>? =
    this.type.classifier as? KClass<*>

internal fun KSFunctionDeclaration.matches(callable: KCallable<*>): Boolean {
    if (this.simpleName.asString() != callable.simpleName) return false

    val callableValueParameters = callable.parameters.filter { it.kind == KParameter.Kind.VALUE }

    if (this.parameters.size != callableValueParameters.size) return false

    this.parameters.forEachIndexed { index, parameter ->
        val parameterType = parameter.type.resolve()
        val callableParameter = callableValueParameters[index]

        if (parameter.name?.asString() != callableParameter.name) return false
        if (parameterType.declaration.qualifiedName?.asString() != callableParameter.kClass()?.qualifiedName) return false
        if (parameter.isVararg != callableParameter.isVararg) return false
        if (parameterType.isMarkedNullable != callableParameter.type.isMarkedNullable) return false
    }

    if (
        (this.extensionReceiver?.resolve()?.declaration?.qualifiedName?.asString()) !=
        (callable.parameters.firstOrNull { it.kind == KParameter.Kind.EXTENSION_RECEIVER }?.kClass()?.qualifiedName)
    ) {
        return false
    }

    return true
}

internal fun KSFunctionDeclaration.isActionPerformFunction(): Boolean {
    val isContainingClassAnAction = this.parentDeclaration?.isSubtypeOf(Action::class) ?: false

    if (!isContainingClassAnAction) return false

    return this.modifiers.contains(Modifier.OVERRIDE) &&
            this.matches(Action<*, *, *>::perform)
}

internal fun KSFunctionDeclaration.isReducerReduceFunction(): Boolean {
    val isContainingClassAReducer = this.parentDeclaration?.isSubtypeOf(Reducer::class) ?: false

    if (!isContainingClassAReducer) return false

    return this.modifiers.contains(Modifier.OVERRIDE) &&
            this.matches(Reducer<*, *>::reduce)
}
