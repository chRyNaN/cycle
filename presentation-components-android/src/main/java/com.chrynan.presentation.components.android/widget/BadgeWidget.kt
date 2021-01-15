package com.chrynan.presentation.components.android.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import com.chrynan.presentation.components.android.util.setBackgroundShape
import com.chrynan.presentation.components.viewmodel.BadgeViewModel

class BadgeWidget @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {

    var viewModel: BadgeViewModel? = null
        set(value) {
            field = value

            when (value) {
                is BadgeViewModel.Color -> {
                    setBackgroundShape(value.backgroundShape)
                    setBackgroundColor(value.color.colorInt)

                }
                is BadgeViewModel.Image -> {
                }
                else -> {
                }
            }
        }
}
