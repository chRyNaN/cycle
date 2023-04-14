//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[BaseViewModel](index.md)/[performSingle](perform-single.md)

# performSingle

[common]\
open override fun [performSingle](perform-single.md)(action: suspend [State](index.md)?.() -&gt; [Change](index.md))

Triggers the invocation of the provided [action](perform-single.md) which results in the [action](perform-single.md)'s [Change](index.md) being reduced and producing a new [State](index.md). This function differs from the [ViewModel.perform](../../../../cycle-core/com.chrynan.cycle/-view-model/perform.md) function in that the provided [action](perform-single.md) only returns a single [Change](index.md), whereas the [ViewModel.perform](../../../../cycle-core/com.chrynan.cycle/-view-model/perform.md) function returns a Flow of [Change](index.md)s.
