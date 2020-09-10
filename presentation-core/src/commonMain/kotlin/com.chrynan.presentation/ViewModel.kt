@file:Suppress("unused")

package com.chrynan.presentation

/**
 * Represents a model that contains the data required for a UI. Note a [State] is a [ViewModel] but a [ViewModel] isn't
 * necessarily a [State]. For instance, each item in a UI list should be represented as a [ViewModel] but it might not
 * be preferable to have it as a [State]. Instead, the [State] could represent the Screen UI and could contain the
 * list item [ViewModel]s.
 *
 * Note that a [ViewModel] should not contain any logic. A [ViewModel] is typically an immutable data class containing
 * necessary information for displaying a UI. Typically, fields shouldn't be updated or altered on a [ViewModel] but
 * instead new updated [ViewModel] objects should be created and the whole [State] should be updated with these new
 * objects. This way it conforms to the uni-directional paradigm.
 *
 * Note that there is some terminology conflation between this class "ViewModel" and components in other popular
 * frameworks and design patterns, such as, the Android Architecture Component's "ViewModel" class. Here a [ViewModel]
 * should perform no logic, and just be a model representation of a UI.
 */
interface ViewModel {

    /**
     * A unique identifier for this [ViewModel]. This allows it to be distinguished between other [ViewModel]s, perhaps
     * within a list. This defaults to the [hashCode] converted to a [Long] value.
     */
    val uniqueId: Long
        get() = hashCode().toLong()
}

/**
 * A convenience function for converting any type into a [Long] value for use as a [ViewModel.uniqueId].
 */
inline fun <reified T : Any> T.asUniqueId() = hashCode().toLong()
