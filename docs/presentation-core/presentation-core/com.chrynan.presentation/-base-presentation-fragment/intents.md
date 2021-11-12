//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[BasePresentationFragment](index.md)/[intents](intents.md)

# intents

[android]\
open override fun [intents](intents.md)(): Flow&lt;[INTENT](index.md)&gt;

Provides all the [Intent](../../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md)s of type I as a Flow to the caller. These can be caused by user input events (clicks, scrolls, etc) or by other means.

Note that this function should be called from the [Presenter](../../../../presentation-core/presentation-core/com.chrynan.presentation/-presenter/index.md).
