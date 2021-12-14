//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose.navigation](index.md)/[rememberNavigatorByContent](remember-navigator-by-content.md)

# rememberNavigatorByContent

[common]\

@[PresentationComposeExperimentalApi](../com.chrynan.presentation.compose/-presentation-compose-experimental-api/index.md)

@Composable

fun &lt;[T](remember-navigator-by-content.md)&gt; [rememberNavigatorByContent](remember-navigator-by-content.md)(initialKey: [T](remember-navigator-by-content.md), initialContent: @Composable() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [ComposeNavigatorByContentViewModel](-compose-navigator-by-content-view-model/index.md)&lt;[T](remember-navigator-by-content.md)&gt;

Creates and remembers a [ComposeNavigator](-compose-navigator/index.md) that can navigate with a key and Composable content. This allows for explicitly specifying the Composable content to navigate to at the [ComposeNavigatorByContent.goTo](-compose-navigator-by-content/go-to.md) function call site. Meaning the Composable content is more flexible and doesn't need to specified upfront when creating this [ComposeNavigatorByContent](-compose-navigator-by-content/index.md).

Example usage:

val navigator = rememberNavigatorByContent("Greeting") { Text("Hello") }\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello".\
NavContainer(navigator)\
\
// The above NavContainer will display "Good-bye" after the following call:\
navigator.goTo("Farewell") { Text("Good-bye") }\
\
// Goes back to the initial content: "Hello":\
navigator.goBack()

**Note:** That it is typical to use a [ComposeNavigator](-compose-navigator/index.md) with a [NavContainer](-nav-container.md) to display the Composable content and listen to changes.
