//[presentation-compose](../../../index.md)/[com.chrynan.presentation.compose.layout](../index.md)/[Layout](index.md)/[Content](-content.md)

# Content

[common]\

@Composable

abstract fun [Content](-content.md)()

Renders the UI content for this Layout.

Example usage:

@Composable\
override fun Content() {\
    val state by stateChanges()\
\
    Text("State = $state")\
}
