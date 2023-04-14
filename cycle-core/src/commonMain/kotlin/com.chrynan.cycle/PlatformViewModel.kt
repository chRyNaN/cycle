package com.chrynan.cycle

/**
 * The base class that a [ViewModel] inherits from. This allows each supported platform to have a platform-specific
 * base ViewModel component implementation. For instance, on Android this class can extend from the
 * `androidx.lifecycle.ViewModel` component so that it can be used with the Android lifecycle.
 */
expect abstract class PlatformViewModel internal constructor()
