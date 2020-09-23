package com.hitanshudhawan.spannablestringparser.formatter

import com.hitanshudhawan.spannablestringparser.lexer.TokenType
import com.hitanshudhawan.spannablestringparser.tokenize

internal class Formatter(private val text: String) {

    fun addProperty(property: String, values: List<String>): String {

        if (text.isBlank())
            return text

        if (property.isBlank())
            throw IllegalArgumentException("...")
        if (property.tokenize().size != 1 || property.tokenize()[0].tokenType != TokenType.TEXT)
            throw IllegalArgumentException("...")

        if (values.isEmpty())
            throw IllegalArgumentException("...")
        if (values.any { it.isBlank() })
            throw IllegalArgumentException("...")

        return "..."
    }
}
