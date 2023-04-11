## Components

The library introduces components that interact with each other using a uni-directional, cyclic data flow. Roughly, the
flow of data looks like the following:

```
      Intent           Change            State
View --------> Action --------> Reducer -------> View
```

A quick breakdown of some components:

* **View** - The View component renders the State to the UI and emits Intents after events, such as User actions.
* **Intent** - The Intent component is simply an indicator of what action the View intends to perform.
* **Action** - The Action component handles the application logic for a particular Intent and outputs a Flow of Changes.
  It is responsible for connecting the business logic (UseCases, Repositories, etc) to this design pattern.
* **Change** - The Change component is simply an indicator of what change to the State must be performed.
* **Reducer** - The Reducer component takes the current State and a Change and deduces a new State.
* **State** - The State component contains all the necessary data to completely render the UI.
* **ViewModel** - The ViewModel component is the connecting piece that coordinates the flow of data between each of the
  other components.

The communication channel between the `View` and `ViewModel` looks like the following:

```
              States
   ┌─────────────◄─────────────┐
   │                           ▲
   │                           │
┌──▼───┐                 ┌─────┴─────┐
│ View │                 │ ViewModel │
└──┬───┘                 └─────▲─────┘
   │                           │
   ▼                           │
   └─────────────►─────────────┘
              Intent
```

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

### Create the ViewModel

The `ViewModel` is a platform independent component that coordinates the flow of data between the other components.

```kotlin
class HomeViewModel @Inject constructor(
    ...
) : ViewModel<HomeIntent, HomeState, HomeChange>() {

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

    override val viewModel: ViewModel<HomeIntent, HomeState, HomeChange> = ... // Get the ViewModel

    @Composable
    override fun Content() {
        val state by stateChanges()

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
