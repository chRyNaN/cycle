@file:Suppress("unused")

package com.chrynan.presentation.components.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a two-dimensional size of a component.
 */
@Serializable
data class Size(
    @SerialName(value = "width") val width: Float,
    @SerialName(value = "height") val height: Float
)
