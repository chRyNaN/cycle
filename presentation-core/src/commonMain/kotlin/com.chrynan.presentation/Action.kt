@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat

/**
 * An [Action] performs the function of converting an [Intent] of type [I] into a [Change] of type [C]. Unlike other
 * components, such as, [Intent]s and [Change]s, [Action]s are not model classes and actually perform logic. They are
 * responsible for connecting to the business logic.
 *
 * Note, however, that [Action]s shouldn't perform business logic themselves as they are still application logic
 * components. Instead, the business logic should be handled in UseCases and Repositories and the like. The [Action] is
 * what connects the business and application logic. It has reference to the business logic classes and invokes the
 * appropriate functions and performs application logic on top of that to coerce the returned values into application
 * layer components ([ViewModel]s, [Change]s, etc).
 *
 * It's common, though not required, to have [Action]s be single focused and perform a single task. For instance, if
 * there are [Intent]s to "Load" and "Refresh", those should be handled in separate [Action]s. Then there could either
 * be a wrapper [Action] that properly delegates to the correct one depending on the [Intent], or that logic could
 * simply be handled with a Kotlin "when" condition inside the [perform] function.
 */
interface Action<I : Intent, C : Change> {

    /**
     * Converts the provided [intent] of type [I] into a [Flow] of type [C]. This means an [Intent] can cause multiple
     * [Change]s to be emitted ("StartedLoading", "FinishedLoading", etc).
     */
    fun perform(intent: I): Flow<C>

    /**
     * A convenience function that delegates to [perform] allowing the [Action] to be invoked like a function.
     */
    operator fun invoke(intent: I): Flow<C> = perform(intent)
}

/**
 * Converts this [Flow] of [Intent]s of type [I] into a [Flow] of [Change]s of type [C] using the provided [action].
 */
@OptIn(FlowPreview::class)
fun <I : Intent, C : Change> Flow<I>.perform(action: Action<I, C>): Flow<C> =
    flatMapConcat { action(it) }

/**
 * Converts this [Flow] of [Intent]s of type [I] into a [Flow] of [Change]s of type [C] using the provided [action]
 * function.
 */
@OptIn(FlowPreview::class)
fun <I : Intent, C : Change> Flow<I>.perform(action: (I) -> Flow<C>): Flow<C> =
    flatMapConcat { action(it) }
