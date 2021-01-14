@file:Suppress("unused")

package com.chrynan.presentation.components.model

import com.chrynan.uri.core.UriString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a media item. This could be an Image, Video, or Audio.
 */
@Serializable
sealed class MediaItem {

    abstract val typeName: String
    abstract val uri: UriString
    abstract val content: Any
    abstract val mimeType: String?
    abstract val label: String?

    @Serializable
    data class Image(
        @SerialName(value = "uri") override val uri: UriString,
        @SerialName(value = "content") override val content: ImageSource,
        @SerialName(value = "mime_type") override val mimeType: String? = null,
        @SerialName(value = "label") override val label: String? = null,
        @SerialName(value = "blur_hash") val blurHash: String? = null,
        @SerialName(value = "focal_point") val focalPoint: FocalPoint? = null,
        @SerialName(value = "size") val size: Size? = null,
        @SerialName(value = "aspect_ratio") val aspectRatio: String? = null,
        @SerialName(value = "preview") val preview: ImageSource? = null
    ) : MediaItem() {

        @SerialName(value = "type_name")
        override val typeName: String = TYPE_NAME_IMAGE
    }

    @Serializable
    data class Video(
        @SerialName(value = "uri") override val uri: UriString,
        @SerialName(value = "mime_type") override val mimeType: String? = null,
        @SerialName(value = "label") override val label: String? = null,
        @SerialName(value = "blur_hash") val blurHash: String? = null,
        @SerialName(value = "size") val size: Size? = null,
        @SerialName(value = "aspect_ratio") val aspectRatio: String? = null,
        @SerialName(value = "preview") val preview: ImageSource? = null,
        @SerialName(value = "duration_in_millis") val durationInMilliseconds: Long? = null
    ) : MediaItem() {

        override val content: UriString = uri

        @SerialName(value = "type_name")
        override val typeName: String = TYPE_NAME_VIDEO
    }

    @Serializable
    data class Audio(
        @SerialName(value = "uri") override val uri: UriString,
        @SerialName(value = "mime_type") override val mimeType: String? = null,
        @SerialName(value = "label") override val label: String? = null,
        @SerialName(value = "preview") val preview: ImageSource? = null,
        @SerialName(value = "duration_in_millis") val durationInMilliseconds: Long? = null
    ) : MediaItem() {

        override val content: UriString = uri

        @SerialName(value = "type_name")
        override val typeName: String = TYPE_NAME_AUDIO
    }

    companion object {

        const val TYPE_NAME_IMAGE = "image"
        const val TYPE_NAME_VIDEO = "video"
        const val TYPE_NAME_AUDIO = "audio"
    }
}
