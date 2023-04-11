package com.chrynan.presentation.ksp.util

import com.google.devtools.ksp.*
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.*
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass

/**
 * Get all symbols with specified annotation [KClass].
 *
 * Note that in multiple round processing, only symbols from deferred symbols of last round and symbols from newly
 * generated files will be returned in this function.
 *
 * @param [annotationKClass] - is the [KClass] of the [Annotation].
 * @param [inDepth] - whether to check symbols in depth, i.e. check symbols from local declarations. Operation can be
 * expensive if true.
 *
 * @return Elements annotated with the specified annotation.
 */
internal fun <A : Annotation> Resolver.getSymbolsWithAnnotation(
    annotationKClass: KClass<A>,
    inDepth: Boolean = false
): Sequence<KSAnnotated> =
    getSymbolsWithAnnotation(
        annotationName = annotationKClass.qualifiedName ?: annotationKClass.simpleName!!,
        inDepth = inDepth
    )

/**
 * Converts this [KSAnnotation] to an instance of the provided [annotationClass] of type [T] or throws an exception if
 * the type could not be converted.
 *
 * Note that this was adapted from the KSP source code.
 */
@OptIn(KspExperimental::class)
internal fun <T : Annotation> KSAnnotation.toAnnotation(annotationKClass: KClass<T>): T =
    toAnnotation(annotationClass = annotationKClass.java)

/**
 * Determines whether this [KSAnnotation] is an annotation of the provided [KClass] type.
 */
internal fun <T : Annotation> KSAnnotation.isOfType(annotationKClass: KClass<T>): Boolean =
    this.shortName.getShortName() == annotationKClass.simpleName &&
            this.annotationType.resolve().declaration.qualifiedName?.asString() == annotationKClass.qualifiedName

/**
 * Converts this [KSAnnotation] to an instance of the provided [annotationClass] of type [T] or throws an exception if
 * the type could not be converted.
 *
 * Note that this was adapted from the KSP source code.
 */
@KspExperimental
@Suppress("UNCHECKED_CAST")
private fun <T : Annotation> KSAnnotation.toAnnotation(annotationClass: Class<T>): T {
    return Proxy.newProxyInstance(
        annotationClass.classLoader,
        arrayOf(annotationClass),
        createInvocationHandler(annotationClass)
    ) as T
}

/**
 * Converts this [Any] type to a [Byte] or throws a cast exception.
 *
 * Note that this was taken from the KSP source code. It seems they may store other number values as [Int]s for some
 * reason. Keeping the same logic that they had to try and mitigate and prevent odd issues.
 */
private fun Any.asByte(): Byte = if (this is Int) this.toByte() else this as Byte

/**
 * Converts this [Any] type to a [Short] or throws a cast exception.
 *
 * Note that this was taken from the KSP source code. It seems they may store other number values as [Int]s for some
 * reason. Keeping the same logic that they had to try and mitigate and prevent odd issues.
 */
private fun Any.asShort(): Short = if (this is Int) this.toShort() else this as Short

/**
 * Converts this [Any] type to a [Long] or throws a cast exception.
 *
 * Note that this was taken from the KSP source code. It seems they may store other number values as [Int]s for some
 * reason. Keeping the same logic that they had to try and mitigate and prevent odd issues.
 */
private fun Any.asLong(): Long = if (this is Int) this.toLong() else this as Long

/**
 * Converts this [Any] type to a [Float] or throws a cast exception.
 *
 * Note that this was taken from the KSP source code. It seems they may store other number values as [Int]s for some
 * reason. Keeping the same logic that they had to try and mitigate and prevent odd issues.
 */
private fun Any.asFloat(): Float = if (this is Int) this.toFloat() else this as Float

/**
 * Converts this [Any] type to a [Double] or throws a cast exception.
 *
 * Note that this was taken from the KSP source code. It seems they may store other number values as [Int]s for some
 * reason. Keeping the same logic that they had to try and mitigate and prevent odd issues.
 */
private fun Any.asDouble(): Double = if (this is Int) this.toDouble() else this as Double

/**
 * Converts this [KSType] to a [Class] instance.
 *
 * Note that this was adapted from the KSP source code.
 */
@KspExperimental
private fun KSType.asClass(proxyClass: Class<*>): Class<*> =
    try {
        Class.forName(this.declaration.qualifiedName!!.asString(), true, proxyClass.classLoader)
    } catch (e: Exception) {
        throw KSTypeNotPresentException(this, e)
    }

/**
 * Converts this [List] of [KSType] to a [List] of [Class] types.
 *
 * Note that this was adapted from the KSP source code.
 */
@KspExperimental
private fun List<KSType>.asClasses(proxyClass: Class<*>): List<Class<*>> =
    try {
        this.map { type -> type.asClass(proxyClass) }
    } catch (e: Exception) {
        throw KSTypesNotPresentException(this, e)
    }

/**
 * Converts this [Any] type to an enum of type [T] or throws an exception if it is not an enum of type [T].
 *
 * Note that this was adapted from the KSP source code.
 */
@Suppress("UNCHECKED_CAST")
private fun <T> Any.asEnum(returnType: Class<T>): T =
    returnType.getDeclaredMethod("valueOf", String::class.java)
        .invoke(
            null,
            if (this is KSType) {
                this.declaration.simpleName.getShortName()
            } else {
                this.toString()
            }
        ) as T

