## Components

### Intent
An `Intent` represents the View's desire to perform an action. It does not contain any logic to perform the action, rather it states what the View wishes to do.

#### Type
Immutable Data Type

#### Kotlin Type
`Intent`

#### Referenced By Components
`View` - Returns a `Flow` of emitted `Intents` through its `intents()` function.
<br/>
`Presenter` - Listens to `Intents` by subscribing to a `Views` `intents()` function.
<br/>
`Action` - Converts `Intents` to `Changes`.

#### References Components
None

#### Naming Convention
The outer sealed class name should begin with a Screen description, end with the word `Intent`, and exclude any Screen monikers ("Screen", "Fragment", "Activity").
<br/>
The inner classes should be a declaration of an intention without the `Intent` suffix.

#### Example
```kotlin
sealed class FeedIntent : Intent {

     object LoadInitial : FeedIntent()

     data class LoadMore(val currentItems: List<Item>) : FeedIntent()

     data class Refresh(val currentItems: List<Item>) : FeedIntent()
 }
```

---

### Action
An `Action` converts an `Intent` to a `Flow` of `Changes` by performing application and business logic. `Actions` connect the business logic with application.
Note that `Actions` shouldn't directly perform business logic but rather delegate to the business layer components (UseCases, Repositories, etc) and coordinate and map the results to application layer components (ViewModels, States, etc).

#### Type
Single Focus Functional Type

#### Kotlin Type
`Action`

#### Referenced By Components
`Presenter` - Calls `Actions` with `Intents` from a `Views` `intents()` function.

#### References Components
`Intent` - Takes in an `Intent` to produce a `Flow` of `Changes`.
<br/>
`Change` - Outputs a `Flow` of `Changes` from an `Intent`.
<br/>
`Mapper` - Maps business components to application components.

#### Naming Convention
An `Action` class should be named specifically to describe the action that it performs, and ends with the word `Action`.

#### Example
```kotlin
class LoadInitialAction(
    private val repository: FeedRepository,
    private val mapper: Mapper<FeedItem, FeedItemViewModel>
): Action<FeedIntent, FeedChange> {

    override fun perform(intent: FeedIntent): Flow<FeedChange> =
        repository.loadItems()
                .map { items -> items.map { mapper.map(it) } }
                .map { FeedChange.Loaded(items = it) }
                .startWith(FeedChange.StartedLoading(currentItems = intent.currentItems))
}
```

---

### Change
A `Change` represents the result of performing an action and is used by a `Reducer`, along with a previous `State`, to determine a new `State`. A `Change` affects a `State` to transform it into a new `State`.
However, a `Change` does not contain any logic to convert a `State` to another `State`, that is the responsibility of the `Reducer`.

#### Type
Immutable Data Type

#### Kotlin Type
`Change`

#### Referenced By Components
`Action` - Converts an `Intent` into a `Flow` of `Changes`.
<br/>
`Presenter` - Provides the resulting `Change` from an `Action` to a `Reducer`.
<br/>
`Reducer` - Converts a previous `State` and a `Change` into a new `State`.

#### References Components
None

#### Naming Convention
The outer sealed class name should begin with a Screen description, end with the word `Change`, and exclude any Screen monikers ("Screen", "Fragment", "Activity").
<br/>
The inner classes should be in a past tense verb manner without the `Change` suffix.

#### Example
```kotlin
sealed class FeedChange : Change {

    data class Loaded(val items: List<Item>) : FeedChange()

    data class StartedLoading(val currentItems: List<Item>) : FeedChange()

    data class StartedRefreshing(val currentItems: List<Item>): FeedChange()
}
```

---

### ViewModel
A `ViewModel` is an immutable model object whose properties define the appearance a piece of UI. A `ViewModel` contains no logic and most properties are pre-formatted represent the UI.

**Note:** A `State` extends from the `ViewModel` interface, so a `State` is a `ViewModel`, but a `ViewModel` doesn't have to be a `State`. Typically, `States` represent larger UIs, such as, a whole Screen.

**Note:** There is some terminology conflation between this `ViewModel` class and components in other popular frameworks, such as, the Android Architecture Component's `ViewModel` class. Here a `ViewModel` should perform no logic, and just be a model representation of a UI.

#### Type
Immutable Data Type

#### Kotlin Type
`ViewModel`

#### Referenced By Components
`Mapper` - Maps business logic entities to `ViewModels`.

#### References Components
None

#### Naming Convention
A `ViewModel` should be named specifically after the piece of UI that it represents, ending with the word `ViewModel`.

#### Example
```kotlin
data class FeedItemViewModel(
    val id: ID,
    val formattedTimestamp: String,
    val title: String,
    val description: String,
    val textColor: Color
): ViewModel
```

