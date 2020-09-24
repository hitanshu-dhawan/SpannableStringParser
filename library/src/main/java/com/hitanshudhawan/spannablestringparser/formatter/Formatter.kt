package com.hitanshudhawan.spannablestringparser.formatter

import com.hitanshudhawan.spannablestringparser.lexer.TokenType
import com.hitanshudhawan.spannablestringparser.parse
import com.hitanshudhawan.spannablestringparser.parser.Declaration
import com.hitanshudhawan.spannablestringparser.parser.Node
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

        val syntaxTree = text.tokenize().parse()

        if (syntaxTree.size != 1)
            throw IllegalArgumentException("...")

        val node = syntaxTree[0].copy(
            declarations = (syntaxTree[0].declarations ?: emptyList()).toMutableList().apply {
                addAll(values.map { value -> Declaration(property, value) })
            }
        )

        return node.covertToString()
    }

    private fun Node.covertToString(): String {
        if (this.declarations == null || this.declarations.isEmpty())
            return this.text

        val template = "{ `{{TEXT}}` <{{DECLARATIONS}}/> }"

        return template
            .replace("{{TEXT}}", this.text)
            .replace(
                "{{DECLARATIONS}}",
                this.declarations
                    .groupBy { it.property }
                    .map { (property, declarations) ->
                        "$property:${declarations.map { it.value.wrapWithBackticksIfInvalid() }.joinToString("|")}"
                    }
                    .joinToString(";")
            )
    }

    private fun String.wrapWithBackticksIfInvalid(): String {
        return if (this.tokenize().size != 1) "`$this`" else this
    }
}
