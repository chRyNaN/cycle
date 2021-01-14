@file:Suppress("unused")

package com.chrynan.presentation.components.model

import com.chrynan.presentation.components.exception.UnsupportedResourceIDException
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an identifier for a resource. Instances of this class most likely should not be
 * created in the common presentation code, but instead should be created by the implementation
 * code. That way if different platforms use different resource identifiers, they can be
 * responsible for creating and handling the appropriate one, and possibly throwing an exception
 * for the unsupported ones.
 *
 * @see [UnsupportedResourceIDException]
 */
@Serializable
sealed class ResourceID {

    abstract val typeName: String
    abstract val id: Any

    /**
     * A [ResourceID] that can be identified by an [Int] [id] value.
     */
    @Serializable
    data class IntResourceID(@SerialName(value = "id") override val id: Int) : ResourceID() {

        @SerialName(value = "type_name")
        override val typeName: String = TYPE_INT
    }

    /**
     * A [ResourceID] that can be identified by a [String] [id] value.
     */
    @Serializable
    data class StringResourceID(@SerialName(value = "id") override val id: String) : ResourceID() {

        @SerialName(value = "type_name")
        override val typeName: String = TYPE_STRING
    }

    companion object {

        const val TYPE_INT = "int"
        const val TYPE_STRING = "string"
    }
}
