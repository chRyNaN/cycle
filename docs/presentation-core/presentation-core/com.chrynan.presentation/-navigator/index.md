//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Navigator](index.md)

# Navigator

[common]\
interface [Navigator](index.md)&lt;[I](index.md) : [NavigationIntent](../-navigation-intent/index.md), [S](index.md) : [NavigationScope](../-navigation-scope/index.md)&gt;

A [Navigator](index.md) is responsible for changing and showing the different Screens in the application.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [navigate](navigate.md) | [common]<br>abstract fun [navigate](navigate.md)(event: [NavigationEvent](../-navigation-event/index.md)&lt;[I](index.md)&gt;)<br>Navigates to the provided [event](navigate.md). |

## Properties

| Name | Summary |
|---|---|
| [handler](handler.md) | [common]<br>abstract val [handler](handler.md): [NavigationHandler](../-navigation-handler/index.md)&lt;[I](index.md), [S](index.md)&gt;<br>The [NavigationHandler](../-navigation-handler/index.md) that is used to change between the different screens of the app. |

## Inheritors

| Name |
|---|
| [AndroidNavigator](../-android-navigator/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [goBack](../go-back.md) | [common]<br>fun &lt;[I](../go-back.md) : [NavigationIntent](../-navigation-intent/index.md), [S](../go-back.md) : [NavigationScope](../-navigation-scope/index.md)&gt; [Navigator](index.md)&lt;[I](../go-back.md), [S](../go-back.md)&gt;.[goBack](../go-back.md)()<br>A convenience function for calling [Navigator.navigate](navigate.md) with [NavigationEvent.Back](../-navigation-event/-back/index.md). |
| [goTo](../go-to.md) | [common]<br>fun &lt;[I](../go-to.md) : [NavigationIntent](../-navigation-intent/index.md), [S](../go-to.md) : [NavigationScope](../-navigation-scope/index.md)&gt; [Navigator](index.md)&lt;[I](../go-to.md), [S](../go-to.md)&gt;.[goTo](../go-to.md)(intent: [I](../go-to.md))<br>A convenience function for calling [Navigator.navigate](navigate.md) with [NavigationEvent.To](../-navigation-event/-to/index.md). |
| [goUp](../go-up.md) | [common]<br>fun &lt;[I](../go-up.md) : [NavigationIntent](../-navigation-intent/index.md), [S](../go-up.md) : [NavigationScope](../-navigation-scope/index.md)&gt; [Navigator](index.md)&lt;[I](../go-up.md), [S](../go-up.md)&gt;.[goUp](../go-up.md)()<br>A convenience function for calling [Navigator.navigate](navigate.md) with [NavigationEvent.Up](../-navigation-event/-up/index.md). |
