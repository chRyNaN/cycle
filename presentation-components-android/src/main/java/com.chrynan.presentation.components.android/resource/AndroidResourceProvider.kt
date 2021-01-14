@file:Suppress("unused")

package com.chrynan.presentation.components.android.resource

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat

class AndroidResourceProvider(private val context: Context) : AndroidResourceAccessor {

    override fun string(@StringRes resourceID: Int): Lazy<String> =
        lazy { context.resources.getString(resourceID) }

    override fun dynamicString(@StringRes resourceID: Int): (arguments: List<Any?>) -> String =
        { context.getString(resourceID, *it.toTypedArray()) }

    override fun drawable(@DrawableRes resourceID: Int): Lazy<Drawable?> =
        lazy { ResourcesCompat.getDrawable(context.resources, resourceID, null) }

    override fun dimen(resourceID: Int): Lazy<Float> = lazy { context.resources.getDimension(resourceID) }

    override fun dimenPixelSize(resourceID: Int): Lazy<Int> =
        lazy { context.resources.getDimensionPixelSize(resourceID) }
}
