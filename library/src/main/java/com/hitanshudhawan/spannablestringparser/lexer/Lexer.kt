package com.hitanshudhawan.spannablestringparser.lexer

import com.hitanshudhawan.spannablestringparser.lexer.TokenType.*

/**
 * Lexer : Converts a String into sequence of tokens.
 */
internal class Lexer(private val text: String) {

    private var index = 0

    fun nextToken(): Token? {
        val ch = nextChar() ?: return null
        when {
            ch.isTextChar() -> {
                var value = ch
                while (peekChar()?.isTextChar() == true)
                    value += nextChar()
                return Token(TEXT, value)
            }
            ch.isWhitespaceChar() -> {
                var value = ch
                while (peekChar()?.isWhitespaceChar() == true) {
                    value += nextChar()
                }
                return Token(WHITESPACE, value)
            }
            else -> {
                return Token(TokenType.values().first { ch == it.text })
            }
        }
    }

    private fun nextChar(): String? {
        return peekChar()?.also { index += it.length }
    }

    private fun peekChar(): String? {
        if (index < text.length) {
            TokenType.values().firstOrNull { it.text != null && text.substring(index).startsWith(it.text) }?.let { return it.text }
            return text[index].toString()
        }
        return null
    }

    private fun String.isTextChar(): Boolean {
        if (TokenType.values().any { this == it.text } || isWhitespaceChar())
            return false
        return true
    }

    private fun String.isWhitespaceChar(): Boolean {
        when (this) {
            " ", "\t", "\r", "\n" -> return true
        }
        return false
    }

}
