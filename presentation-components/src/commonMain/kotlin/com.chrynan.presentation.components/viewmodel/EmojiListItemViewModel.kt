@file:Suppress("unused")

package com.chrynan.presentation.components.viewmodel

import com.chrynan.emoji.presentation.core.EmojiViewModel

data class EmojiListItemViewModel(
    val viewModel: EmojiViewModel
) : ListItemViewModel,
    GridItemViewModel
