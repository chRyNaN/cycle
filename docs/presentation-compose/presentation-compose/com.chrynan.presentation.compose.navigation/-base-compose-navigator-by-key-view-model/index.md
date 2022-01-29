//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose.navigation](../index.md)/[BaseComposeNavigatorByKeyViewModel](index.md)

# BaseComposeNavigatorByKeyViewModel

[common]\
@[PresentationComposeExperimentalApi](../../com.chrynan.presentation.compose/-presentation-compose-experimental-api/index.md)

abstract class [BaseComposeNavigatorByKeyViewModel](index.md)&lt;[T](index.md)&gt; : [ViewModel](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view-model/index.md), [ComposeNavigator](../-compose-navigator/index.md)&lt;[T](index.md)&gt; , [ComposeNavigatorByKey](../-compose-navigator-by-key/index.md)&lt;[T](index.md)&gt; , [ComposeStackNavigatorByKey](../-compose-stack-navigator-by-key/index.md)&lt;[T](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-compose-stack-navigator/can-go-back.md) | [common]<br>abstract fun [canGoBack](../-compose-stack-navigator/can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goBack](../-compose-stack-navigator-by-key/go-back.md) | [common]<br>abstract fun [goBack](../-compose-stack-navigator-by-key/go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](../-compose-navigator-by-key/go-to.md) | [common]<br>abstract fun [goTo](../-compose-navigator-by-key/go-to.md)(key: [T](index.md), strategy: NavStackDuplicateContentStrategy) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](../-compose-navigator/current-key.md) | [common]<br>abstract val [currentKey](../-compose-navigator/current-key.md): [T](index.md)? |
| [initialKey](../-compose-navigator/initial-key.md) | [common]<br>abstract val [initialKey](../-compose-navigator/initial-key.md): [T](index.md) |
| [isInitialized](../-compose-navigator/is-initialized.md) | [common]<br>abstract val [isInitialized](../-compose-navigator/is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](../-compose-navigator/key-changes.md) | [common]<br>abstract val [keyChanges](../-compose-navigator/key-changes.md): Flow&lt;[T](index.md)&gt; |

## Inheritors

| Name |
|---|
| [ComposeNavigationIntentNavigatorByKeyViewModel](../-compose-navigation-intent-navigator-by-key-view-model/index.md) |
| [ComposeNavigatorByKeyViewModel](../-compose-navigator-by-key-view-model/index.md) |
