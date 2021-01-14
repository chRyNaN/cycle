@file:Suppress("unused")

package com.chrynan.presentation.components.android.span

import android.text.Spanned
import android.text.SpannedString
import androidx.core.text.getSpans
import androidx.core.text.parseAsHtml
import com.chrynan.presentation.components.model.span.HtmlSpanned
import com.chrynan.presentation.components.model.span.SpanWithPosition

fun CharSequence.toAndroidSpanned(): Spanned =
    when {
        this is Spanned -> this
        this is HtmlSpanned && value is Spanned -> value as Spanned
        this is HtmlSpanned -> SpannedString(value)
        else -> SpannedString(this)
    }

fun CharSequence.toHtmlSpanned(): HtmlSpanned =
    if (this is HtmlSpanned) {
        this
    } else {
        val androidSpanned = this.toString().parseAsHtml().trimTrailingWhitespace()
        HtmlSpanned(
            value = androidSpanned,
            spans = androidSpanned.getSpansWithPosition()
        )
    }

fun Spanned.getSpansWithPosition(): List<SpanWithPosition> =
    getSpans<Any>(0, length).map {
        SpanWithPosition(
            span = AndroidSpan(it),
            startInclusive = getSpanStart(it),
            endExclusive = getSpanEnd(it)
        )
    }

fun Spanned.trimTrailingWhitespace(): Spanned {
    var i = length
    do {
        i--
    } while (i >= 0 && get(i).isWhitespace())

    return subSequence(0, i + 1) as Spanned
}
