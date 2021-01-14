@file:Suppress("unused")

package com.chrynan.presentation.components.viewmodel

data class EmojiCategoryListItemViewModel(
    val category: String,
    val categoryEmoji: EmojiListItemViewModel? = null,
    val emojis: List<EmojiListItemViewModel> = emptyList(),
    val isSelected: Boolean = false,
    val isEmojiTitlePreferred: Boolean = false
) : ListItemViewModel
