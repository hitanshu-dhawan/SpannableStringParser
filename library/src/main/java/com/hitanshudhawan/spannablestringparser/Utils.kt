package com.hitanshudhawan.spannablestringparser

import com.hitanshudhawan.spannablestringparser.lexer.*
import com.hitanshudhawan.spannablestringparser.parser.*
import com.hitanshudhawan.spannablestringparser.spanner.Spanner

internal fun String.tokenize(): List<Token> {
    val lexer = Lexer(this)
    val tokens = ArrayList<Token>()
    while (true)
        tokens.add(lexer.nextToken() ?: break)
    return tokens
}

internal fun List<Token>.parse(): List<Node> {
    return Parser(this).parse()
}

internal fun List<Node>.spannify(customSpanner: (String, String) -> Any?): CharSequence {
    return Spanner(this, customSpanner).spannify()
}
