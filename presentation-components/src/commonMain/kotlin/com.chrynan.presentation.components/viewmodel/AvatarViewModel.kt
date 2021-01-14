@file:Suppress("unused")

package com.chrynan.presentation.components.viewmodel

import com.chrynan.presentation.ViewModel
import com.chrynan.presentation.components.model.MediaItem
import com.chrynan.presentation.components.model.Shape

data class AvatarViewModel(
    val id: String,
    val name: CharSequence,
    val image: MediaItem.Image? = null,
    val badge: BadgeViewModel? = null,
    val backgroundShape: Shape? = null
) : ViewModel,
    ListItemViewModel,
    GridItemViewModel {

    override val uniqueId: Long = id.hashCode().toLong()
}
