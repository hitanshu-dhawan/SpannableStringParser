package com.hitanshudhawan.spannablestringparser.lexer

internal enum class TokenType {
    TEXT, WHITESPACE, LEFT_BRACE, RIGHT_BRACE, BACKTICK, START_TAG, END_TAG, COLON, PIPE, SEMICOLON
}