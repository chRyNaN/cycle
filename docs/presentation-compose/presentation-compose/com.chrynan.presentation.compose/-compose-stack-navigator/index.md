//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose](../index.md)/[ComposeStackNavigator](index.md)

# ComposeStackNavigator

[common]\
@[PresentationComposeExperimentalApi](../-presentation-compose-experimental-api/index.md)

interface [ComposeStackNavigator](index.md)&lt;[T](index.md)&gt; : [ComposeNavigator](../-compose-navigator/index.md)&lt;[T](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>abstract fun [canGoBack](can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

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
| [ComposeStackNavigatorByContent](../-compose-stack-navigator-by-content/index.md) |
| [ComposeStackNavigatorByKey](../-compose-stack-navigator-by-key/index.md) |
