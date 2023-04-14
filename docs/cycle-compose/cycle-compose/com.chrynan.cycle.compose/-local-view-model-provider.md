//[cycle-compose](../../index.md)/[com.chrynan.cycle.compose](index.md)/[LocalViewModelProvider](-local-view-model-provider.md)

# LocalViewModelProvider

[common]\

@[ExperimentalPresentationApi](../../../cycle-core/cycle-core/com.chrynan.cycle/-experimental-presentation-api/index.md)

@FlowPreview

@ExperimentalCoroutinesApi

val [LocalViewModelProvider](-local-view-model-provider.md): [ProvidableCompositionLocal](https://developer.android.com/reference/kotlin/androidx/compose/runtime/ProvidableCompositionLocal.html)&lt;[ViewModelProvider](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model-provider/index.md)&gt;

A [ProvidableCompositionLocal](https://developer.android.com/reference/kotlin/androidx/compose/runtime/ProvidableCompositionLocal.html) of [ViewModelProvider](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model-provider/index.md). This allows a parent composable function to provide a [ViewModelProvider](../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model-provider/index.md) which can then be obtained from a child composable function.
