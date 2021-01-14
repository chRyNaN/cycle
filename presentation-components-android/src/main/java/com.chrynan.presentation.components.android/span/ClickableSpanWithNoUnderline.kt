@file:Suppress("unused")

package com.chrynan.presentation.components.android.span

import android.text.TextPaint
import android.text.style.ClickableSpan

abstract class ClickableSpanWithNoUnderline : ClickableSpan() {

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)

        ds.isUnderlineText = false
    }
}
