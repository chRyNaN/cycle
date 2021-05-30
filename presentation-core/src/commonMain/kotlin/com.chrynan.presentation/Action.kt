@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.flow.Flow

/**
 * An [Action] performs the function of converting an [Intent] of type [I] into a [Change] of type [C]. Unlike other
 * components, such as, [Intent]s and [Change]s, [Action]s are not model classes and actually perform logic. They are
 * responsible for connecting to the business logic.
 *
 * Note, however, that [Action]s shouldn't perform business logic themselves as they are still application logic
 * components. Instead, the business logic should be handled in UseCases and Repositories and the like. The [Action] is
 * what connects the business and application logic. It has reference to the business logic classes and invokes the
 * appropriate functions and performs application logic on top of that to coerce the returned values into application
 * layer components ([ViewData]s, [Change]s, etc).
 *
 * It's common, though not required, to have [Action]s be single focused and perform a single task. For instance, if
 * there are [Intent]s to "Load" and "Refresh", those should be handled in separate [Action]s. Then there could either
 * be a wrapper [Action] that properly delegates to the correct one depending on the [Intent], or that logic could
 * simply be handled with a Kotlin "when" condition inside the [perform] function.
 */
interface Action<I : Intent, S : State, C : Change> {

    /**
     * Converts the provided [intent] of type [I] into a [Flow] of type [C]. This means an [Intent] can cause multiple
     * [Change]s to be emitted ("StartedLoading", "FinishedLoading", etc).
     *
     * @param [intent] The intent to perform an [Action].
     * @param [state] The current state being displayed.
     */
    fun perform(intent: I, state: S?): Flow<C>

    companion object
}

/**
 * A convenience function that delegates to [Action.perform] allowing the [Action] to be invoked like a function.
 */
operator fun <I : Intent, S : State, C : Change> Action<I, S, C>.invoke(
    intent: I,
    state: S?
): Flow<C> = perform(intent, state)
