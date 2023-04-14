@file:Suppress("unused")

package com.chrynan.cycle

import kotlinx.coroutines.flow.Flow

/**
 * An [Action] is a function that performs application logic to produce a [Flow] of Changes. These changes are then
 * provided to a [Reducer] to produce new states. An [Action] takes the current state and returns a [Flow] of changes
 * to that State.
 */
typealias Action<State, Change> = suspend State?.() -> Flow<Change>
