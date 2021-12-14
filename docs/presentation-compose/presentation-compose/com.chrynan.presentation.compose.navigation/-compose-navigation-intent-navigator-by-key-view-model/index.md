//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose.navigation](../index.md)/[ComposeNavigationIntentNavigatorByKeyViewModel](index.md)

# ComposeNavigationIntentNavigatorByKeyViewModel

[common]\
@[PresentationComposeExperimentalApi](../../com.chrynan.presentation.compose/-presentation-compose-experimental-api/index.md)

class [ComposeNavigationIntentNavigatorByKeyViewModel](index.md)&lt;[I](index.md) : [NavigationIntent](../../../../presentation-core/presentation-core/com.chrynan.presentation.navigation/-navigation-intent/index.md)&gt; : [BaseComposeNavigatorByKeyViewModel](../-base-compose-navigator-by-key-view-model/index.md)&lt;[I](index.md)&gt; , [ComposeNavigationIntentStackNavigatorByKey](../-compose-navigation-intent-stack-navigator-by-key/index.md)&lt;[I](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>open override fun [canGoBack](can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goBack](go-back.md) | [common]<br>open override fun [goBack](go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](go-to.md) | [common]<br>open override fun [goTo](go-to.md)(key: [I](index.md), strategy: [NavStackDuplicateContentStrategy](../../../../presentation-core/presentation-core/com.chrynan.presentation.navigation/-nav-stack-duplicate-content-strategy/index.md)) |
| [navigate](../-compose-navigation-intent-stack-navigator-by-key/navigate.md) | [common]<br>open override fun [navigate](../-compose-navigation-intent-stack-navigator-by-key/navigate.md)(event: [NavigationEvent](../../../../presentation-core/presentation-core/com.chrynan.presentation.navigation/-navigation-event/index.md)&lt;[I](index.md)&gt;) |
| [onGoBack](../-compose-navigation-intent-stack-navigator-by-key/on-go-back.md) | [common]<br>open override fun [ComposeNavigationScope](../-compose-navigation-scope/index.md).[onGoBack](../-compose-navigation-intent-stack-navigator-by-key/on-go-back.md)() |
| [onGoTo](../-compose-navigation-intent-stack-navigator-by-key/on-go-to.md) | [common]<br>open override fun [ComposeNavigationScope](../-compose-navigation-scope/index.md).[onGoTo](../-compose-navigation-intent-stack-navigator-by-key/on-go-to.md)(intent: [I](index.md)) |
| [onGoUp](../-compose-navigation-intent-stack-navigator-by-key/on-go-up.md) | [common]<br>open override fun [ComposeNavigationScope](../-compose-navigation-scope/index.md).[onGoUp](../-compose-navigation-intent-stack-navigator-by-key/on-go-up.md)() |
| [onNavigate](index.md#1365892073%2FFunctions%2F-399056487) | [common]<br>open override fun [ComposeNavigationScope](../-compose-navigation-scope/index.md).[onNavigate](index.md#1365892073%2FFunctions%2F-399056487)(event: [NavigationEvent](../../../../presentation-core/presentation-core/com.chrynan.presentation.navigation/-navigation-event/index.md)&lt;[I](index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](current-key.md) | [common]<br>open override val [currentKey](current-key.md): [I](index.md)? |
| [initialKey](initial-key.md) | [common]<br>open override val [initialKey](initial-key.md): [I](index.md) |
| [isInitialized](is-initialized.md) | [common]<br>open override val [isInitialized](is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true |
| [keyChanges](key-changes.md) | [common]<br>open override val [keyChanges](key-changes.md): Flow&lt;[I](index.md)&gt; |
