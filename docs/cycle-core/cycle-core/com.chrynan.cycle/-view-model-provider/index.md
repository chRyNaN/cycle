//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[ViewModelProvider](index.md)

# ViewModelProvider

[common]\
@[ExperimentalPresentationApi](../-experimental-presentation-api/index.md)

@ExperimentalCoroutinesApi

@FlowPreview

interface [ViewModelProvider](index.md)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [common]<br>abstract operator fun &lt;[State](get.md), [Change](get.md), [V](get.md) : [ViewModel](../-view-model/index.md)&lt;[State](get.md), [Change](get.md)&gt;&gt; [get](get.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, kClass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;[V](get.md)&gt;): [V](get.md) |
| [get](../get.md) | [common]<br>@[ExperimentalPresentationApi](../-experimental-presentation-api/index.md)<br>@ExperimentalCoroutinesApi<br>@FlowPreview<br>inline fun &lt;[State](../get.md), [Change](../get.md), [V](../get.md) : [ViewModel](../-view-model/index.md)&lt;[State](../get.md), [Change](../get.md)&gt;&gt; [ViewModelProvider](index.md).[get](../get.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [V](../get.md) |
| [getOrNull](../get-or-null.md) | [common]<br>@[ExperimentalPresentationApi](../-experimental-presentation-api/index.md)<br>@ExperimentalCoroutinesApi<br>@FlowPreview<br>inline fun &lt;[State](../get-or-null.md), [Change](../get-or-null.md), [V](../get-or-null.md) : [ViewModel](../-view-model/index.md)&lt;[State](../get-or-null.md), [Change](../get-or-null.md)&gt;&gt; [ViewModelProvider](index.md).[getOrNull](../get-or-null.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [V](../get-or-null.md)?<br>@[ExperimentalPresentationApi](../-experimental-presentation-api/index.md)<br>@ExperimentalCoroutinesApi<br>@FlowPreview<br>fun &lt;[State](../get-or-null.md), [Change](../get-or-null.md), [V](../get-or-null.md) : [ViewModel](../-view-model/index.md)&lt;[State](../get-or-null.md), [Change](../get-or-null.md)&gt;&gt; [ViewModelProvider](index.md).[getOrNull](../get-or-null.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, kClass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;[V](../get-or-null.md)&gt;): [V](../get-or-null.md)? |
