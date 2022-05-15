//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[ViewData](index.md)

# ViewData

[common]\
interface [ViewData](index.md)

Represents a model that contains the data required for a UI. Note a [State](../-state/index.md) is a [ViewData](index.md) but a [ViewData](index.md) isn't necessarily a [State](../-state/index.md). For instance, each item in a UI list should be represented as a [ViewData](index.md) but it might not be preferable to have it as a [State](../-state/index.md). Instead, the [State](../-state/index.md) could represent the Screen UI and could contain the list item [ViewData](index.md)s.

Note that a [ViewData](index.md) should not contain any logic. A [ViewData](index.md) is typically an immutable data class containing necessary information for displaying a UI. Typically, fields shouldn't be updated or altered on a [ViewData](index.md) but instead new updated [ViewData](index.md) objects should be created and the whole [State](../-state/index.md) should be updated with these new objects. This way it conforms to the uni-directional paradigm.

Note that there is some terminology conflation between this class "ViewData" and the [ViewModel](../-view-model/index.md) class. Here a [ViewData](index.md) should perform no logic, and just be a model representation of a UI.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [uniqueId](unique-id.md) | [common]<br>open val [uniqueId](unique-id.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>A unique identifier for this [ViewData](index.md). This allows it to be distinguished between other [ViewData](index.md)s, perhaps within a list. This defaults to the [hashCode](../../../../presentation-core/com.chrynan.presentation/-view-data/hash-code.md) converted to a [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) value. |

## Inheritors

| Name |
|---|
| [State](../-state/index.md) |
