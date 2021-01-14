@file:Suppress("unused")

package com.chrynan.presentation.components.android.util

import android.content.Context
import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import com.chrynan.presentation.components.model.Notification
import com.chrynan.presentation.components.model.Shape
import com.chrynan.presentation.components.viewmodel.NotificationViewModel
import com.google.android.material.snackbar.Snackbar

fun View.setBackgroundShape(shape: Shape) {
    val outline = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) {
            when (shape) {
                Shape.Round -> {
                    outline.setRoundRect(
                        0,
                        0,
                        view.width,
                        view.height,
                        (view.height / 2).toFloat()
                    )
                }
                Shape.Rectangle -> {
                    outline.setRect(0, 0, view.width, view.height)
                }
                is Shape.RoundedRectangle -> {
                    outline.setRoundRect(
                        0,
                        0,
                        view.width,
                        view.height,
                        shape.topLeftCornerRadius // TODO fix
                    )
                }
            }
        }
    }

    clipToOutline = true
    outlineProvider = outline
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.visible(visible: Boolean, or: Int = View.GONE) {
    this.visibility = if (visible) View.VISIBLE else or
}

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visible(value, View.GONE)
    }

var View.isInvisible: Boolean
    get() = visibility == View.INVISIBLE
    set(value) {
        visibility = if (value) View.INVISIBLE else View.VISIBLE
    }

fun View.showKeyboard() {
    requestFocus()
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun View.hideKeyboard() {
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
}

fun snackbarOf(
    view: View?,
    viewModel: NotificationViewModel
): Snackbar? {
    if (view == null) return null

    val duration = when (viewModel.notification.length) {
        Notification.Length.SHORT -> Snackbar.LENGTH_SHORT
        Notification.Length.LONG -> Snackbar.LENGTH_LONG
        Notification.Length.INDEFINITE -> Snackbar.LENGTH_INDEFINITE
    }

    return Snackbar.make(view, viewModel.notification.message, duration).apply {
        viewModel.notification.action?.let { action ->
            setAction(action.title) { action.block() }
        }

        when (viewModel.notification.type) {
            Notification.Type.ERROR -> setTextColor(viewModel.colors.textErrorColor.colorInt)
            Notification.Type.MESSAGE -> setTextColor(viewModel.colors.textMessageColor.colorInt)
            Notification.Type.SUCCESS -> setTextColor(viewModel.colors.textSuccessColor.colorInt)
            Notification.Type.LOADING -> setTextColor(viewModel.colors.textLoadingColor.colorInt)
            Notification.Type.OTHER -> setTextColor(viewModel.colors.textOtherColor.colorInt)
        }

        when (viewModel.notification.type) {
            Notification.Type.ERROR -> setActionTextColor(viewModel.colors.textErrorColor.colorInt)
            Notification.Type.MESSAGE -> setActionTextColor(viewModel.colors.textMessageColor.colorInt)
            Notification.Type.SUCCESS -> setActionTextColor(viewModel.colors.textSuccessColor.colorInt)
            Notification.Type.LOADING -> setActionTextColor(viewModel.colors.textLoadingColor.colorInt)
            Notification.Type.OTHER -> setActionTextColor(viewModel.colors.textOtherColor.colorInt)
        }

        when (viewModel.notification.type) {
            Notification.Type.ERROR -> setBackgroundTint(viewModel.colors.backgroundErrorColor.colorInt)
            Notification.Type.MESSAGE -> setBackgroundTint(viewModel.colors.backgroundMessageColor.colorInt)
            Notification.Type.SUCCESS -> setBackgroundTint(viewModel.colors.backgroundSuccessColor.colorInt)
            Notification.Type.LOADING -> setBackgroundTint(viewModel.colors.backgroundLoadingColor.colorInt)
            Notification.Type.OTHER -> setBackgroundTint(viewModel.colors.backgroundOtherColor.colorInt)
        }
    }
}
