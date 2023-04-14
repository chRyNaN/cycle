//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[View](index.md)/[viewModel](view-model.md)

# viewModel

[common]\
abstract val [viewModel](view-model.md): [ViewModel](../-view-model/index.md)&lt;[State](index.md), [Change](index.md)&gt;

The [ViewModel](../-view-model/index.md) this [View](index.md) uses to subscribe to [State](index.md) changes. The [ViewModel](../-view-model/index.md) is the binding piece of this design pattern that handles coordinating the flow of logic to derive a new [State](index.md) that this [View](index.md) will then observe and render to the UI.
