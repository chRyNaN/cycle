//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose](../index.md)/[ComposeNavigatorByKey](index.md)

# ComposeNavigatorByKey

[common]\
@[PresentationComposeExperimentalApi](../-presentation-compose-experimental-api/index.md)

interface [ComposeNavigatorByKey](index.md)&lt;[T](index.md)&gt; : [ComposeNavigator](../-compose-navigator/index.md)&lt;[T](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [goTo](go-to.md) | [common]<br>abstract fun [goTo](go-to.md)(key: [T](index.md), strategy: [NavStackDuplicateContentStrategy](../-nav-stack-duplicate-content-strategy/index.md) = NavStackDuplicateContentStrategy.CLEAR_STACK) |

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
| [BaseComposeNavigatorByKeyViewModel](../-base-compose-navigator-by-key-view-model/index.md) |
