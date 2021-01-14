@file:Suppress("unused")

package com.chrynan.presentation.components.viewmodel

import com.chrynan.presentation.components.model.Direction
import com.chrynan.presentation.components.model.ImageSource

data class ChipViewModel(
    val content: CharSequence,
    val icon: ImageSource? = null,
    val iconDirection: Direction = Direction.START
) : ListItemViewModel,
    GridItemViewModel
