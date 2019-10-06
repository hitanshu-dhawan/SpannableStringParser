package com.hitanshudhawan.spannablestringparser.spanner

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import com.hitanshudhawan.spannablestringparser.parser.Node

internal class Spanner(private val syntaxTree: List<Node>) {

    fun spannify(): CharSequence {
        val text = SpannableStringBuilder()
        for (node in syntaxTree)
            text.append(spannify(node))
        return text
    }

    private fun spannify(node: Node): CharSequence {

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

                "text-decoration" -> {
                    //
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
                    //
                }

                "font-style" -> {
                    //
                }

                "font-weight" -> {
                    //
                }

            }

        }

        return text
    }

    private fun SpannableString.setSpan(what: Any) {
        setSpan(what, 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

}