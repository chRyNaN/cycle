package com.chrynan.presentation.compose

import com.chrynan.presentation.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

enum class CounterIntent {

    INCREMENT,
    DECREMENT,
    INCREMENT_IF_LESS_THAN_TWO
}

enum class CounterChange {

    INCREMENTED,
    DECREMENTED,
    NO_CHANGE
}

fun counterReducer(state: Int?, change: CounterChange): Int {
    val value = state ?: 0

    return when (change) {
        CounterChange.INCREMENTED -> value + 1
        CounterChange.DECREMENTED -> value - 1
        CounterChange.NO_CHANGE -> value
    }
}

@ExperimentalCoroutinesApi
@FlowPreview
class CounterViewModel : IntentViewModel<CounterIntent, Int, CounterChange>(
    stateStore = MutableStateStore(reducer = ::counterReducer)
) {

    override fun performIntentAction(state: Int?, intent: CounterIntent): Flow<CounterChange> = flow {
        val change = when (intent) {
            CounterIntent.INCREMENT -> CounterChange.INCREMENTED
            CounterIntent.INCREMENT_IF_LESS_THAN_TWO -> CounterChange.NO_CHANGE
            CounterIntent.DECREMENT -> CounterChange.DECREMENTED
        }

        emit(change)
    }
}

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
fun testCounter(coroutineScope: CoroutineScope) {
    val viewModel = CounterViewModel()

    viewModel.subscribe(coroutineScope = coroutineScope) { state ->
        println(state)
    }

    // Note: The dispatch function is no longer public, so we can't access it here.
    viewModel.intent(to = CounterIntent.INCREMENT) // 1
    viewModel.intent(to = CounterIntent.INCREMENT) // 2
    viewModel.intent(to = CounterIntent.DECREMENT) // 1

    // Note: The perform function is no longer public, so we can't access it here.
    viewModel.intent(to = CounterIntent.INCREMENT_IF_LESS_THAN_TWO)
}
