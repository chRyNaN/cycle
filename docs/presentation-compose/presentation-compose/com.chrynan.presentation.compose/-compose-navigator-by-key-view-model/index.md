//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose](../index.md)/[ComposeNavigatorByKeyViewModel](index.md)

# ComposeNavigatorByKeyViewModel

[common]\
@[PresentationComposeExperimentalApi](../-presentation-compose-experimental-api/index.md)

class [ComposeNavigatorByKeyViewModel](index.md)&lt;[T](index.md)&gt;(initialKey: [T](index.md), content: @Composable([T](index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : [BaseComposeNavigatorByKeyViewModel](../-base-compose-navigator-by-key-view-model/index.md)&lt;[T](index.md)&gt;

## Functions

| Name | Summary |
|---|---|
| [canGoBack](can-go-back.md) | [common]<br>open override fun [canGoBack](can-go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goBack](go-back.md) | [common]<br>open override fun [goBack](go-back.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [goTo](go-to.md) | [common]<br>open override fun [goTo](go-to.md)(key: [T](index.md), strategy: [NavStackDuplicateContentStrategy](../-nav-stack-duplicate-content-strategy/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [currentKey](current-key.md) | [common]<br>open override val [currentKey](current-key.md): [T](index.md)? |
| [initialKey](initial-key.md) | [common]<br>open override val [initialKey](initial-key.md): [T](index.md) |
| [isInitialized](is-initialized.md) | [common]<br>open override val [isInitialized](is-initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true |
| [keyChanges](key-changes.md) | [common]<br>open override val [keyChanges](key-changes.md): Flow&lt;[T](index.md)&gt; |
