# presentation

Kotlin multi-platform presentation layer design pattern. This is a uni-directional data flow (UDF) design pattern
library that is closely related to the MVI (Model-View-Intent) pattern on Android. It utilizes kotlinx.coroutines Flows
and is easily compatible with modern UI Frameworks, such as Jetpack Compose.  <br/>
<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/chRyNaN/presentation">

```kotlin
@Composable
fun App() {
    +HomeLayout()
}

class HomeLayout : Layout<HomeIntent, HomeState, HomeChange> {

    override val presenter = Presenter(
                perform = { intent, state -> ... },
                reduce = { state, change -> ... })

    @Composable
    override fun Content() {
        val state by stateChanges()
        
        when (state) {
            is HomeState.Loading -> {
                CircularProgressIndicator()
            }
            is HomeState.Loaded -> {
                Text("Hello ${state.name}")
            }
        }
    }

    override fun onBind() = intent(to = HomeIntent.Load)
}
```

## Usage

The library introduces components that interact with each other using a uni-directional, cyclic data flow. Roughly, the
flow of data looks like the following:

```
      Intent           Change            State
View --------> Action --------> Reducer -------> View
```

A quick breakdown of some of the components:

* **View** - The View component renders the State to the UI and emits Intents after events, such as User actions.
* **Intent** - The Intent component is simply an indicator of what action the View intends to perform.
* **Action** - The Action component handles the application logic for a particular Intent and outputs a Flow of Changes.
  It is responsible for connecting the business logic (Usecases, Repositories, etc) to this design pattern.
* **Change** - The Change component is simply an indicator of what change to the State must be performed.
* **Reducer** - The Reducer component takes the current State and a Change and deduces a new State.
* **State** - The State component contains all of the necessary data to completely render the UI.
* **Presenter** - The Presenter component is the connecting piece that coordinates the flow of data between each of the
  other components.

### Create the State and models

Typically, the `Intent`, `State`, and `Change` are sealed classes per screen and defined in the same file. These
components are platform independent, meaning they can live in shared code.

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

    data class StartedRefreshing(val currentItems: List<Item>) : HomeChange()
}

sealed class HomeState : State {

    object LoadingInitial : HomeState()

    data class LoadingMore(val currentItems: List<Item>) : HomeState()

    data class Refreshing(val currentItems: List<Item>) : HomeState()

    object DisplayingEmpty : HomeState()

    data class DisplayingLoaded(val items: List<Item>) : HomeState()
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

        this.intents
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

The `View` implementation is a platform specific class. For instance, the `View` implementation on Android might be
a `Fragment` or this library's `Layout` class if using Jetpack Compose.

#### Jetpack Compose

Let's consider a Jetpack Compose implementation of the `View` interface. In this scenario, we can extend from
the `Layout` class to simplify the implementation.

```kotlin
class HomeLayout : Layout<HomeIntent, HomeState, HomeChange> {

    override val presenter: Presenter<HomeIntent, HomeState, HomeChange> = ... // Get the Presenter

    @Composable
    override fun Content(state: HomeState) {
        // Render the UI based on the state that is available
        // Emit intents using the intent(to) function
    }
}
```

Then we can include this `Layout` implementation in any `@Composable` function with the `composeLayout` function:

```kotlin
@Composable
fun App() {
    ComposeLayout(HomeLayout())
}
```

For convenience, we can also use the `unaryPlus` function which delegates to the `composeLayout` function:

```kotlin
@Composable
fun App() {
    +HomeLayout()
}
```

## Navigation

This library no longer provides a way to handle the navigation for an application. The navigation components have been
moved to their own [library]("https://github.com/chRyNaN/navigation").

## Building the library

The library is provided through [Repsy.io](https://repsy.io/). Checkout
the [releases page](https://github.com/chRyNaN/presentation/releases) to get the latest version. <br/>
<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/chRyNaN/presentation">

### Repository

```groovy
repositories {
    maven {
        url = uri("https://repo.repsy.io/mvn/chrynan/public")
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

More detailed documentation is available in the [docs](docs/) folder. The entry point to the documentation can be
found [here](docs/index.md).

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
