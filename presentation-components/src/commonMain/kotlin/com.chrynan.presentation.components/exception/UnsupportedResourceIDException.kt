@file:Suppress("unused")

package com.chrynan.presentation.components.exception

import com.chrynan.presentation.components.model.ResourceID

/**
 * An Exception that can be thrown indicating that the provided [ResourceID] type is unsupported on the
 * current platform.
 *
 * @see [ResourceID]
 */
class UnsupportedResourceIDException(
    resourceID: ResourceID,
    message: String? = null
) : RuntimeException("The resourceID type for $resourceID is unsupported by this target platform. ${message ?: ""}")
