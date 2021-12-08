//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose.navigation](../index.md)/[ComposeNavigationIntentStackNavigatorByKey](index.md)

# ComposeNavigationIntentStackNavigatorByKey

[common]\
@[PresentationComposeExperimentalApi](../../com.chrynan.presentation.compose/-presentation-compose-experimental-api/index.md)

interface [ComposeNavigationIntentStackNavigatorByKey](index.md)&lt;[I](index.md) : [NavigationIntent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-intent/index.md)&gt; : [ComposeStackNavigatorByKey](../-compose-stack-navigator-by-key/index.md)&lt;[I](index.md)&gt; , [NavigationEventHandler](../../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-event-handler/index.md)&lt;[I](index.md), [ComposeNavigationScope](../-compose-navigation-scope/index.md)&gt; , [Navigator](../../../../presentation-core/presentation-core/com.chrynan.presentation/-navigator/index.md)&lt;[I](index.md), [ComposeNavigationScope](../-compose-navigation-scope/index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-compose-stack-navigator/can-go-back.md) | [common]<br>abstract fun [canGoBack](../-compose-stack-navigator/can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goBack](../-compose-stack-navigator-by-key/go-back.md) | [common]<br>abstract fun [goBack](../-compose-stack-navigator-by-key/go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](index.md#-978215500%2FFunctions%2F-399056487) | [common]<br>abstract fun [goTo](index.md#-978215500%2FFunctions%2F-399056487)(key: [I](index.md), strategy: [NavStackDuplicateContentStrategy](../-nav-stack-duplicate-content-strategy/index.md)) |
| [navigate](navigate.md) | [common]<br>open override fun [navigate](navigate.md)(event: [NavigationEvent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-event/index.md)&lt;[I](index.md)&gt;) |
| [onGoBack](on-go-back.md) | [common]<br>open override fun [ComposeNavigationScope](../-compose-navigation-scope/index.md).[onGoBack](on-go-back.md)() |
| [onGoTo](on-go-to.md) | [common]<br>open override fun [ComposeNavigationScope](../-compose-navigation-scope/index.md).[onGoTo](on-go-to.md)(intent: [I](index.md)) |
| [onGoUp](on-go-up.md) | [common]<br>open override fun [ComposeNavigationScope](../-compose-navigation-scope/index.md).[onGoUp](on-go-up.md)() |
| [onNavigate](../-compose-navigation-intent-navigator-by-key-view-model/index.md#511531189%2FFunctions%2F-399056487) | [common]<br>open override fun [ComposeNavigationScope](../-compose-navigation-scope/index.md).[onNavigate](../-compose-navigation-intent-navigator-by-key-view-model/index.md#511531189%2FFunctions%2F-399056487)(event: [NavigationEvent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-event/index.md)&lt;[I](index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](../-compose-navigator/current-key.md) | [common]<br>abstract val [currentKey](../-compose-navigator/current-key.md): [I](index.md)? |
| [handler](index.md#-505496204%2FProperties%2F-399056487) | [common]<br>abstract val [handler](index.md#-505496204%2FProperties%2F-399056487): [NavigationHandler](../../../../presentation-core/presentation-core/com.chrynan.presentation/-navigation-handler/index.md)&lt;[I](index.md), [ComposeNavigationScope](../-compose-navigation-scope/index.md)&gt; |
| [initialKey](../-compose-navigator/initial-key.md) | [common]<br>abstract val [initialKey](../-compose-navigator/initial-key.md): [I](index.md) |
| [isInitialized](../-compose-navigator/is-initialized.md) | [common]<br>abstract val [isInitialized](../-compose-navigator/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-compose-navigator/key-changes.md) | [common]<br>abstract val [keyChanges](../-compose-navigator/key-changes.md): Flow&lt;[I](index.md)&gt; |

## Inheritors

| Name |
|---|
| [ComposeNavigationIntentNavigatorByKeyViewModel](../-compose-navigation-intent-navigator-by-key-view-model/index.md) |
