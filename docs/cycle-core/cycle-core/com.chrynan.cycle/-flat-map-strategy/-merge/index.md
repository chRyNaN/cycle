//[cycle-core](../../../../index.md)/[com.chrynan.cycle](../../index.md)/[FlatMapStrategy](../index.md)/[Merge](index.md)

# Merge

data class [Merge](index.md)(val limit: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = DEFAULT_CONCURRENCY) : [FlatMapStrategy](../index.md)

Equivalent to the Flow.flatMapMerge function.

#### See also

| |
|---|
| flatMapMerge |

## Constructors

| | |
|---|---|
| [Merge](-merge.md) | [common]<br>constructor(limit: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = DEFAULT_CONCURRENCY) |

## Properties

| Name | Summary |
|---|---|
| [limit](limit.md) | [common]<br>val [limit](limit.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The amount of concurrently running flat-mapped Flows. The default value is set to DEFAULT_CONCURRENCY. |
