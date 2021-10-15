//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose](../index.md)/[ComposeNavigatorByContent](index.md)

# ComposeNavigatorByContent

[common]\
@[PresentationComposeExperimentalApi](../-presentation-compose-experimental-api/index.md)

interface [ComposeNavigatorByContent](index.md)&lt;[T](index.md)&gt; : [ComposeNavigator](../-compose-navigator/index.md)&lt;[T](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [goTo](go-to.md) | [common]<br>@Composable<br>abstract fun [goTo](go-to.md)(key: [T](index.md), strategy: [NavStackDuplicateContentStrategy](../-nav-stack-duplicate-content-strategy/index.md), content: @Composable() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

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
| [BaseComposeNavigatorByContentViewModel](../-base-compose-navigator-by-content-view-model/index.md) |
