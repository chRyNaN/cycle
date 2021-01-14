package com.chrynan.presentation.components.model.span

interface Spanned : ParsedSpanContent {

    val spans: List<SpanWithPosition>
}
