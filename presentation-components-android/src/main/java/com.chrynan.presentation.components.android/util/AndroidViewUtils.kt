@file:Suppress("unused")

package com.chrynan.presentation.components.android.util

import android.content.Context
import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import android.view.inputmethod.InputMethodManager
import com.chrynan.presentation.components.model.Shape

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
