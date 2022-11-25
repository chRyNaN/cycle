//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[ViewModelProvider](index.md)

# ViewModelProvider

[common]\
interface [ViewModelProvider](index.md)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [common]<br>abstract operator fun &lt;[I](get.md) : [Intent](../-intent/index.md), [S](get.md) : [State](../-state/index.md), [C](get.md) : [Change](../-change/index.md), [V](get.md) : [ViewModel](../-view-model/index.md)&lt;[I](get.md), [S](get.md), [C](get.md)&gt;&gt; [get](get.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, kClass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;[V](get.md)&gt;): [V](get.md) |

## Extensions

| Name | Summary |
|---|---|
| [get](../get.md) | [common]<br>inline fun &lt;[I](../get.md) : [Intent](../-intent/index.md), [S](../get.md) : [State](../-state/index.md), [C](../get.md) : [Change](../-change/index.md), [V](../get.md) : [ViewModel](../-view-model/index.md)&lt;[I](../get.md), [S](../get.md), [C](../get.md)&gt;&gt; [ViewModelProvider](index.md).[get](../get.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [V](../get.md) |
| [getOrNull](../get-or-null.md) | [common]<br>fun &lt;[I](../get-or-null.md) : [Intent](../-intent/index.md), [S](../get-or-null.md) : [State](../-state/index.md), [C](../get-or-null.md) : [Change](../-change/index.md), [V](../get-or-null.md) : [ViewModel](../-view-model/index.md)&lt;[I](../get-or-null.md), [S](../get-or-null.md), [C](../get-or-null.md)&gt;&gt; [ViewModelProvider](index.md).[getOrNull](../get-or-null.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, kClass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;[V](../get-or-null.md)&gt;): [V](../get-or-null.md)?<br>inline fun &lt;[I](../get-or-null.md) : [Intent](../-intent/index.md), [S](../get-or-null.md) : [State](../-state/index.md), [C](../get-or-null.md) : [Change](../-change/index.md), [V](../get-or-null.md) : [ViewModel](../-view-model/index.md)&lt;[I](../get-or-null.md), [S](../get-or-null.md), [C](../get-or-null.md)&gt;&gt; [ViewModelProvider](index.md).[getOrNull](../get-or-null.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [V](../get-or-null.md)? |
