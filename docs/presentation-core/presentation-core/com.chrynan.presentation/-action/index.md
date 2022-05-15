//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Action](index.md)

# Action

[common]\
interface [Action](index.md)&lt;[I](index.md) : [Intent](../-intent/index.md), [S](index.md) : [State](../-state/index.md), [C](index.md) : [Change](../-change/index.md)&gt;

An [Action](index.md) performs the function of converting an [Intent](../-intent/index.md) of type [I](index.md) into a Flow of [Change](../-change/index.md)s of type [C](index.md). Unlike other components, such as, [Intent](../-intent/index.md)s and [Change](../-change/index.md)s, [Action](index.md)s are not model classes and actually perform logic. They are responsible for connecting to the business logic.

Note, however, that [Action](index.md)s shouldn't perform business logic themselves as they are still application logic components. Instead, the business logic should be handled in UseCases and Repositories and the like. The [Action](index.md) is what connects the business and application logic. It has reference to the business logic classes and invokes the appropriate functions and performs application logic on top of that to coerce the returned values into application layer components ([ViewData](../-view-data/index.md)s, [Change](../-change/index.md)s, etc).

It's common, though not required, to have [Action](index.md)s be single focused and perform a single task. For instance, if there are [Intent](../-intent/index.md)s to "Load" and "Refresh", those should be handled in separate [Action](index.md)s. Then there could either be a wrapper [Action](index.md) that properly delegates to the correct one depending on the [Intent](../-intent/index.md), or that logic could simply be handled with a Kotlin "when" condition inside the [perform](perform.md) function.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [perform](perform.md) | [common]<br>abstract suspend fun [perform](perform.md)(intent: [I](index.md), state: [S](index.md)?): Flow&lt;[C](index.md)&gt;<br>Converts the provided [intent](perform.md) of type [I](index.md) into a Flow of type [C](index.md). This means an [Intent](../-intent/index.md) can cause multiple [Change](../-change/index.md)s to be emitted ("StartedLoading", "FinishedLoading", etc). |

## Extensions

| Name | Summary |
|---|---|
| [invoke](../invoke.md) | [common]<br>suspend operator fun &lt;[I](../invoke.md) : [Intent](../-intent/index.md), [S](../invoke.md) : [State](../-state/index.md), [C](../invoke.md) : [Change](../-change/index.md)&gt; [Action](index.md)&lt;[I](../invoke.md), [S](../invoke.md), [C](../invoke.md)&gt;.[invoke](../invoke.md)(intent: [I](../invoke.md), state: [S](../invoke.md)?): Flow&lt;[C](../invoke.md)&gt;<br>A convenience function that delegates to [Action.perform](perform.md) allowing the [Action](index.md) to be invoked like a function. |
