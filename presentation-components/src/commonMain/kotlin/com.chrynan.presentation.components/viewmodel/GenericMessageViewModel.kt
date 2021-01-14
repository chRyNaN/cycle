@file:Suppress("unused")

package com.chrynan.presentation.components.viewmodel

import com.chrynan.presentation.ViewModel
import com.chrynan.presentation.components.model.MediaItem

data class GenericMessageViewModel(
    val messageText: CharSequence,
    val image: MediaItem.Image? = null,
    val buttonText: CharSequence? = null
) : ViewModel
