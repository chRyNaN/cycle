package com.chrynan.presentation.components.viewmodel

import com.chrynan.presentation.components.model.Notification
import com.chrynan.presentation.components.model.NotificationColors

data class NotificationViewModel(
    val notification: Notification,
    val colors: NotificationColors
) : ListItemViewModel
