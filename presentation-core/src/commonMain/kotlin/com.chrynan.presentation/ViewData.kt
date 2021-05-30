@file:Suppress("unused")

package com.chrynan.presentation

/**
 * Represents a model that contains the data required for a UI. Note a [State] is a [ViewData] but a [ViewData] isn't
 * necessarily a [State]. For instance, each item in a UI list should be represented as a [ViewData] but it might not
 * be preferable to have it as a [State]. Instead, the [State] could represent the Screen UI and could contain the
 * list item [ViewData]s.
 *
 * Note that a [ViewData] should not contain any logic. A [ViewData] is typically an immutable data class containing
 * necessary information for displaying a UI. Typically, fields shouldn't be updated or altered on a [ViewData] but
 * instead new updated [ViewData] objects should be created and the whole [State] should be updated with these new
 * objects. This way it conforms to the uni-directional paradigm.
 *
 * Note that there is some terminology conflation between this class "ViewData" and components in other popular
 * frameworks and design patterns, such as, the Android Architecture Component's "ViewModel" class. Here a [ViewData]
 * should perform no logic, and just be a model representation of a UI.
 */
interface ViewData {

    /**
     * A unique identifier for this [ViewData]. This allows it to be distinguished between other [ViewData]s, perhaps
     * within a list. This defaults to the [hashCode] converted to a [Long] value.
     */
    val uniqueId: Long
        get() = hashCode().toLong()

    companion object
}

/**
 * A convenience function for converting any type into a [Long] value for use as a [ViewData.uniqueId].
 */
inline fun <reified T : Any> T.asUniqueId() = hashCode().toLong()
