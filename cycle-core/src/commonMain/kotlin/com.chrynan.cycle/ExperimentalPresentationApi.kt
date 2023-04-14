package com.chrynan.cycle

/**
 * The annotated component represents an experimental presentation API and may change or be removed in the future.
 */
@RequiresOptIn(
    message = "This component is experimental and may change or be removed in the future.",
    level = RequiresOptIn.Level.WARNING
)
@MustBeDocumented
annotation class ExperimentalPresentationApi
