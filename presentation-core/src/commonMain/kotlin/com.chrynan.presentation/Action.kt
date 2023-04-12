@file:Suppress("unused")

package com.chrynan.presentation

import kotlinx.coroutines.flow.Flow

/**
 * An [Action] performs the function of converting an [Intent] of type [I] into a [Flow] of [Change]s of type [C].
 * Unlike other components, such as, [Intent]s and [Change]s, [Action]s are not model classes and actually perform
 * logic. They are responsible for connecting to the business logic.
 *
 * Note, however, that [Action]s shouldn't perform business logic themselves as they are still application logic
 * components. Instead, the business logic should be handled in UseCases and Repositories and the like. The [Action] is
 * what connects the business and application logic. It has reference to the business logic classes and invokes the
 * appropriate functions and performs application logic on top of that to coerce the returned values into application
 * layer components ([ViewData]s, [Change]s, etc).
 */
typealias Action<State, Change> = suspend State?.() -> Flow<Change>
