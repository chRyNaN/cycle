//[cycle-compose](../../../index.md)/[com.chrynan.cycle.compose](../index.md)/[ComposeFragment](index.md)/[Content](-content.md)

# Content

[android]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

abstract fun [Content](-content.md)()

Display the UI content. Remember to subscribe to the state changes using the [stateChanges](../../../../cycle-compose/cycle-compose/com.chrynan.cycle.compose/state-changes.md) function within this function. Using the [renderState](../../../../cycle-compose/com.chrynan.cycle.compose/-compose-fragment/render-state.md) property won't work because it won't trigger a recomposition of the composable function when the state changes.
