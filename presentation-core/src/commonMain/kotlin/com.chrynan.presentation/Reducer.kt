package com.chrynan.presentation

/**
 * A [Reducer] is responsible for determining the State that is displayed in the UI. A [Reducer] is a function that
 * takes the current State and a Change and derives a new State.
 */
typealias Reducer<State, Change> = suspend State?.(Change) -> State?
