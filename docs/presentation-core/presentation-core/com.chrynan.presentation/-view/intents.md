//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[View](index.md)/[intents](intents.md)

# intents

[common]\
abstract fun [intents](intents.md)(): Flow&lt;[I](index.md)&gt;

Provides all the [Intent](../-intent/index.md)s of type [I](index.md) as a Flow to the caller. These can be caused by user input events (clicks, scrolls, etc) or by other means.

Note that this function should be called from the [Presenter](../-presenter/index.md).
