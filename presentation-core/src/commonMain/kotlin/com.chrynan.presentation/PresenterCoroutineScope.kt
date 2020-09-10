package com.chrynan.presentation

import kotlinx.coroutines.CoroutineScope

/**
 * A [CoroutineScope] for use within a [Presenter].
 *
 * Note that this scope shouldn't be used outside of the [Presenter]. For instance, if the [Presenter] implements this
 * interface, a class that has access to the [Presenter] should not use it as a [CoroutineScope], instead it should
 * create it's own [CoroutineScope] for use within its lifecycle.
 */
interface PresenterCoroutineScope : CoroutineScope
