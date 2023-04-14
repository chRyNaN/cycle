//[cycle-core](../../index.md)/[com.chrynan.cycle](index.md)/[flatMap](flat-map.md)

# flatMap

[common]\

@ExperimentalCoroutinesApi

@FlowPreview

inline fun &lt;[T](flat-map.md), [R](flat-map.md)&gt; Flow&lt;[T](flat-map.md)&gt;.[flatMap](flat-map.md)(strategy: [FlatMapStrategy](-flat-map-strategy/index.md) = FlatMapStrategy.Latest, crossinline transform: suspend (value: [T](flat-map.md)) -&gt; Flow&lt;[R](flat-map.md)&gt;): Flow&lt;[R](flat-map.md)&gt;

Performs the appropriate flatMap call according to the provided [strategy](flat-map.md).

#### See also

| |
|---|
| [FlatMapStrategy](-flat-map-strategy/index.md) |
| flatMapLatest |
| flatMapConcat |
| flatMapMerge |
