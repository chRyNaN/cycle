package com.chrynan.presentation.compose

@RequiresOptIn(
    level = RequiresOptIn.Level.WARNING
)
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY
)
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
annotation class PresentationComposeExperimentalApi
