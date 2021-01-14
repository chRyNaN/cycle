@file:Suppress("unused")

package com.chrynan.presentation.components.model

import com.chrynan.presentation.ViewModel
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a notification to be displayed. This class does not contain any information about how the
 * notification is displayed (it's also not a [ViewModel]), so it's up to the platform implementation to
 * handle displaying the [Notification] in a platform specific manner. However, it is recommended that
 * this not be used as a Phone system level notification, as it is meant to be an application level
 * component.
 */
@Serializable
data class Notification(
    @SerialName(value = "message") @Contextual val message: CharSequence,
    @SerialName(value = "icon") val icon: ImageSource? = null,
    @SerialName(value = "type") val type: Type = Type.MESSAGE,
    @SerialName(value = "length") val length: Length = Length.SHORT,
    @SerialName(value = "action") val action: Action? = null,
    @SerialName(value = "priority") val priority: Int = 0
) {

    @Serializable
    enum class Type(val typeName: String) {

        @SerialName(value = "message")
        MESSAGE(typeName = "message"),

        @SerialName(value = "error")
        ERROR(typeName = "error"),

        @SerialName(value = "success")
        SUCCESS(typeName = "success"),

        @SerialName(value = "loading")
        LOADING(typeName = "loading"),

        @SerialName(value = "other")
        OTHER(typeName = "other");

        companion object {

            fun getByTypeName(typeName: String, ignoreCase: Boolean): Type? {
                val formattedTypeName = if (ignoreCase) typeName.toLowerCase() else typeName

                return values().firstOrNull {
                    if (ignoreCase) {
                        it.typeName.toLowerCase() == formattedTypeName
                    } else {
                        it.typeName == formattedTypeName
                    }
                }
            }
        }
    }

    @Serializable
    enum class Length(val typeName: String) {

        @SerialName(value = "short")
        SHORT(typeName = "short"),

        @SerialName(value = "long")
        LONG(typeName = "long"),

        @SerialName(value = "indefinite")
        INDEFINITE(typeName = "indefinite");

        companion object {

            fun getByTypeName(typeName: String, ignoreCase: Boolean): Length? {
                val formattedTypeName = if (ignoreCase) typeName.toLowerCase() else typeName

                return values().firstOrNull {
                    if (ignoreCase) {
                        it.typeName.toLowerCase() == formattedTypeName
                    } else {
                        it.typeName == formattedTypeName
                    }
                }
            }
        }
    }

    @Serializable
    data class Action(
        @SerialName(value = "title") @Contextual val title: CharSequence,
        @SerialName(value = "block") @Contextual val block: () -> Unit
    )
}
