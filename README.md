![presentation](assets/branding_image.png)

# presentation

Kotlin multi-platform presentation layer design pattern. This is a uni-directional data flow (UDF) design pattern
library that is closely related to the MVI (Model-View-Intent) pattern on Android. It utilizes kotlinx.coroutines Flows
and is easily compatible with modern UI Frameworks, such as Jetpack Compose.

### Perform > Reduce > Compose

<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/chRyNaN/presentation">

```kotlin
@Composable
fun Home(viewModel: HomeViewModel) {
    val state by viewModel.stateChanges()

    when (state) {
        is HomeState.Loading -> {
            CircularProgressIndicator()
        }
        is HomeState.Loaded -> {
            Text("Hello ${state.name}")
        }
    }
}
```

## Getting Started 🏁

The library is provided through [Repsy.io](https://repsy.io/). Checkout the
[releases page](https://github.com/chRyNaN/presentation/releases) to get the latest version. <br/><br/>
<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/chRyNaN/presentation">

### Repository

```kotlin
repositories {
    maven {
        url = uri("https://repo.repsy.io/mvn/chrynan/public")
    }
}
```

### Dependencies

#### core

```kotlin
implementation("com.chrynan.presentation:presentation-core:$VERSION")
```

#### compose

```kotlin
implementation("com.chrynan.presentation:presentation-compose:$VERSION")
```

#### processor

```kotlin
ksp("com.chrynan.presentation:presentation-ksp:$VERSION")
```

**Note:** This dependency requires you setup the [KSP plugin](https://kotlinlang.org/docs/ksp-quickstart.html).

```kotlin
plugins {
    id("com.google.devtools.ksp") version "1.8.10-1.0.9"
}
```

**Note:** It may be required
to [add the generated sources](https://kotlinlang.org/docs/ksp-quickstart.html#make-ide-aware-of-generated-code) of the
KSP processor for the IDE to recognize the generated code and resources. The following is an example of adding the
generated sources for a Kotlin JVM project:

```kotlin
kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
        resources.srcDir("build/generated/ksp/main/resources/")
    }
}
```

## Usage 👨‍💻

### State Definition

Define your state models for a component with a sealed class or interface that inherits from the `State` interface:

```kotlin
sealed class HomeState : State {

    abstract val items: List<Item>

    data class Loading(override val items: List<ListItem> = emptyList()) : HomeState()

    data class Refreshing(override val items: List<ListItem> = emptyList()) : HomeState()

    data class Success(override val items: List<Item>) : HomeState()

    data class Error(
        override val items: List<ListItem> = emptyList(),
        val message: String
    )
}
```

### Perform

All application logic related to a `State` is encapsulated in separate functions for each responsibility that are
annotated with `@Perform`. These functions can be member functions of a class or interface (such as an `Action`), or
they can be globally scoped functions. The functions can optionally have an extension receiver of the state model which
represents the current state. The return type of these functions can be any value except for `Unit` and `Nothing`; you
can even return a `Flow` of items!

```kotlin
@Perform(HomeState::class)
fun HomeState.loadMoreItems(count: UInt = 25): Flow<HomeChange> =
    flow {
        emit(HomeChange.StartedLoading)

        val items = ItemRepo().get(after = this.items.lastOrNull()?.id, count = count)

        emit(HomeChange.FinishedLoading(items = items))
    }
```

### Reduce

For every `@Perform` annotated function return type, there must be a corresponding `@Reduce` annotated function.
Functions annotated with `@Reduce` are responsible for creating new `States` from the previous `State` and the value
returned from a `@Perform` annotated function.

```kotlin
@Reduce(HomeState::class)
fun HomeState.reduce(change: HomeChange): HomeState =
    when (change) {
        is HomeChange.StartedLoading -> HomeState.Loading(items = this.items)
        is HomeChange.FinishedLoading -> HomeState.Success(items = this.items)
    }
```

### Compose

The `@Perform` and `@Reduce` annotated functions associated with a `State` cause the auto-generation of a `ViewModel`
that can be instantiated and whose state changes can be observed within a Jetpack Compose composable function:

```kotlin
@Composable
fun Home(viewModel: HomeViewModel = HomeViewModel()) {
    val state = viewModel.stateChanges()
    val lazyListState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = lazyListState
    ) {
        items(
            items = state.items,
            key = { it.value.id }
        ) { item ->
            ItemLayout(item)
        }
    }

    LaunchLazyLoader(
        state = lazyListState,
        onLoadMore = {
            viewModel.loadMoreItems()
        }
    )
}
```

## Documentation 📃

More detailed documentation is available in the [docs](docs/) folder. The entry point to the documentation can be
found [here](docs/index.md).

## Security 🛡️

For security vulnerabilities, concerns, or issues, please responsibly disclose the information either by opening a
public GitHub Issue or reaching out to the project owner.

## Contributing ✍️

Outside contributions are welcome for this project. Please follow the [code of conduct](CODE_OF_CONDUCT.md)
and [coding conventions](CODING_CONVENTIONS.md) when contributing. If contributing code, please add thorough documents.
and tests. Thank you!

## Sponsorship ❤️

Support this project by [becoming a sponsor](https://www.buymeacoffee.com/chrynan) of my work! And make sure to give the
repository a ⭐

## License ⚖️

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
