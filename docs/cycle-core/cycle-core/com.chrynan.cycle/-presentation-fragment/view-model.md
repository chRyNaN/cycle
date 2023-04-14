//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[PresentationFragment](index.md)/[viewModel](view-model.md)

# viewModel

[android]\
abstract override val [viewModel](view-model.md): [ViewModel](../../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md)&lt;[State](index.md), [Change](index.md)&gt;

The [ViewModel](../../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md) this [View](../../../../cycle-core/cycle-core/com.chrynan.cycle/-view/index.md) uses to subscribe to [State](index.md) changes. The [ViewModel](../../../../cycle-core/cycle-core/com.chrynan.cycle/-view-model/index.md) is the binding piece of this design pattern that handles coordinating the flow of logic to derive a new [State](index.md) that this [View](../../../../cycle-core/cycle-core/com.chrynan.cycle/-view/index.md) will then observe and render to the UI.
