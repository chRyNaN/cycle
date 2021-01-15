@file:Suppress("unused")

package com.chrynan.presentation.components.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Direction(val typeName: String) {

    @SerialName(value = "top")
    TOP(typeName = "top"),

    @SerialName(value = "bottom")
    BOTTOM(typeName = "bottom"),

    @SerialName(value = "start")
    START(typeName = "start"),

    @SerialName(value = "end")
    END(typeName = "end");

    companion object {

        fun getByTypeName(typeName: String, ignoreCase: Boolean = false): Direction? {
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
