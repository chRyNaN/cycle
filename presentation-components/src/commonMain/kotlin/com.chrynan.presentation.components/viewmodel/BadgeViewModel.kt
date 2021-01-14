@file:Suppress("unused")

package com.chrynan.presentation.components.viewmodel

import com.chrynan.presentation.ViewModel
import com.chrynan.presentation.components.model.ImageSource
import com.chrynan.presentation.components.model.Shape

sealed class BadgeViewModel : ViewModel {

    abstract val count: Int?
    abstract val backgroundShape: Shape

    data class Image(
        override val count: Int? = null,
        override val backgroundShape: Shape = Shape.Round,
        val image: ImageSource
    ) : BadgeViewModel()

    data class Color(
        override val count: Int? = null,
        override val backgroundShape: Shape = Shape.Round,
        val color: com.chrynan.colors.Color
    ) : BadgeViewModel()
}
