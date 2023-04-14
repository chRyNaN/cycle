//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[ViewModelFactory](index.md)

# ViewModelFactory

[common]\
@[ExperimentalPresentationApi](../-experimental-presentation-api/index.md)

@ExperimentalCoroutinesApi

@FlowPreview

interface [ViewModelFactory](index.md)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [common]<br>abstract fun &lt;[State](create.md), [Change](create.md), [V](create.md) : [ViewModel](../-view-model/index.md)&lt;[State](create.md), [Change](create.md)&gt;&gt; [create](create.md)(kClass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;[V](create.md)&gt;, vararg extras: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [V](create.md) |
| [create](../create.md) | [common]<br>@[ExperimentalPresentationApi](../-experimental-presentation-api/index.md)<br>@ExperimentalCoroutinesApi<br>@FlowPreview<br>inline fun &lt;[State](../create.md), [Change](../create.md), [V](../create.md) : [ViewModel](../-view-model/index.md)&lt;[State](../create.md), [Change](../create.md)&gt;&gt; [ViewModelFactory](index.md).[create](../create.md)(vararg extras: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [V](../create.md) |
| [createOrNull](../create-or-null.md) | [common]<br>@[ExperimentalPresentationApi](../-experimental-presentation-api/index.md)<br>@ExperimentalCoroutinesApi<br>@FlowPreview<br>inline fun &lt;[State](../create-or-null.md), [Change](../create-or-null.md), [V](../create-or-null.md) : [ViewModel](../-view-model/index.md)&lt;[State](../create-or-null.md), [Change](../create-or-null.md)&gt;&gt; [ViewModelFactory](index.md).[createOrNull](../create-or-null.md)(vararg extras: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [V](../create-or-null.md)?<br>@[ExperimentalPresentationApi](../-experimental-presentation-api/index.md)<br>@ExperimentalCoroutinesApi<br>@FlowPreview<br>fun &lt;[State](../create-or-null.md), [Change](../create-or-null.md), [V](../create-or-null.md) : [ViewModel](../-view-model/index.md)&lt;[State](../create-or-null.md), [Change](../create-or-null.md)&gt;&gt; [ViewModelFactory](index.md).[createOrNull](../create-or-null.md)(kClass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;[V](../create-or-null.md)&gt;, vararg extras: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [V](../create-or-null.md)? |
