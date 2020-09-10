package com.chrynan.presentation

/**
 * Represents an intent to move to a different screen in the application. This is similar to an [Intent] but for
 * changing the screens.
 *
 * For example:
 * ```
 * sealed class HomeScreenIntent : ScreenIntent {
 *
 *     object Feed : HomeScreenIntent()
 * }
 * ```
 */
interface ScreenIntent
