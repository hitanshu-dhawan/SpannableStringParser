package com.hitanshudhawan.spannablestringparser.spanner

import android.graphics.*
import android.text.*
import android.text.style.*
import com.hitanshudhawan.spannablestringparser.parser.Node

/**
 * Spanner : Converts a syntax tree into SpannableString.
 */
internal class Spanner(private val syntaxTree: List<Node>, private val customSpanner: (property: String, value: String) -> Any?) {

    fun spannify(): CharSequence {
        val text = SpannableStringBuilder()
        for (node in syntaxTree)
            text.append(spannifyNode(node))
        return text
    }

    private fun spannifyNode(node: Node): CharSequence {

        if (node.text.trim().isEmpty() || node.declarations == null)
            return node.text

        val text = SpannableString(node.text)

        for (declaration in node.declarations) {

            when (declaration.property) {

                "color" -> {
                    text.setSpan(ForegroundColorSpan(Color.parseColor(declaration.value)))
                }

                "letter-spacing" -> {
                    //
                }

                "line-height" -> {
                    //
                }

                "text-decoration-line" -> {
                    when (declaration.value) {
                        "underline" -> text.setSpan(UnderlineSpan())
                        "line-through" -> text.setSpan(StrikethroughSpan())
                    }
                }

                "text-transform" -> {
                    //
                }

                "vertical-align" -> {
                    //
                }

                "word-spacing" -> {
                    //
                }

                "font-family" -> {
                    //
                }

                "font-size" -> {
                    val value = declaration.value
                    when {
                        value.endsWith("dp") -> {
                            text.setSpan(AbsoluteSizeSpan(value.substring(0, value.length - 2).toInt(), true))
                        }
                        value.endsWith("em") -> {
                            text.setSpan(RelativeSizeSpan(value.substring(0, value.length - 2).toFloat()))
                        }
                        value.endsWith("px") -> {
                            text.setSpan(AbsoluteSizeSpan(value.substring(0, value.length - 2).toInt(), false))
                        }
                    }
                }

                "font-style" -> {
                    if (declaration.value == "italic")
                        text.setSpan(StyleSpan(Typeface.ITALIC))
                }

                "font-weight" -> {
                    if (declaration.value == "bold")
                        text.setSpan(StyleSpan(Typeface.BOLD))
                }

                else -> {
                    customSpanner.invoke(declaration.property, declaration.value)?.let { text.setSpan(it) }
                }

            }

        }

        return text
    }

    private fun SpannableString.setSpan(what: Any) {
        setSpan(what, 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

}
