@file:Suppress("unused")

package com.chrynan.presentation.components.model.span

class SpannableStringBuilder : Spannable,
    Appendable {

    override val spans: List<SpanWithPosition>
        get() = mutableSpans

    override val length: Int
        get() = sb.length

    private val sb = StringBuilder()
    private val mutableSpans = mutableListOf<SpanWithPosition>()

    override fun addSpan(span: Span, startInclusive: Int, endExclusive: Int) {
        require(startInclusive < endExclusive) { "startInclusive must be less than endExclusive." }
        require(startInclusive >= 0) { "startInclusive must be greater than or equal to zero." }
        require(endExclusive <= length) { "endExclusive must be less than or equal to length." }

        val spanWithPosition = SpanWithPosition(span, startInclusive, endExclusive)

        mutableSpans.add(spanWithPosition)
    }

    override fun get(index: Int): Char = sb[index]

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence = sb.subSequence(startIndex, endIndex)

    override fun append(value: Char): Appendable = sb.append(value)

    override fun append(value: CharSequence?): Appendable = sb.append(value)

    override fun append(value: CharSequence?, startIndex: Int, endIndex: Int): Appendable =
        sb.append(value, startIndex, endIndex)

    override fun toString(): String = sb.toString()

    override fun equals(other: Any?): Boolean {
        if (other == null) return false

        if (other !is SpannableStringBuilder) return false

        return sb == other.sb && spans == other.spans
    }

    override fun hashCode(): Int = sb.hashCode() + spans.hashCode()

    fun toSpannableString(): SpannableString =
        SpannableString(
            source = this,
            initialSpans = spans
        )

    fun appendSpan(text: String, vararg spans: Span): Appendable {
        val appendable = sb.append(text)

        val startIndex = sb.length - text.length
        val endIndex = sb.length

        spans.forEach {
            addSpan(it, startIndex, endIndex)
        }

        return appendable
    }
}

fun buildSpannableString(block: SpannableStringBuilder.() -> Unit): SpannableString {
    val sb = SpannableStringBuilder()

    block.invoke(sb)

    return sb.toSpannableString()
}
