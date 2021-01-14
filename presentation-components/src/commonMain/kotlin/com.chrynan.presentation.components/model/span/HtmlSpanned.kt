@file:Suppress("unused")

package com.chrynan.presentation.components.model.span

data class HtmlSpanned(
    val value: CharSequence,
    override val spans: List<SpanWithPosition> = emptyList()
) : Spanned {

    override val length: Int
        get() = value.length

    override fun get(index: Int): Char = value[index]

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        val includedSpans = spans.filter {
            it.startInclusive >= startIndex && it.endExclusive <= endIndex
        }

        return HtmlSpanned(
            value = value.subSequence(startIndex, endIndex),
            spans = includedSpans
        )
    }
}
