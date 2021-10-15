//[presentation-core](../../../index.md)/[com.chrynan.presentation.android](../index.md)/[AndroidNavigator](index.md)/[handler](handler.md)

# handler

[android]\
open override val [handler](handler.md): [NavigationHandler](../../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-handler/index.md)&lt;[I](index.md), [AndroidNavigationScope](../-android-navigation-scope/index.md)&gt;

The [NavigationHandler](../../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-handler/index.md) that is used to change between the different screens of the app.

Note that this is provided for convenience, such as checking which handler was set, but the functions of the [handler](handler.md) should not be invoked directly. Instead, let this [Navigator](../../../../presentation-core/presentation-core/com.chrynan.presentation/-navigator/index.md) properly handle invoking the [handler](handler.md) functions.
