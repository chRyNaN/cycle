@file:Suppress("unused")

package com.chrynan.presentation.components.model

import com.chrynan.uri.core.UriString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an image, or icon, that is to be loaded.
 *
 * Note that this does not represent an image that has been loaded, meaning it has no access to the
 * raw pixel values. Rather this identifies an image to load, whether that be from a resource, a
 * Url, or even from the cache if already loaded. The platforms will handle the loading
 * implementations.
 */
@Serializable
sealed class ImageSource {

    abstract val isAnimatable: Boolean
    abstract val mimeType: String?
    abstract val typeName: String

    /**
     * An [ImageSource] that can be loaded using the [uri] location. This can be an [ImageSource] loaded from a
     * Url or a file uri or something identified by a Uri.
     */
    @Serializable
    data class Uri(
        @SerialName(value = "uri") val uri: UriString,
        @SerialName(value = "is_animatable") override val isAnimatable: Boolean = false,
        @SerialName(value = "mime_type") override val mimeType: String? = null
    ) : ImageSource() {

        @SerialName(value = "type_name")
        override val typeName: String = TYPE_NAME_URI
    }

    /**
     * An [ImageSource] that can be loaded using the [resourceID]. This means the [ImageSource] to load is a
     * resource within the application.
     */
    @Serializable
    data class Resource(
        @SerialName(value = "resource_id") val resourceID: ResourceID,
        @SerialName(value = "is_animatable") override val isAnimatable: Boolean = false,
        @SerialName(value = "mime_type") override val mimeType: String? = null
    ) : ImageSource() {

        @SerialName(value = "type_name")
        override val typeName: String = TYPE_NAME_RESOURCE
    }

    companion object {

        const val TYPE_NAME_URI = "uri"
        const val TYPE_NAME_RESOURCE = "resource"
    }
}
