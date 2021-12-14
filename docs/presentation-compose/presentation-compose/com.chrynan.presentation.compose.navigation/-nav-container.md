//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose.navigation](index.md)/[NavContainer](-nav-container.md)

# NavContainer

[common]\

@Composable

@[PresentationComposeExperimentalApi](../com.chrynan.presentation.compose/-presentation-compose-experimental-api/index.md)

fun &lt;[T](-nav-container.md)&gt; [NavContainer](-nav-container.md)(navigator: [BaseComposeNavigatorByContentViewModel](-base-compose-navigator-by-content-view-model/index.md)&lt;[T](-nav-container.md)&gt;)

Displays the content from a [navigator](-nav-container.md) in this Composable UI Container.

When the [navigator](-nav-container.md) changes its content, even outside this [NavContainer](-nav-container.md), it will be reflected within this UI container.

Example usage:

val navigator = rememberNavigatorByContent("Greeting") { Text("Hello") }\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello".\
NavContainer(navigator)\
\
// The above NavContainer will display "Good-bye" after the following call:\
navigator.goTo("Farewell") { Text("Good-bye") }

## See also

common

| | |
|---|---|
| [rememberNavigatorByContent](remember-navigator-by-content.md) |  |

[common]\

@Composable

@[PresentationComposeExperimentalApi](../com.chrynan.presentation.compose/-presentation-compose-experimental-api/index.md)

fun &lt;[T](-nav-container.md)&gt; [NavContainer](-nav-container.md)(navigator: [BaseComposeNavigatorByKeyViewModel](-base-compose-navigator-by-key-view-model/index.md)&lt;[T](-nav-container.md)&gt;)

Displays the content from a [navigator](-nav-container.md) in this Composable UI Container.

When the [navigator](-nav-container.md) changes its content, even outside this [NavContainer](-nav-container.md), it will be reflected within this UI container.

Example usage:

val navigator = rememberNavigatorByKey("Greeting") { key -&gt;\
    when(key) {\
        "Greeting" -&gt; Text("Hello")\
        "Farewell" -&gt; Text("Good-bye")\
        else -&gt; Text("Unexpected Key: $key")\
    }\
}\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello"\
NavContainer(navigator)\
\
// The above NavContainer will display "Good Bye" after the following call:\
navigator.goTo("Farewell")

## See also

common

| | |
|---|---|
| [rememberNavigatorByKey](remember-navigator-by-key.md) |  |
| [rememberNavigatorByIntent](remember-navigator-by-intent.md) |  |
