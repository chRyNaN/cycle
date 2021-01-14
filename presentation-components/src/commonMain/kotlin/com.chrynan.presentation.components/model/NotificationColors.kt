@file:Suppress("unused")

package com.chrynan.presentation.components.model

import com.chrynan.colors.Color
import com.chrynan.presentation.components.viewmodel.NotificationViewModel
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A class that represents the colors used to display a [Notification]. This class is used along with
 * a [Notification] to represent the [NotificationViewModel]. Separating these values from the
 * [NotificationViewModel], allows them to be reusable.
 */
@Serializable
data class NotificationColors(
    @SerialName(value = "background_message_color") @Contextual val backgroundMessageColor: Color,
    @SerialName(value = "background_error_color") @Contextual val backgroundErrorColor: Color,
    @SerialName(value = "background_success_color") @Contextual val backgroundSuccessColor: Color,
    @SerialName(value = "background_loading_color") @Contextual val backgroundLoadingColor: Color,
    @SerialName(value = "background_other_color") @Contextual val backgroundOtherColor: Color,
    @SerialName(value = "text_message_color") @Contextual val textMessageColor: Color,
    @SerialName(value = "text_error_color") @Contextual val textErrorColor: Color,
    @SerialName(value = "text_success_color") @Contextual val textSuccessColor: Color,
    @SerialName(value = "text_loading_color") @Contextual val textLoadingColor: Color,
    @SerialName(value = "text_other_color") @Contextual val textOtherColor: Color,
    @SerialName(value = "action_text_message_color") @Contextual val actionTextMessageColor: Color,
    @SerialName(value = "action_text_error_color") @Contextual val actionTextErrorColor: Color,
    @SerialName(value = "action_text_success_color") @Contextual val actionTextSuccessColor: Color,
    @SerialName(value = "action_text_loading_color") @Contextual val actionTextLoadingColor: Color,
    @SerialName(value = "action_text_other_color") @Contextual val actionTextOtherColor: Color
)

/**
 * A convenience function to construct a [NotificationColors] instance with the provided [backgroundColor]
 * as all of the background colors, the [textColor] as all of the text colors, and the [actionTextColor],
 * as all of the action text colors.
 */
fun NotificationColors(
    backgroundColor: Color,
    textColor: Color,
    actionTextColor: Color
): NotificationColors = NotificationColors(
    backgroundMessageColor = backgroundColor,
    backgroundErrorColor = backgroundColor,
    backgroundSuccessColor = backgroundColor,
    backgroundLoadingColor = backgroundColor,
    backgroundOtherColor = backgroundColor,
    textMessageColor = textColor,
    textErrorColor = textColor,
    textSuccessColor = textColor,
    textLoadingColor = textColor,
    textOtherColor = textColor,
    actionTextMessageColor = actionTextColor,
    actionTextErrorColor = actionTextColor,
    actionTextSuccessColor = actionTextColor,
    actionTextLoadingColor = actionTextColor,
    actionTextOtherColor = actionTextColor
)
