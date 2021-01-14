package com.chrynan.presentation.components.model.span

data class SpanWithPosition(
    val span: Span,
    val startInclusive: Int,
    val endExclusive: Int
)
