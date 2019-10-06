package com.hitanshudhawan.spannablestringparser.lexer

import com.hitanshudhawan.spannablestringparser.lexer.TokenType.*

internal class Lexer(private val text: String) {

    private var index = 0

    fun nextToken(): Token? {
        val ch = nextChar() ?: return null
        when (ch) {
            "{" -> return Token(LEFT_BRACE)
            "}" -> return Token(RIGHT_BRACE)
            "`" -> return Token(BACKTICK)
            "<" -> return Token(START_TAG)
            "/>" -> return Token(END_TAG)
            ":" -> return Token(COLON)
            "|" -> return Token(PIPE)
            ";" -> return Token(SEMICOLON)
            " ", "\t", "\r", "\n" -> {
                var value = ch
                while (peekChar()?.isWhitespaceChar() == true) {
                    value += nextChar()
                }
                return Token(WHITESPACE, value)
            }
            else -> {
                var value = ch
                while (peekChar()?.isTextChar() == true) {
                    value += nextChar()
                }
                return Token(TEXT, value)
            }
        }
    }

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

    private fun String.isWhitespaceChar(): Boolean {
        when (this) {
            " ", "\t", "\r", "\n" -> return true
        }
        return false
    }

    private fun String.isTextChar(): Boolean {
        when (this) {
            "{", "}", "`", "<", "/>", ":", "|", ";", " ", "\t", "\r", "\n" -> return false
        }
        return true
    }

}