---

### State
A `State` is a special `ViewModel` that contains all necessary information to represent a whole piece of UI and can be affected by a `Change` to derive a new `State` by a `Reducer`. It is an immutable class that performs no logic and can contain `ViewModels` as properties.

#### Type
Immutable Data Type

#### Kotlin Type
`State`

#### Referenced By Components
`Reducer` - Converts a provided previous `State` and a `Change` into a new `State`.
<br/>
`Presenter` - Stores the current `State` and coordinates the `State` emitted from a `Reducer` to be rendered by the `View`.
<br/>
`View` - Renders a visual representation of the `State`.

#### References Components
None

#### Naming Convention
The outer sealed class name should begin with a Screen description, end with the word `State`, and exclude any Screen monikers ("Screen", "Fragment", "Activity").
<br/>
The inner classes should be in a present tense verb manner without the `State` suffix.

#### Example
```kotlin
sealed class FeedState : State {

    object LoadingInitial : FeedState()

    data class LoadingMore(val currentItems: List<Item>) : FeedState()

    data class Refreshing(val currentItems: List<Item>) : FeedState()

    object DisplayingEmpty : FeedState()

    data class DisplayingLoaded(val items: List<Item>) : FeedState()
}
```

---

### Reducer
A `Reducer` is responsible for determining the `State` that is displayed in the UI. A `Reducer` takes the previous `State` and a `Change` and derives a new `State`. The `Reducer` performs application logic.

#### Type
Single Focus Functional Type

#### Kotlin Type
`Reducer`

#### Referenced By Components
`Presenter` - Provides a `Change` from an `Action` to the `Reducer` to derive a new `State`.

#### References Components
`State` - Derives a new `State` from a previous `State` and a `Change`.
<br/>
`Change` - Derives a new `State` from a previous `State` and a `Change`.

#### Naming Convention
A `Reducer` class should be named specifically to describe the corresponding `State`, excluding the word `State`, and ends with the word `Reducer`.

#### Example
```kotlin
class FeedReducer : Reducer<FeedState, FeedChange> {

    override suspend fun reduce(previous: FeedState, change: FeedChange): FeedState =
        when {
            change is FeedChange.Loaded && change.items.isNullOrEmpty() -> FeedState.DisplayingEmpty
            change is FeedChange.Loaded -> FeedState.DisplayingLoaded(items = change.items)
            previous is FeedState.DisplayingEmpty && change is FeedChange.StartedLoading -> FeedState.LoadingMore(
                currentItems = change.currentItems
            )
            previous is FeedState.DisplayingLoaded && change is FeedChange.StartedLoading -> FeedState.LoadingMore(
                currentItems = change.currentItems
            )
            previous is FeedState.DisplayingEmpty && change is FeedChange.StartedRefreshing -> FeedState.Refreshing(
                currentItems = change.currentItems
            )
            previous is FeedState.DisplayingLoaded && change is FeedChange.StartedRefreshing -> FeedState.Refreshing(
                currentItems = change.currentItems
            )
            else -> previous
        }
}
```

---

### View
A `View` represents a piece of UI, such as, a Screen. It provides a `Flow` of `Intents` via the `intents()` function and renders a visual representation of a `State` via the `render(state: State)` function.
Implementations of the `View` interface are responsible for mapping UI events to `Intents` and displaying `States`. Implementations may be framework components, such as, Activities and Fragments in Android.

#### Type
Functional UI Type

#### Kotlin Type
`View`

#### Referenced By Components
`Presenter` - Listens to `Intents` by subscribing to the `View.intents()` function.

#### References Components
None

#### Naming Convention
The outer sealed class name should begin with a Screen description, end with the word `State`, and exclude any Screen monikers ("Screen", "Fragment", "Activity").
<br/>
The inner classes should be in a present tense verb manner without the `State` suffix.

#### Example
```kotlin
class FeedFragment : BaseFragment<FeedIntent, FeedState, FeedChange, FeedScreen>() {

    private val loadMoreIntents: Flow<HomeIntent>
        get() = feedRecyclerView.loadMoreEvents()
            .map { FeedIntent.LoadMore(currentItems = currentState.currentItems) }

    private val refreshIntents: Flow<HomeIntent>
        get() = feedSwipeRefreshLayout.refreshes()
            .map { FeedIntent.Refresh(currentItems = currentState.currentItems) }

    override fun intents(): Flow<HomeIntent> =
        merge(
            loadMoreIntents,
            refreshIntents
        ).startWith(FeedIntent.LoadInitial)

    override fun render(state: FeedState) {
        super.render(state)

        when (state) {
            is FeedState.DisplayingEmpty -> renderEmptyState()
            is FeedState.DisplayingLoaded -> renderLoadedState(state)
            is FeedState.LoadingInitial -> renderLoadingInitial()
            is FeedState.LoadingMore -> renderLoadingMore(state)
            is FeedState.Refreshing -> renderRefreshing(state)
        }
    }
}
```

