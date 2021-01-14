@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.chrynan.presentation.components.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A class indicating a basic supported [Shape]. This is typically used to indicate the background of a
 * Widget.
 *
 * Note that this class does not have any size information, the size is irrespective of the
 * [Shape] and is typically handled by the target platform in a platform specific manner. It's the job
 * of the platform to transform this [Shape] into a platform specific component and render appropriately.
 *
 * Note that this [Shape] class does not contain any complex generic shapes, such as those defined by a
 * path. For more complex shapes, platform specific tools should be used instead.
 */
@Serializable
sealed class Shape {

    abstract val typeName: String

    /**
     * Represents a circle shape.
     */
    @Serializable
    object Round : Shape() {

        @SerialName(value = "type_name")
        override val typeName: String = TYPE_NAME_ROUND
    }

    /**
     * Represents a rectangle shape.
     */
    @Serializable
    object Rectangle : Shape() {

        @SerialName(value = "type_name")
        override val typeName: String = TYPE_NAME_RECTANGLE
    }

    /**
     * Represents a rounded rectangle shape. The corner radius properties indicate the size of the corner
     * radius in arbitrary [Float] units. The provided units could be platform specific or represent pixels,
     * this class makes no assertion either way.
     */
    @Serializable
    data class RoundedRectangle(
        @SerialName(value = "top_left_corner_radius") val topLeftCornerRadius: Float,
        @SerialName(value = "top_right_corner_radius") val topRightCornerRadius: Float,
        @SerialName(value = "bottom_left_corner_radius") val bottomLeftCornerRadius: Float,
        @SerialName(value = "bottom_right_corner_radius") val bottomRightCornerRadius: Float
    ) : Shape() {

        @SerialName(value = "type_name")
        override val typeName = TYPE_NAME_ROUNDED_RECTANGLE
    }

    companion object {

        const val TYPE_NAME_ROUND = "round"
        const val TYPE_NAME_RECTANGLE = "rectangle"
        const val TYPE_NAME_ROUNDED_RECTANGLE = "rounded_rectangle"
    }
}

/**
 * A convenience function to construct a new [Shape.RoundedRectangle] where all corner radius values
 * equal the provided [cornerRadius].
 */
@Suppress("FunctionName")
fun Shape.RoundedRectangle(cornerRadius: Float): Shape.RoundedRectangle =
    Shape.RoundedRectangle(
        topLeftCornerRadius = cornerRadius,
        topRightCornerRadius = cornerRadius,
        bottomLeftCornerRadius = cornerRadius,
        bottomRightCornerRadius = cornerRadius
    )
