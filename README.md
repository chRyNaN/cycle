# presentation

Kotlin Multi-platform Presentation Layer Design Pattern. This is a uni-directional data flow (UDF) design pattern library that is closely related to the MVI pattern on Android. <br/>
<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/chRyNaN/presentation">

## Using the library

The library introduces components that interact with each other using a uni-directional, cyclic data flow. Roughly, the flow of data looks like the following:

```
      Intent           Change            State
View --------> Action --------> Reducer -------> View
```

A quick breakdown of some of the components:
* *View** - The View component renders the State to the UI and emits Intents after events, such as User actions.
* **Intent** - The Intent component is simply an indicator of what action the View intends to perform.
* **Action** - The Action component handles the application logic for a particular Intent and outputs a Flow of Changes. It is responsible for connecting the business logic (Usecases, Repositories, etc) to this design pattern.
* **Change** - The Change component is simply an indicator of what change to the State must be performed.
* **Reducer** - The Reducer component takes the current State and a Change and deduces a new State.
* **State** - The State component contains all of the necessary data to completely render the UI.
* **Presenter** - The Presenter component is the connecting piece that coordinates the flow of data between each of the other components.

### Create the State and models

Typically, the `Intent`, `State`, `Change`, and `NavigationIntent` are sealed classes per screen and defined in the same file. These components are platform independent, meaning they can live in shared code.

For example, consider the following items for a home screen that displays a list of items.

```kotlin
sealed class HomeIntent : Intent {

     object LoadInitial : HomeIntent()

     data class LoadMore(val currentItems: List<Item>) : HomeIntent()

     data class Refresh(val currentItems: List<Item>) : HomeIntent()
}

sealed class HomeChange : Change {

    data class Loaded(val items: List<Item>) : HomeChange()

    data class StartedLoading(val currentItems: List<Item>) : HomeChange()

    data class StartedRefreshing(val currentItems: List<Item>): HomeChange()
}

sealed class HomeState : State {

    object LoadingInitial : HomeState()

    data class LoadingMore(val currentItems: List<Item>) : HomeState()

    data class Refreshing(val currentItems: List<Item>) : HomeState()

    object DisplayingEmpty : HomeState()

    data class DisplayingLoaded(val items: List<Item>) : HomeState()
}

sealed class HomeNavigationIntent : NavigationIntent {

    data class Detail(val item: Item) : HomeNavigationIntent()
}
```

### Create the Presenter

The `Presenter` is a platform independent component that coordinates the flow of data between the other components.

```kotlin
class HomePresenter @Inject constructor(
    ...
) : BasePresenter<HomeIntent, HomeState, HomeChange>() {

    override fun onBind() {
        super.onBind()

        view.intents()
            .perform { intent, state ->
                when (intent) {
                    is HomeIntent.LoadInitial -> loadInitialAction(intent)
                    is HomeIntent.Refresh -> refreshAction(intent)
                    is HomeIntent.LoadMore -> loadMoreAction(intent)
                }
            }
            .reduce { state, change ->
                // deduce new State
            }
            .render()
            .launchIn(this)
    }
}
```

### Create the View

The `View` implementation is a platform specific class. For instance, the `View` implementation on Android might be a `Fragment` or this library's `Layout` class if using Jetpack Compose.

#### Android

Let's consider an Android Fragment implementation of the `View` interface. In this scenario, we can extend from `BasePresentationFragment` to simplify the implementation.

```kotlin
class HomeFragment : BasePresentationFragment<HomeIntent, HomeState, HomeChange, HomeNavigationIntent>() {

    override val presenter: HomePresenter = // Get the Presenter using Dependency Injection

    override fun AndroidNavigationScope.onGoTo(intent: HomeNavigationIntent) {} // Handle navigation

    override fun render(state: HomeState) {
        super.render(state)

        // Render the UI based on the state that is available
        // Emit intents using the intent(to) function
        // Navigate using the navigator?.navigate() function
    }
}
```

#### Jetpack Compose

Let's consider a Jetpack Compose implementation of the `View` interface. In this scenario, we can extend from the `Layout` class to simplify the implementation.

```kotlin
class HomeLayout : Layout<HomeIntent, HomeState, HomeChange> {

    override val key = "HomeLayout"

    override val presenterFactory: PresenterFactory<HomeIntent, HomeState, HomeChange> = // Get the Presenter Factory

    @Composable
    override fun onLayout(state: HomeState) {
        // Render the UI based on the state that is available
        // Emit intents using the intent(to) function
    }
}
```

Then we can include this `Layout` implementation in any `@Composable` function with the `includeLayout` function:

```kotlin
@Composable
fun Home() {
    includeLayout(HomeLayout())
}
```

### Navigation

Navigation is handled through platform specific `NavigationScope`s. Each platform should provide their own `NavigationScope` which provides platform specific means of handling navigation.

An example of navigating using the `AndroidComposeNavigationScope` for Jetpack Compose on Android:

```kotlin
@Composable
fun Home() {
    val navigator = navigator<HomeNavigationIntent> { event ->
        // Access the Activity with this.activity
        // Access the NavController with this.navController

        when (event) {
            is NavigationEvent.Back -> {}
            is NavigationEvent.Up -> {}
            is NavigationEvent.To -> {}
        }
    }
}
```

## Building the library

The library is provided through [Repsy.io](https://repsy.io/). Checkout the [releases page](https://github.com/chRyNaN/presentation/releases) to get the latest version. <br/>
<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/chRyNaN/presentation">

### Repository

```groovy
repositories {
    maven {
        url = uri("https://dl.bintray.com/chrynan/chrynan")
    }
}
```

### Dependencies

#### core

```groovy
implementation("com.chrynan.presentation:presentation-core:VERSION")
```

#### compose

```groovy
implementation("com.chrynan.presentation:presentation-compose:VERSION")
```

## Documentation

More detailed documentation is available in the [docs](docs/) folder. The entry point to the documentation can be found [here](docs/index.md).

## License

```
Copyright 2021 chRyNaN

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
