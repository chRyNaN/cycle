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

### Create the View

The `View` implementation is a platform specific class. For instance, the `View` implementation on Android might be a `Fragment` or this library's `Layout` class if using Jetpack Compose.

Let's consider an Android Fragment implementation of the `View` interface. In that scenario, we can extend from `BasePresentationFragment` to simplify the implementation.

```kotlin
class HomeFragment : BasePresentationFragment<HomeIntent, HomeState, HomeChange, HomeNavigationIntent>() {

    override val presenter: HomePresenter = // Get the Presenter using Dependency Injection

    override fun AndroidNavigationScope.onGoTo(intent: HomeNavigationIntent) {} // Handle navigation

    override fun render(state: HomeState) {
        super.render(state)

        // Render the UI based on the state that is available
        // Emit intents using the emit(intent) function
        // Navigate using the navigator?.navigate() function
    }
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
            .flowOn(dispatchers.main)
            .perform { intent, state ->
                when (intent) {
                    is HomeIntent.LoadInitial -> loadInitialAction(intent)
                    is HomeIntent.Refresh -> refreshAction(intent)
                    is HomeIntent.LoadMore -> loadMoreAction(intent)
                }
            }
            .reduce { state, change ->
                // Create new State
            }
            .flowOn(dispatchers.io)
            .render()
            .launchIn(this)
    }
}
```

## Building the library

The library is provided through [Repsy.io](https://repsy.io/). Checkout the [releases page](https://github.com/chRyNaN/presentation/releases) to get the latest version. <br/>
<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/chRyNaN/presentation">

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
