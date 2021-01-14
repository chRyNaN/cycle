@file:Suppress("unused")

package com.chrynan.presentation.components.model.span

class SpannableString internal constructor(
    private val source: CharSequence,
    initialSpans: List<SpanWithPosition> = emptyList()
) : Spannable {

    override val spans: List<SpanWithPosition>
        get() = mutableSpans

    override val length: Int
        get() = source.length

    private val mutableSpans = mutableListOf<SpanWithPosition>()

    init {
        mutableSpans.addAll(initialSpans)
    }

    override fun addSpan(span: Span, startInclusive: Int, endExclusive: Int) {
        require(startInclusive < endExclusive) { "startInclusive must be less than endExclusive." }
        require(startInclusive >= 0) { "startInclusive must be greater than or equal to zero." }
        require(endExclusive <= length) { "endExclusive must be less than or equal to length." }

        val spanWithPosition = SpanWithPosition(span, startInclusive, endExclusive)

        mutableSpans.add(spanWithPosition)
    }

    override fun get(index: Int): Char = source[index]

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence = source.subSequence(startIndex, endIndex)

    override fun equals(other: Any?): Boolean {
        if (other == null) return false

        if (other !is SpannableString) return false

        return source == other.source && spans == other.spans
    }

    override fun hashCode(): Int = source.hashCode() + spans.hashCode()

    override fun toString(): String = source.toString()
}

fun CharSequence.toSpannableString(): SpannableString = SpannableString(this)
