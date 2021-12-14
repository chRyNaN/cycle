//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose.navigation](index.md)/[rememberNavigatorByKey](remember-navigator-by-key.md)

# rememberNavigatorByKey

[common]\

@[PresentationComposeExperimentalApi](../com.chrynan.presentation.compose/-presentation-compose-experimental-api/index.md)

@Composable

fun &lt;[T](remember-navigator-by-key.md)&gt; [rememberNavigatorByKey](remember-navigator-by-key.md)(initialKey: [T](remember-navigator-by-key.md), content: @Composable([T](remember-navigator-by-key.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [ComposeNavigatorByKeyViewModel](-compose-navigator-by-key-view-model/index.md)&lt;[T](remember-navigator-by-key.md)&gt;

Creates and remembers a [ComposeNavigator](-compose-navigator/index.md) that can navigate with a key. This allows for specifying the Composable content up front when creating this [ComposeNavigatorByKey](-compose-navigator-by-key/index.md) and simply navigating with a key from the [ComposeNavigatorByKey.goTo](-compose-navigator-by-key/go-to.md) function.

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
navigator.goTo("Farewell")\
\
// Goes back to the initial content: "Hello":\
navigator.goBack()

**Note:** That it is typical to use a [ComposeNavigator](-compose-navigator/index.md) with a [NavContainer](-nav-container.md) to display the Composable content and listen to changes.
