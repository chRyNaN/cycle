//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose.navigation](../index.md)/[ComposeNavigatorByContentViewModel](index.md)

# ComposeNavigatorByContentViewModel

[common]\
@[PresentationComposeExperimentalApi](../../com.chrynan.presentation.compose/-presentation-compose-experimental-api/index.md)

class [ComposeNavigatorByContentViewModel](index.md)&lt;[T](index.md)&gt; : [BaseComposeNavigatorByContentViewModel](../-base-compose-navigator-by-content-view-model/index.md)&lt;[T](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>open override fun [canGoBack](can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goBack](go-back.md) | [common]<br>@Composable<br>open override fun [goBack](go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](go-to.md) | [common]<br>@Composable<br>open override fun [goTo](go-to.md)(key: [T](index.md), strategy: NavStackDuplicateContentStrategy, content: @Composable() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](current-key.md) | [common]<br>open override val [currentKey](current-key.md): [T](index.md)? |
| [initialKey](initial-key.md) | [common]<br>open override val [initialKey](initial-key.md): [T](index.md) |
| [isInitialized](is-initialized.md) | [common]<br>open override var [isInitialized](is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [keyChanges](key-changes.md) | [common]<br>open override val [keyChanges](key-changes.md): Flow&lt;[T](index.md)&gt; |
