@file:Suppress("unused")

package com.chrynan.presentation.components.android.resource

import android.graphics.drawable.Drawable
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.chrynan.presentation.components.exception.UnsupportedResourceIDException
import com.chrynan.presentation.components.model.ResourceID

interface AndroidResourceAccessor {

    fun string(@StringRes resourceID: Int): Lazy<String>

    fun dynamicString(@StringRes resourceID: Int): (arguments: List<Any?>) -> String

    fun drawable(@DrawableRes resourceID: Int): Lazy<Drawable?>

    fun dimen(@DimenRes resourceID: Int): Lazy<Float>

    fun dimenPixelSize(@DimenRes resourceID: Int): Lazy<Int>

    fun string(resourceID: ResourceID): Lazy<String> =
        if (resourceID is ResourceID.IntResourceID) string(resourceID.id) else throw UnsupportedResourceIDException(
            resourceID,
            "Invalid ResourceID type on Android."
        )

    fun dynamicString(resourceID: ResourceID): (arguments: List<Any?>) -> String =
        if (resourceID is ResourceID.IntResourceID) dynamicString(resourceID.id) else throw UnsupportedResourceIDException(
            resourceID,
            "Invalid ResourceID type on Android."
        )

    fun drawable(resourceID: ResourceID): Lazy<Drawable?> =
        if (resourceID is ResourceID.IntResourceID) drawable(resourceID.id) else throw UnsupportedResourceIDException(
            resourceID,
            "Invalid ResourceID type on Android."
        )

    fun dimen(resourceID: ResourceID): Lazy<Float> =
        if (resourceID is ResourceID.IntResourceID) dimen(resourceID.id) else throw UnsupportedResourceIDException(
            resourceID,
            "Invalid ResourceID type on Android."
        )

    fun dimenPixelSize(resourceID: ResourceID): Lazy<Int> =
        if (resourceID is ResourceID.IntResourceID) dimenPixelSize(resourceID.id) else throw UnsupportedResourceIDException(
            resourceID,
            "Invalid ResourceID type on Android."
        )
}
