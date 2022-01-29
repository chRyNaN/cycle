//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose.navigation](../index.md)/[BaseComposeNavigatorByContentViewModel](index.md)

# BaseComposeNavigatorByContentViewModel

[common]\
@[PresentationComposeExperimentalApi](../../com.chrynan.presentation.compose/-presentation-compose-experimental-api/index.md)

abstract class [BaseComposeNavigatorByContentViewModel](index.md)&lt;[T](index.md)&gt; : [ViewModel](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view-model/index.md), [ComposeNavigator](../-compose-navigator/index.md)&lt;[T](index.md)&gt; , [ComposeNavigatorByContent](../-compose-navigator-by-content/index.md)&lt;[T](index.md)&gt; , [ComposeStackNavigatorByContent](../-compose-stack-navigator-by-content/index.md)&lt;[T](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](../-compose-stack-navigator/can-go-back.md) | [common]<br>abstract fun [canGoBack](../-compose-stack-navigator/can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goBack](../-compose-stack-navigator-by-content/go-back.md) | [common]<br>@Composable<br>abstract fun [goBack](../-compose-stack-navigator-by-content/go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](../-compose-navigator-by-content/go-to.md) | [common]<br>@Composable<br>abstract fun [goTo](../-compose-navigator-by-content/go-to.md)(key: [T](index.md), strategy: NavStackDuplicateContentStrategy, content: @Composable() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

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
| [ComposeNavigatorByContentViewModel](../-compose-navigator-by-content-view-model/index.md) |
