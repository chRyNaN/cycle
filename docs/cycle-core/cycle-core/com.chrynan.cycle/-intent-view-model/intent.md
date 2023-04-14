//[cycle-core](../../../index.md)/[com.chrynan.cycle](../index.md)/[IntentViewModel](index.md)/[intent](intent.md)

# intent

[common]\
fun [intent](intent.md)(to: [Intent](index.md))

Triggers the invocation of the [Action](../index.md#-1083546810%2FClasslikes%2F1627176608) associated with the provided [to](index.md). This may result in a changes to the current [State](index.md).

**Note:** This function looks similar to the [dispatch](../../../../cycle-core/com.chrynan.cycle/-intent-view-model/dispatch.md) function, but that function emits a [Change](index.md) which will be reduced to create a new [State](index.md), whereas, this [intent](intent.md) function emits an [Intent](index.md) which triggers an associated [Action](../index.md#-1083546810%2FClasslikes%2F1627176608) to produce a [Change](index.md) (which then will be reduced to create a new [State](index.md)). This function is more similar to the [perform](../../../../cycle-core/com.chrynan.cycle/-intent-view-model/perform.md) function, but instead of performing the action at the call-site, this [intent](intent.md) function just triggers the associated [Action](../index.md#-1083546810%2FClasslikes%2F1627176608) which is encapsulated in the [IntentViewModel](index.md) implementation.
