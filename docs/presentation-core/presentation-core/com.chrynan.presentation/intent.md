//[presentation-core](../../index.md)/[com.chrynan.presentation](index.md)/[intent](intent.md)

# intent

[common]\
fun &lt;[I](intent.md) : [Intent](-intent/index.md), [S](intent.md) : [State](-state/index.md), [C](intent.md) : [Change](-change/index.md)&gt; [View](-view/index.md)&lt;[I](intent.md), [S](intent.md), [C](intent.md)&gt;.[intent](intent.md)(to: [I](intent.md))

Emits the provided [to](-intent/index.md) value to trigger an action, that may eventually result in a new [State](-state/index.md) being rendered.

This is a convenience function for calling [ViewModel.intent](-view-model/intent.md) on the [View.viewModel](-view/view-model.md) property.
