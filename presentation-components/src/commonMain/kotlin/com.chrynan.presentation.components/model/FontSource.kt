@file:Suppress("unused")

package com.chrynan.presentation.components.model

import com.chrynan.uri.core.UriString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a font that is to be loaded.
 *
 * Note that this does not contain any information specific to the font, such as, size, typeface,
 * or variant (bold, italic, etc). This is only meant to identify a font so that it can be used
 * from common code. However, it does contain a [name] property which can optionally be used for
 * the font or font-family name value.
 */
@Serializable
sealed class FontSource {

    abstract val name: String?

    @Serializable
    data class Uri(
        @SerialName(value = "name") override val name: String? = null,
        @SerialName(value = "uri") val uri: UriString
    ) : FontSource()

    @Serializable
    data class Resource(
        @SerialName(value = "name") override val name: String? = null,
        @SerialName(value = "id") val id: ResourceID
    ) : FontSource()
}
