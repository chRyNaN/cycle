//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose.navigation](../index.md)/[ComposeNavigator](index.md)

# ComposeNavigator

[common]\
@[PresentationComposeExperimentalApi](../../com.chrynan.presentation.compose/-presentation-compose-experimental-api/index.md)

interface [ComposeNavigator](index.md)&lt;[T](index.md)&gt;

## Properties

| Name | Summary |
|---|---|
| [currentKey](current-key.md) | [common]<br>abstract val [currentKey](current-key.md): [T](index.md)? |
| [initialKey](initial-key.md) | [common]<br>abstract val [initialKey](initial-key.md): [T](index.md) |
| [isInitialized](is-initialized.md) | [common]<br>abstract val [isInitialized](is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyChanges](key-changes.md) | [common]<br>abstract val [keyChanges](key-changes.md): Flow&lt;[T](index.md)&gt; |

## Inheritors

| Name |
|---|
| [ComposeNavigatorByContent](../-compose-navigator-by-content/index.md) |
| [ComposeNavigatorByKey](../-compose-navigator-by-key/index.md) |
| [ComposeStackNavigator](../-compose-stack-navigator/index.md) |
| [BaseComposeNavigatorByContentViewModel](../-base-compose-navigator-by-content-view-model/index.md) |
| [BaseComposeNavigatorByKeyViewModel](../-base-compose-navigator-by-key-view-model/index.md) |
