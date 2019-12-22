package com.hitanshudhawan.spannablestringparser.spanner

import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import com.hitanshudhawan.spannablestringparser.spannify
import org.junit.Assert.assertEquals
import org.junit.Test

class SpannerTest {

    @Test
    fun test001() {
        val a = "{ `Hitanshu` < color : #0000FF /> }"
        val b = a.spannify()
        val c = (b as SpannableStringBuilder).getSpans(0, b.length, Any::class.java)
        assertEquals(
            "#0000FF",
            String.format("#%06X", (0xFFFFFF and (c[0] as ForegroundColorSpan).foregroundColor))
        )
    }
}
