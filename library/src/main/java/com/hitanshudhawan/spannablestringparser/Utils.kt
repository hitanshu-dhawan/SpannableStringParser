package com.hitanshudhawan.spannablestringparser

import com.hitanshudhawan.spannablestringparser.lexer.Lexer
import com.hitanshudhawan.spannablestringparser.lexer.Token
import com.hitanshudhawan.spannablestringparser.parser.Node
import com.hitanshudhawan.spannablestringparser.parser.Parser

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