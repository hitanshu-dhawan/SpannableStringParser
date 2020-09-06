package com.hitanshudhawan.spannablestringparser.spanner

import android.graphics.Color
import android.graphics.Typeface
import android.text.Layout
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.AlignmentSpan
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.LineBackgroundSpan
import android.text.style.LineHeightSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import android.text.style.SubscriptSpan
import android.text.style.SuperscriptSpan
import android.text.style.TypefaceSpan
import android.text.style.URLSpan
import android.text.style.UnderlineSpan
import com.hitanshudhawan.spannablestringparser.spanner
import com.hitanshudhawan.spannablestringparser.spannify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(minSdk = 14, maxSdk = 29)
@RunWith(RobolectricTestRunner::class)
internal class SpannerTest {

    @Test
    fun `text-color 001`() {
        val string = "{ `Hitanshu` < text-color : #0000FF /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Color.parseColor("#0000FF"), (spans1[0] as ForegroundColorSpan).foregroundColor)
        }
    }

    @Test
    fun `text-color 002`() {
        val string = "{ `Hitanshu` < text-color : #AA0000FF /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Color.parseColor("#AA0000FF"), (spans1[0] as ForegroundColorSpan).foregroundColor)
        }
    }

    @Test
    fun `text-color 003`() {
        val string = "Hello { `Hitanshu` < text-color : #0000FF /> } Dhawan"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hello Hitanshu Dhawan", spannable.toString())

            val spans1 = spannable.getSpans(queryStart = 0, queryEnd = 6)
            assertTrue(spans1.isEmpty())
            val spans2 = spannable.getSpans(queryStart = 6, queryEnd = 14)
            assertTrue(spans2.size == 1)
            assertEquals(Color.parseColor("#0000FF"), (spans2[0] as ForegroundColorSpan).foregroundColor)
            val spans3 = spannable.getSpans(queryStart = 14, queryEnd = length)
            assertTrue(spans3.isEmpty())
        }
    }

    @Test
    fun `background-color 001`() {
        val string = "{ `Hitanshu` < background-color : #0000FF /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Color.parseColor("#0000FF"), (spans1[0] as BackgroundColorSpan).backgroundColor)
        }
    }

    @Test
    fun `background-color 002`() {
        val string = "{ `Hitanshu` < background-color : #AA0000FF /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Color.parseColor("#AA0000FF"), (spans1[0] as BackgroundColorSpan).backgroundColor)
        }
    }

    @Test
    fun `background-color 003`() {
        val string = "Hello { `Hitanshu` < background-color : #0000FF /> } Dhawan"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hello Hitanshu Dhawan", spannable.toString())

            val spans1 = spannable.getSpans(queryStart = 0, queryEnd = 6)
            assertTrue(spans1.isEmpty())
            val spans2 = spannable.getSpans(queryStart = 6, queryEnd = 14)
            assertTrue(spans2.size == 1)
            assertEquals(Color.parseColor("#0000FF"), (spans2[0] as BackgroundColorSpan).backgroundColor)
            val spans3 = spannable.getSpans(queryStart = 14, queryEnd = length)
            assertTrue(spans3.isEmpty())
        }
    }

    @Test
    @Config(minSdk = 29, maxSdk = 29)
    fun `line-background-color 001`() {
        val string = "{ `Hitanshu` < line-background-color : #0000FF /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Color.parseColor("#0000FF"), (spans1[0] as LineBackgroundSpan.Standard).color)
        }
    }

    @Test
    @Config(minSdk = 29, maxSdk = 29)
    fun `line-background-color 002`() {
        val string = "{ `Hitanshu` < line-background-color : #AA0000FF /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Color.parseColor("#AA0000FF"), (spans1[0] as LineBackgroundSpan.Standard).color)
        }
    }

    @Test
    @Config(minSdk = 29, maxSdk = 29)
    fun `line-background-color 003`() {
        val string = "Hello { `Hitanshu` < line-background-color : #0000FF /> } Dhawan"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hello Hitanshu Dhawan", spannable.toString())

            val spans1 = spannable.getSpans(queryStart = 0, queryEnd = 6)
            assertTrue(spans1.isEmpty())
            val spans2 = spannable.getSpans(queryStart = 6, queryEnd = 14)
            assertTrue(spans2.size == 1)
            assertEquals(Color.parseColor("#0000FF"), (spans2[0] as LineBackgroundSpan.Standard).color)
            val spans3 = spannable.getSpans(queryStart = 14, queryEnd = length)
            assertTrue(spans3.isEmpty())
        }
    }

    @Test
    @Config(minSdk = 14, maxSdk = 28)
    fun `line-background-color 004`() {
        val string = "{ `Hitanshu` < line-background-color : #0000FF /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    fun `text-size 001`() {
        val string = "{ `Hitanshu` < text-size : 16dp /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(16, (spans1[0] as AbsoluteSizeSpan).size)
            assertTrue((spans1[0] as AbsoluteSizeSpan).dip)
        }
    }

    @Test
    fun `text-size 002`() {
        val string = "{ `Hitanshu` < text-size : 1.5em /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(1.5F, (spans1[0] as RelativeSizeSpan).sizeChange)
        }
    }

    @Test
    fun `text-size 003`() {
        val string = "{ `Hitanshu` < text-size : 16px /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(16, (spans1[0] as AbsoluteSizeSpan).size)
            assertFalse((spans1[0] as AbsoluteSizeSpan).dip)
        }
    }

    @Test
    fun `text-size 004`() {
        val string = "{ `Hitanshu` < text-size : random-value /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    fun `text-size 005`() {
        val string = "{ `Hitanshu` < text-size : 16sdp /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    fun `text-size 006`() {
        val string = "{ `Hitanshu` < text-size : 1.5sem /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    fun `text-size 007`() {
        val string = "{ `Hitanshu` < text-size : 16spx /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    fun `text-decoration 001`() {
        val string = "{ `Hitanshu` < text-decoration : underline /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertTrue(spans1[0] is UnderlineSpan)
        }
    }

    @Test
    fun `text-decoration 002`() {
        val string = "{ `Hitanshu` < text-decoration : strike-through /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertTrue(spans1[0] is StrikethroughSpan)
        }
    }

    @Test
    fun `text-decoration 003`() {
        val string = "Hello { `Hitanshu` < text-decoration : underline /> } Dhawan"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hello Hitanshu Dhawan", spannable.toString())

            val spans1 = spannable.getSpans(queryStart = 0, queryEnd = 6)
            assertTrue(spans1.isEmpty())
            val spans2 = spannable.getSpans(queryStart = 6, queryEnd = 14)
            assertTrue(spans2.size == 1)
            assertTrue(spans2[0] is UnderlineSpan)
            val spans3 = spannable.getSpans(queryStart = 14, queryEnd = length)
            assertTrue(spans3.isEmpty())
        }
    }

    @Test
    fun `text-decoration 004`() {
        val string = "Hello { `Hitanshu` < text-decoration : strike-through /> } Dhawan"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hello Hitanshu Dhawan", spannable.toString())

            val spans1 = spannable.getSpans(queryStart = 0, queryEnd = 6)
            assertTrue(spans1.isEmpty())
            val spans2 = spannable.getSpans(queryStart = 6, queryEnd = 14)
            assertTrue(spans2.size == 1)
            assertTrue(spans2[0] is StrikethroughSpan)
            val spans3 = spannable.getSpans(queryStart = 14, queryEnd = length)
            assertTrue(spans3.isEmpty())
        }
    }

    @Test
    fun `text-decoration 005`() {
        val string = "{ `Hitanshu` < text-decoration : random-value /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    fun `subscript 001`() {
        val string = "a{`2`<subscript:true/>} + b{`2`<subscript:true/>} = c{`2`<subscript:true/>}"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("a2 + b2 = c2", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 3)
            assertTrue(spans1[0] is SubscriptSpan)
            assertEquals(1, spannable.getSpanStart(spans1[0]))
            assertEquals(2, spannable.getSpanEnd(spans1[0]))
            assertTrue(spans1[1] is SubscriptSpan)
            assertEquals(6, spannable.getSpanStart(spans1[1]))
            assertEquals(7, spannable.getSpanEnd(spans1[1]))
            assertTrue(spans1[2] is SubscriptSpan)
            assertEquals(11, spannable.getSpanStart(spans1[2]))
            assertEquals(12, spannable.getSpanEnd(spans1[2]))
        }
    }

    @Test
    fun `subscript 002`() {
        val string = "a{`2`<subscript:true/>} + b{`2`<subscript:true/>} = c{`2`<subscript:false/>}"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("a2 + b2 = c2", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 2)
            assertTrue(spans1[0] is SubscriptSpan)
            assertEquals(1, spannable.getSpanStart(spans1[0]))
            assertEquals(2, spannable.getSpanEnd(spans1[0]))
            assertTrue(spans1[1] is SubscriptSpan)
            assertEquals(6, spannable.getSpanStart(spans1[1]))
            assertEquals(7, spannable.getSpanEnd(spans1[1]))
        }
    }

    @Test
    fun `superscript 001`() {
        val string = "a{`2`<superscript:true/>} + b{`2`<superscript:true/>} = c{`2`<superscript:true/>}"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("a2 + b2 = c2", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 3)
            assertTrue(spans1[0] is SuperscriptSpan)
            assertEquals(1, spannable.getSpanStart(spans1[0]))
            assertEquals(2, spannable.getSpanEnd(spans1[0]))
            assertTrue(spans1[1] is SuperscriptSpan)
            assertEquals(6, spannable.getSpanStart(spans1[1]))
            assertEquals(7, spannable.getSpanEnd(spans1[1]))
            assertTrue(spans1[2] is SuperscriptSpan)
            assertEquals(11, spannable.getSpanStart(spans1[2]))
            assertEquals(12, spannable.getSpanEnd(spans1[2]))
        }
    }

    @Test
    fun `superscript 002`() {
        val string = "a{`2`<superscript:true/>} + b{`2`<superscript:true/>} = c{`2`<superscript:false/>}"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("a2 + b2 = c2", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 2)
            assertTrue(spans1[0] is SuperscriptSpan)
            assertEquals(1, spannable.getSpanStart(spans1[0]))
            assertEquals(2, spannable.getSpanEnd(spans1[0]))
            assertTrue(spans1[1] is SuperscriptSpan)
            assertEquals(6, spannable.getSpanStart(spans1[1]))
            assertEquals(7, spannable.getSpanEnd(spans1[1]))
        }
    }

    @Test
    fun `text-style 001`() {
        val string = "{ `Hitanshu` < text-style : normal /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Typeface.NORMAL, (spans1[0] as StyleSpan).style)
        }
    }

    @Test
    fun `text-style 002`() {
        val string = "{ `Hitanshu` < text-style : bold /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Typeface.BOLD, (spans1[0] as StyleSpan).style)
        }
    }

    @Test
    fun `text-style 003`() {
        val string = "{ `Hitanshu` < text-style : italic /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Typeface.ITALIC, (spans1[0] as StyleSpan).style)
        }
    }

    @Test
    fun `text-style 004`() {
        val string = "{ `Hitanshu` < text-style : random-value /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    fun `font-family 001`() {
        val string = "{ `Hitanshu` < font-family : monospace /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals("monospace", (spans1[0] as TypefaceSpan).family)
        }
    }

    @Test
    fun `font-family 002`() {
        val string = "{ `Hitanshu` < font-family : serif /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals("serif", (spans1[0] as TypefaceSpan).family)
        }
    }

    @Test
    fun `font-family 003`() {
        val string = "{ `Hitanshu` < font-family : sans-serif /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals("sans-serif", (spans1[0] as TypefaceSpan).family)
        }
    }

    @Test
    fun `font-family 004`() {
        val string = "{ `Hitanshu` < font-family : random-value /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    fun `text-alignment 001`() {
        val string = "{ `Hitanshu` < text-alignment : normal /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Layout.Alignment.ALIGN_NORMAL, (spans1[0] as AlignmentSpan.Standard).alignment)
        }
    }

    @Test
    fun `text-alignment 002`() {
        val string = "{ `Hitanshu` < text-alignment : opposite /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Layout.Alignment.ALIGN_OPPOSITE, (spans1[0] as AlignmentSpan.Standard).alignment)
        }
    }

    @Test
    fun `text-alignment 003`() {
        val string = "{ `Hitanshu` < text-alignment : center /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Layout.Alignment.ALIGN_CENTER, (spans1[0] as AlignmentSpan.Standard).alignment)
        }
    }

    @Test
    fun `text-alignment 004`() {
        val string = "{ `Hitanshu` < text-alignment : random-value /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    fun `text-alignment 005`() {
        val string = "Hitanshu { `Hitanshu` < text-alignment : normal /> } Hitanshu"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu Hitanshu Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Layout.Alignment.ALIGN_NORMAL, (spans1[0] as AlignmentSpan.Standard).alignment)
            assertEquals(9, spannable.getSpanStart(spans1[0]))
            assertEquals(17, spannable.getSpanEnd(spans1[0]))
        }
    }

    @Test
    fun `text-alignment 006`() {
        val string = "Hitanshu { `Hitanshu` < text-alignment : opposite /> } Hitanshu"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu Hitanshu Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Layout.Alignment.ALIGN_OPPOSITE, (spans1[0] as AlignmentSpan.Standard).alignment)
            assertEquals(9, spannable.getSpanStart(spans1[0]))
            assertEquals(17, spannable.getSpanEnd(spans1[0]))
        }
    }

    @Test
    fun `text-alignment 007`() {
        val string = "Hitanshu { `Hitanshu` < text-alignment : center /> } Hitanshu"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu Hitanshu Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(Layout.Alignment.ALIGN_CENTER, (spans1[0] as AlignmentSpan.Standard).alignment)
            assertEquals(9, spannable.getSpanStart(spans1[0]))
            assertEquals(17, spannable.getSpanEnd(spans1[0]))
        }
    }

    @Test
    @Config(minSdk = 29, maxSdk = 29)
    fun `line-height 001`() {
        val string = "{ `Hitanshu` < line-height : 16px /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertEquals(16, (spans1[0] as LineHeightSpan.Standard).height)
        }
    }

    @Test
    @Config(minSdk = 29, maxSdk = 29)
    fun `line-height 002`() {
        val string = "{ `Hitanshu` < line-height : random-value /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    @Config(minSdk = 29, maxSdk = 29)
    fun `line-height 003`() {
        val string = "{ `Hitanshu` < line-height : 16spx /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    @Config(minSdk = 14, maxSdk = 28)
    fun `line-height 004`() {
        val string = "{ `Hitanshu` < line-height : 16px /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("Hitanshu", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    fun `url 001`() {
        val string = "click { `here` < url : `http://www.hitanshudhawan.com` /> } for more information"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("click here for more information", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertTrue(spans1[0] is URLSpan)
            assertEquals("http://www.hitanshudhawan.com", (spans1[0] as URLSpan).url)
            assertEquals(6, spannable.getSpanStart(spans1[0]))
            assertEquals(10, spannable.getSpanEnd(spans1[0]))
        }
    }

    @Test
    fun `url 002`() {
        val string = "click { `here` < url : www.hitanshudhawan.com /> } for more information"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("click here for more information", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 1)
            assertTrue(spans1[0] is URLSpan)
            assertEquals("www.hitanshudhawan.com", (spans1[0] as URLSpan).url)
            assertEquals(6, spannable.getSpanStart(spans1[0]))
            assertEquals(10, spannable.getSpanEnd(spans1[0]))
        }
    }

    @Test
    fun `url 003`() {
        val string = "click { `here` < url : http://www.hitanshudhawan.com /> } for more information"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("click { `here` < url : http://www.hitanshudhawan.com /> } for more information", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    @Test
    fun `custom spanner 001`() {
        val string = "C{`8`<sub:true/>}H{`10`<sub:true/>}N{`4`<sub:true/>}O{`2`<sub:true/>}"
        spanner { property, value ->
            when (property) {
                "sub" -> if (value == "true") return@spanner SubscriptSpan()
            }
            return@spanner null
        }
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("C8H10N4O2", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 4)
            assertTrue(spans1[0] is SubscriptSpan)
            assertTrue(spans1[1] is SubscriptSpan)
            assertTrue(spans1[2] is SubscriptSpan)
            assertTrue(spans1[3] is SubscriptSpan)
        }
    }

    @Test
    fun `custom spanner 002`() {
        val string = "a{`2`<super:true;text-size:0.5em/>} + b{`2`<super:true;text-size:0.5em/>} = c{`2`<super:true;text-size:0.5em/>}"
        spanner { property, value ->
            when (property) {
                "sub" -> if (value == "true") return@spanner SubscriptSpan()
            }
            return@spanner null
        }
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals("a2 + b2 = c2", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.size == 3)
        }
    }

    //

    @Test
    fun test001() {
        val string = "{ ` ` < color : #0000FF /> }"
        with(string.spannify()) {
            val spannable = this as SpannableStringBuilder

            assertEquals(" ", spannable.toString())

            val spans1 = spannable.getSpans()
            assertTrue(spans1.isEmpty())
        }
    }

    private fun SpannableStringBuilder.getSpans(queryStart: Int = 0, queryEnd: Int = length): Array<Any> {
        return getSpans(queryStart, queryEnd, Any::class.java)
    }
}
