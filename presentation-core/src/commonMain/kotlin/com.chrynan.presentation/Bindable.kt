package com.chrynan.presentation

/**
 * An interface for a component that can be bound to another component, typically which has a
 * lifecycle.
 */
interface Bindable {

    /**
     * Determines if this component is currently bound to the parent component.
     */
    val isBound: Boolean

    /**
     * Binds and sets up this component.
     */
    fun bind()

    /**
     * Unbinds and cleans up the resources used by this component.
     */
    fun unbind()

    companion object
}
