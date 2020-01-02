package com.hitanshudhawan.spannablestringparser.spanner

import android.graphics.*
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.Q
import android.text.*
import android.text.style.*
import com.hitanshudhawan.spannablestringparser.parser.Node
import com.hitanshudhawan.spannablestringparser.safe

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

                "text-color" -> safe {
                    text.setSpan(ForegroundColorSpan(Color.parseColor(declaration.value)))
                }

                "background-color" -> safe {
                    text.setSpan(BackgroundColorSpan(Color.parseColor(declaration.value)))
                }

                "line-background-color" -> if (SDK_INT >= Q) safe {
                    text.setSpan(LineBackgroundSpan.Standard(Color.parseColor(declaration.value)))
                }

                "text-size" -> safe {
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

                "text-decoration" -> safe {
                    when (declaration.value) {
                        "underline" -> {
                            text.setSpan(UnderlineSpan())
                        }
                        "strike-through" -> {
                            text.setSpan(StrikethroughSpan())
                        }
                    }
                }

                "subscript" -> safe {
                    if (declaration.value == "true") {
                        text.setSpan(SubscriptSpan())
                    }
                }

                "superscript" -> safe {
                    if (declaration.value == "true") {
                        text.setSpan(SuperscriptSpan())
                    }
                }

                "text-style" -> safe {
                    when (declaration.value) {
                        "normal" -> {
                            text.setSpan(StyleSpan(Typeface.NORMAL))
                        }
                        "bold" -> {
                            text.setSpan(StyleSpan(Typeface.BOLD))
                        }
                        "italic" -> {
                            text.setSpan(StyleSpan(Typeface.ITALIC))
                        }
                    }
                }

                "font-family" -> safe {
                    when (declaration.value) {
                        "monospace", "serif", "sans-serif" -> {
                            text.setSpan(TypefaceSpan(declaration.value))
                        }
                    }
                }

                "text-alignment" -> safe {
                    when (declaration.value) {
                        "normal" -> {
                            text.setSpan(AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL))
                        }
                        "opposite" -> {
                            text.setSpan(AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE))
                        }
                        "center" -> {
                            text.setSpan(AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER))
                        }
                    }
                }

                "line-height" -> if (SDK_INT >= Q) safe {
                    val value = declaration.value
                    when {
                        value.endsWith("px") -> {
                            text.setSpan(LineHeightSpan.Standard(value.substring(0, value.length - 2).toInt()))
                        }
                    }
                }

                "url" -> safe {
                    text.setSpan(URLSpan(declaration.value))
                }

                else -> safe {
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
