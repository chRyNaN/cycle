//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[PresentationFragment](index.md)/[viewModel](view-model.md)

# viewModel

[android]\
abstract override val [viewModel](view-model.md): [ViewModel](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view-model/index.md)&lt;[I](index.md), [S](index.md), [C](index.md)&gt;

The [ViewModel](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view-model/index.md) this [View](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md) uses to subscribe to [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md) changes and emit [Intent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md)s. The [ViewModel](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view-model/index.md) is the binding piece of this design pattern, between the [View](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md) and itself, that handles coordinating the flow of logic to derive a new [State](../../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md) that this [View](../../../../presentation-core/presentation-core/com.chrynan.presentation/-view/index.md) will then observe and render to the UI.
