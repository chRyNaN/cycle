@file:Suppress("unused")

package com.chrynan.presentation.components.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a coordinate, or a point of focus, in a two-dimensional plane. This is usually used
 * with images.
 */
@Serializable
data class FocalPoint(
    @SerialName(value = "x") val x: Float,
    @SerialName(value = "y") val y: Float
)
