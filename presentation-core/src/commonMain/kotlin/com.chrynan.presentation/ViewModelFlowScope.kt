@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

interface ViewModelFlowScope<I : Intent, S : State, C : Change> {

    @FlowPreview
    fun Flow<I>.performWith(
        strategy: FlatMapStrategy = FlatMapStrategy.Latest,
        action: Action<I, S, C>
    ): Flow<C>

    @FlowPreview
    fun Flow<I>.perform(
        strategy: FlatMapStrategy = FlatMapStrategy.Latest,
        action: suspend (I, S?) -> Flow<C>
    ): Flow<C>

    fun Flow<C>.reduceWith(reducer: Reducer<S, C>): Flow<S?>

    fun Flow<C>.reduce(reducer: suspend (S?, C) -> S?): Flow<S?>

    fun Flow<S?>.startWithInitialState(): Flow<S?>

    fun Flow<S?>.render(): Flow<S?>
}
