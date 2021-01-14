package com.chrynan.presentation.components.model.span

interface Spannable : Spanned {

    fun addSpan(span: Span, startInclusive: Int, endExclusive: Int)
}
