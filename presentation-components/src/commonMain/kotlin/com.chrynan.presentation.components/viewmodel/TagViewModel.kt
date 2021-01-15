@file:Suppress("unused")

package com.chrynan.presentation.components.viewmodel

import com.chrynan.presentation.components.model.CheckedState
import com.chrynan.presentation.components.model.CheckedStateColors
import com.chrynan.presentation.components.model.Direction
import com.chrynan.presentation.components.model.ImageSource

data class TagViewModel(
    val content: CharSequence,
    val icon: ImageSource? = null,
    val iconDirection: Direction = Direction.START,
    val actionIcon: ImageSource? = null,
    val actionIconDirection: Direction = Direction.END,
    val checkedState: CheckedState = CheckedState.NOT_CHECKED,
    val checkedColors: CheckedStateColors? = null
) : ListItemViewModel,
    GridItemViewModel
