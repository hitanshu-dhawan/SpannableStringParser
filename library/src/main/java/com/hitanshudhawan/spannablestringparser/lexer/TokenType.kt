package com.hitanshudhawan.spannablestringparser.lexer

internal enum class TokenType(val text: String? = null) {
    TEXT,
    WHITESPACE,
    LEFT_BRACE("{"),
    RIGHT_BRACE("}"),
    BACKTICK("`"),
    START_TAG("<"),
    END_TAG("/>"),
    COLON(":"),
    PIPE("|"),
    SEMICOLON(";")
}
