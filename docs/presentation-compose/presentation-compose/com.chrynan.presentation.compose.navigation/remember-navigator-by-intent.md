//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose.navigation](index.md)/[rememberNavigatorByIntent](remember-navigator-by-intent.md)

# rememberNavigatorByIntent

[common]\

@[PresentationComposeExperimentalApi](../com.chrynan.presentation.compose/-presentation-compose-experimental-api/index.md)

@Composable

fun &lt;[I](remember-navigator-by-intent.md) : NavigationIntent&gt; [rememberNavigatorByIntent](remember-navigator-by-intent.md)(initialIntent: [I](remember-navigator-by-intent.md), content: @Composable([I](remember-navigator-by-intent.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [ComposeNavigationIntentNavigatorByKeyViewModel](-compose-navigation-intent-navigator-by-key-view-model/index.md)&lt;[I](remember-navigator-by-intent.md)&gt;

Creates and remembers a [ComposeNavigator](-compose-navigator/index.md) that can navigate with a NavigationIntent as a key. This allows for specifying the Composable content up front when creating this [ComposeNavigatorByKey](-compose-navigator-by-key/index.md) and simply navigating with a NavigationIntent key from the [ComposeNavigatorByKey.goTo](-compose-navigator-by-key/go-to.md) function. The returned [ComposeNavigator](-compose-navigator/index.md) implements the Navigator interface.

Example usage:

val navigator = rememberNavigatorByKey(HomeNavigationIntent.Greeting) { navigationIntent -&gt;\
    when(navigationIntent) {\
        HomeNavigationIntent.Greeting -&gt; Text("Hello")\
        HomeNavigationIntent.Farewell -&gt; Text("Good-bye")\
    }\
}\
\
// The NavContainer will start by displaying the initial content, which in this case is "Hello"\
NavContainer(navigator)\
\
// The above NavContainer will display "Good Bye" after the following call:\
navigator.goTo(HomeNavigationIntent.Farewell)\
\
// Goes back to the initial content: "Hello":\
navigator.goBack()

**Note:** That it is typical to use a [ComposeNavigator](-compose-navigator/index.md) with a [NavContainer](-nav-container.md) to display the Composable content and listen to changes.
