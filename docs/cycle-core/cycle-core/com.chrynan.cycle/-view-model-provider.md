//[cycle-core](../../index.md)/[com.chrynan.cycle](index.md)/[ViewModelProvider](-view-model-provider.md)

# ViewModelProvider

[common]\

@[ExperimentalPresentationApi](-experimental-presentation-api/index.md)

@ExperimentalCoroutinesApi

@FlowPreview

fun [ViewModelProvider](-view-model-provider.md)(factory: [ViewModelFactory](-view-model-factory/index.md)): [ViewModelProvider](-view-model-provider/index.md)

Constructs a [ViewModelProvider](-view-model-provider/index.md) using the provided [ViewModelFactory](-view-model-factory/index.md) to create instances of the ViewModels and caching the values in a [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html) by their associated keys for faster subsequent access.
