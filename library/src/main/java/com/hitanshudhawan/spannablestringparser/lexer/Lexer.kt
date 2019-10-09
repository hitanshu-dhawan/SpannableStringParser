package com.hitanshudhawan.spannablestringparser.lexer

import com.hitanshudhawan.spannablestringparser.lexer.TokenType.TEXT
import com.hitanshudhawan.spannablestringparser.lexer.TokenType.WHITESPACE

internal class Lexer(private val text: String) {

    private var index = 0

    fun nextToken(): Token? {
        val ch = nextChar() ?: return null
        when {
            ch.isTextChar() -> {
                var value = ch
                while (peekChar()?.isTextChar() == true) {
                    value += nextChar()
                }
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
                for (tokenType in TokenType.values())
                    if (ch == tokenType.text) return Token(tokenType)
            }
        }
        return null
    }

    // todo
    private fun nextChar(): String? {
        if (index < text.length) {
            val ch = text[index++]
            if (ch == '/' && index < text.length && text[index] == '>') {
                index++
                return "/>"
            }
            return ch.toString()
        }
        return null
    }

    // todo
    private fun peekChar(): String? {
        if (index < text.length) {
            val ch = text[index]
            if (ch == '/' && index + 1 < text.length && text[index + 1] == '>') {
                return "/>"
            }
            return ch.toString()
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