//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[ViewModelFactory](index.md)

# ViewModelFactory

[common]\
interface [ViewModelFactory](index.md)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [common]<br>abstract fun &lt;[I](create.md) : [Intent](../-intent/index.md), [S](create.md) : [State](../-state/index.md), [C](create.md) : [Change](../-change/index.md), [V](create.md) : [ViewModel](../-view-model/index.md)&lt;[I](create.md), [S](create.md), [C](create.md)&gt;&gt; [create](create.md)(kClass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;[V](create.md)&gt;, vararg extras: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [V](create.md) |

## Extensions

| Name | Summary |
|---|---|
| [create](../create.md) | [common]<br>inline fun &lt;[I](../create.md) : [Intent](../-intent/index.md), [S](../create.md) : [State](../-state/index.md), [C](../create.md) : [Change](../-change/index.md), [V](../create.md) : [ViewModel](../-view-model/index.md)&lt;[I](../create.md), [S](../create.md), [C](../create.md)&gt;&gt; [ViewModelFactory](index.md).[create](../create.md)(vararg extras: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [V](../create.md) |
| [createOrNull](../create-or-null.md) | [common]<br>fun &lt;[I](../create-or-null.md) : [Intent](../-intent/index.md), [S](../create-or-null.md) : [State](../-state/index.md), [C](../create-or-null.md) : [Change](../-change/index.md), [V](../create-or-null.md) : [ViewModel](../-view-model/index.md)&lt;[I](../create-or-null.md), [S](../create-or-null.md), [C](../create-or-null.md)&gt;&gt; [ViewModelFactory](index.md).[createOrNull](../create-or-null.md)(kClass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;[V](../create-or-null.md)&gt;, vararg extras: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [V](../create-or-null.md)?<br>inline fun &lt;[I](../create-or-null.md) : [Intent](../-intent/index.md), [S](../create-or-null.md) : [State](../-state/index.md), [C](../create-or-null.md) : [Change](../-change/index.md), [V](../create-or-null.md) : [ViewModel](../-view-model/index.md)&lt;[I](../create-or-null.md), [S](../create-or-null.md), [C](../create-or-null.md)&gt;&gt; [ViewModelFactory](index.md).[createOrNull](../create-or-null.md)(vararg extras: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [V](../create-or-null.md)? |
