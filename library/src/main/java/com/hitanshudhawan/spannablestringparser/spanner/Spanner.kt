package com.hitanshudhawan.spannablestringparser.spanner

import android.text.SpannableString
import android.text.SpannableStringBuilder
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

                // ...

            }

        }

        return text
    }

}