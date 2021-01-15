@file:Suppress("unused")

package com.chrynan.presentation.components.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a text style that is to be loaded.
 *
 * Note that this does not contain any information specific to the text style (size, underline,
 * line spacing, etc) other than the [font] and an optional [name] of the text style. This is
 * only meant to identify a text style so that it can be used from common code.
 *
 * Note that this differs from a [FontSource] in that a [FontSource] identifies the actual font,
 * font-family, or typeface used and this [TextStyleSource] identifies a text style which contains
 * a font and more information about formatting the text, such as, size and line spacing.
 */
@Serializable
data class TextStyleSource(
    @SerialName(value = "name") val name: String? = null,
    @SerialName(value = "font") val font: FontSource,
    @SerialName(value = "id") val resourceID: ResourceID
)
