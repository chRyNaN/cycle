//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Bindable](index.md)

# Bindable

[common]\
interface [Bindable](index.md)

An interface for a component that can be bound to another component, typically which has a lifecycle.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | [common]<br>abstract fun [bind](bind.md)()<br>Binds and sets up this component. |
| [unbind](unbind.md) | [common]<br>abstract fun [unbind](unbind.md)()<br>Unbinds and cleans up the resources used by this component. |

## Properties

| Name | Summary |
|---|---|
| [isBound](is-bound.md) | [common]<br>abstract val [isBound](is-bound.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if this component is currently bound to the parent component. |

## Inheritors

| Name |
|---|
| [Presenter](../-presenter/index.md) |