/**
 * Converts this [KSAnnotation] to an [Annotation] [Any] type.
 *
 * Note that this was adapted from the KSP source code.
 */
@KspExperimental
private fun KSAnnotation.asAnnotation(
    annotationInterface: Class<*>,
): Any {
    return Proxy.newProxyInstance(
        annotationInterface.classLoader, arrayOf(annotationInterface),
        this.createInvocationHandler(annotationInterface)
    ) as Proxy
}

/**
 * Converts this [List] to an [Array].
 *
 * Note that this was adapted from the KSP source code.
 */
@Suppress("UNCHECKED_CAST")
private fun List<*>.toArray(method: Method, valueProvider: (Any) -> Any): Array<Any?> {
    val array: Array<Any?> = java.lang.reflect.Array.newInstance(
        method.returnType.componentType,
        this.size
    ) as Array<Any?>

    for (r in indices) {
        array[r] = this[r]?.let { valueProvider.invoke(it) }
    }

    return array
}

/**
 * Converts this [List] of [Any] to an [Array] of the appropriate type.
 *
 * Note that this was adapted from the KSP source code.
 */
@KspExperimental
@Suppress("UNCHECKED_CAST")
private fun List<*>.asArray(method: Method, proxyClass: Class<*>) =
    when (method.returnType.componentType.name) {
        "boolean" -> (this as List<Boolean>).toBooleanArray()
        "byte" -> (this as List<Byte>).toByteArray()
        "short" -> (this as List<Short>).toShortArray()
        "char" -> (this as List<Char>).toCharArray()
        "double" -> (this as List<Double>).toDoubleArray()
        "float" -> (this as List<Float>).toFloatArray()
        "int" -> (this as List<Int>).toIntArray()
        "long" -> (this as List<Long>).toLongArray()
        "java.lang.Class" -> (this as List<KSType>).asClasses(proxyClass).toTypedArray()
        "java.lang.String" -> (this as List<String>).toTypedArray()
        else -> { // arrays of enums or annotations
            when {
                method.returnType.componentType.isEnum -> {
                    this.toArray(method) { result -> result.asEnum(method.returnType.componentType) }
                }

                method.returnType.componentType.isAnnotation -> {
                    this.toArray(method) { result ->
                        (result as KSAnnotation).asAnnotation(method.returnType.componentType)
                    }
                }

                else -> throw IllegalStateException("Unable to process type ${method.returnType.componentType.name}")
            }
        }
    }

/**
 * Creates an [InvocationHandler] for this [KSAnnotation] with the provided [clazz].
 *
 * Note that this was adapted from the KSP source code.
 */
@KspExperimental
@Suppress("TooGenericExceptionCaught")
private fun KSAnnotation.createInvocationHandler(clazz: Class<*>): InvocationHandler {
    val cache = ConcurrentHashMap<Pair<Class<*>, Any>, Any>(arguments.size)

    return InvocationHandler { proxy, method, _ ->
        if (method.name == "toString" && arguments.none { it.name?.asString() == "toString" }) {
            clazz.canonicalName +
                    arguments.map { argument: KSValueArgument ->
                        // handles default values for enums otherwise returns null
                        val methodName = argument.name?.asString()
                        val value = proxy.javaClass.methods.find { m -> m.name == methodName }?.invoke(proxy)
                        "$methodName=$value"
                    }.toList()
        } else {
            val argument = arguments.first { it.name?.asString() == method.name }
            when (val result = argument.value ?: method.defaultValue) {
                is Proxy -> result
                is List<*> -> {
                    val value = { result.asArray(method, clazz) }
                    cache.getOrPut(Pair(method.returnType, result), value)
                }

                else -> {
                    when {
                        method.returnType.isEnum -> {
                            val value = { result.asEnum(method.returnType) }
                            cache.getOrPut(Pair(method.returnType, result), value)
                        }

                        method.returnType.isAnnotation -> {
                            val value = { (result as KSAnnotation).asAnnotation(method.returnType) }
                            cache.getOrPut(Pair(method.returnType, result), value)
                        }

                        method.returnType.name == "java.lang.Class" -> {
                            cache.getOrPut(Pair(method.returnType, result)) {
                                when (result) {
                                    is KSType -> result.asClass(clazz)
                                    // Handles com.intellij.psi.impl.source.PsiImmediateClassType using reflection
                                    // since api doesn't contain a reference to this
                                    else -> Class.forName(
                                        result.javaClass.methods
                                            .first { it.name == "getCanonicalText" }
                                            .invoke(result, false) as String
                                    )
                                }
                            }
                        }

                        method.returnType.name == "byte" -> {
                            val value = { result.asByte() }
                            cache.getOrPut(Pair(method.returnType, result), value)
                        }

                        method.returnType.name == "short" -> {
                            val value = { result.asShort() }
                            cache.getOrPut(Pair(method.returnType, result), value)
                        }

                        method.returnType.name == "long" -> {
                            val value = { result.asLong() }
                            cache.getOrPut(Pair(method.returnType, result), value)
                        }

                        method.returnType.name == "float" -> {
                            val value = { result.asFloat() }
                            cache.getOrPut(Pair(method.returnType, result), value)
                        }

                        method.returnType.name == "double" -> {
                            val value = { result.asDouble() }
                            cache.getOrPut(Pair(method.returnType, result), value)
                        }

                        else -> result // original value
                    }
                }
            }
        }
    }
}
