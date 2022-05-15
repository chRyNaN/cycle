//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[View](index.md)/[viewModel](view-model.md)

# viewModel

[common]\
abstract val [viewModel](view-model.md): [ViewModel](../-view-model/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt;

The [ViewModel](../-view-model/index.md) this [View](index.md) uses to subscribe to [State](../-state/index.md) changes and emit [Intent](../-intent/index.md)s. The [ViewModel](../-view-model/index.md) is the binding piece of this design pattern, between the [View](index.md) and itself, that handles coordinating the flow of logic to derive a new [State](../-state/index.md) that this [View](index.md) will then observe and render to the UI.
