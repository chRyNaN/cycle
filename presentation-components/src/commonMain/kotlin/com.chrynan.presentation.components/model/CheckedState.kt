@file:Suppress("unused")

package com.chrynan.presentation.components.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CheckedState(val typeName: String) {

    @SerialName(value = "checked")
    CHECKED(typeName = "checked"),

    @SerialName(value = "not_checked")
    NOT_CHECKED(typeName = "not_checked"),

    @SerialName(value = "not_checkable")
    NOT_CHECKABLE(typeName = "not_checkable");

    companion object {

        fun getByTypeName(typeName: String, ignoreCase: Boolean = false): CheckedState? {
            val formattedTypeName = if (ignoreCase) typeName.toLowerCase() else typeName

            return values().firstOrNull {
                if (ignoreCase) {
                    formattedTypeName == it.typeName.toLowerCase()
                } else {
                    formattedTypeName == it.typeName
                }
            }
        }
    }
}