---

### Presenter
A `Presenter` handles the presentation logic for a `View`. It coordinates the different presentation components, such as, the `Actions` and the `Reducer`.

#### Type
Single Focus Functional Type

#### Kotlin Type
`Presenter`

#### Referenced By Components
None

#### References Components
`View` - Listens to `Intents` by subscribing to the `View.intents()` function and invokes the `render(state: State)` function.
<br/>
`Action` - Invokes `Actions` by providing `Intents`.
<br/>
`Reducer` - Invokes a `Reducer` by providing the current `State` and a `Change` from an `Action`.

#### Naming Convention
A `Presenter` class should be named specifically to describe the `View`, excluding the word `View`, exclude any Screen monikers ("Screen", "Fragment", "Activity"), and ends with the word `Presenter`.

#### Example
```kotlin
class FeedPresenter @Inject constructor(
    dispatchers: CoroutineDispatchers,
    override val view: View<FeedIntent, FeedState>,
    override val reducer: FeedReducer,
    private val loadInitialAction: FeedLoadInitialAction,
    private val loadMoreAction: FeedLoadMoreAction,
    private val refreshAction: FeedRefreshAction
) : BasePresenter<FeedIntent, FeedState, FeedChange>(
    initialState = FeedState.LoadingInitial,
    dispatchers = dispatchers
) {

    override fun onBind() {
        super.onBind()

        view.intents()
            .flowOn(dispatchers.main)
            .perform {
                when (it) {
                    is FeedIntent.LoadInitial -> loadInitialAction(it)
                    is FeedIntent.Refresh -> refreshAction(it)
                    is FeedIntent.LoadMore -> loadMoreAction(it)
                }
            }
            .reduceAndRender()
            .launchIn(this)
    }
}
```

---

### Mapper
A `Mapper` converts between entities and resulting classes from invoking business logic and `ViewModels`.

#### Type
Single Focus Functional Type

#### Kotlin Type
`Mapper`

#### Referenced By Components
`Action` - An `Action` invokes business logic components and maps their results to `ViewModels` and includes those in emitted `Changes`.

#### References Components
`ViewModel` - Creates `ViewModels` out of entities.

#### Naming Convention
A `Mapper` class should be named specifically to describe the types it maps, and ends with the word `Mapper`.

#### Example
```kotlin
class FeedItemMapper(private val timeFormatter: TimeFormatter) : Mapper<FeedItem, FeedItemViewModel> {

    override fun map(model: FeedItem): FeedItemViewModel =
        FeedItemViewModel(
            id = model.id,
            formattedTimestamp = timeFormatter.format(model.time),
            title = model.title,
            description = model.description,
            textColor = defaultTextColor
        )
}
```

---

### ScreenIntent
A `ScreenIntent` is similar to an `Intent` but is focused on navigation and represents a desire to load a Screen.

#### Type
Immutable Data Type

#### Kotlin Type
`ScreenIntent`

#### Referenced By Components
`Navigator` - A `Navigator` takes `ScreenIntents` and moves to the desired Screen.

#### References Components
None

#### Naming Convention
The outer sealed class name should begin with a Screen description, end with the words `ScreenIntent`.
<br/>
The inner classes should be a name of a Screen without the `ScreenIntent` suffix.

#### Example
```kotlin
sealed class HomeScreenIntent : ScreenIntent {

    object Feed : HomeScreenIntent()
}
```

---

### Navigator
A `Navigator` is responsible for changing and showing the different Screens in the application. When it receives `ScreenIntent`s from calls to the `goTo(screen: ScreenIntent)` function, it loads the appropriate Screen.

#### Type
Single Focus Functional Type

#### Kotlin Type
`Navigator`

#### Referenced By Components
None

#### References Components
`ScreenIntent` - `ScreenIntents` indicate which Screen the `Navigator` should go to.

#### Naming Convention
A `Navigator` class should be named specifically to describe the current Screen, and ends with the word `Navigator`.

**Note:** Typically, the `Navigator` and `View` implementations are the same object, in which case, the implementation class should follow the `View` naming convention.

#### Example
```kotlin
class HomeFragment() : BaseFragment<HomeIntent, HomeState, HomeChange, HomeScreenIntent>() {
    
    override fun goTo(screen: HomeScreenIntent) =
            when (screen) {
                is HomeScreenIntent.Feed -> goToFragment(FeedFragment.newInstance())
            }
}
```
