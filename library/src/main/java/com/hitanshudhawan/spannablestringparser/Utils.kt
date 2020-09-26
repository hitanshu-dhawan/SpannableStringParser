package com.hitanshudhawan.spannablestringparser

import android.util.Log
import com.hitanshudhawan.spannablestringparser.formatter.Formatter
import com.hitanshudhawan.spannablestringparser.lexer.Lexer
import com.hitanshudhawan.spannablestringparser.lexer.Token
import com.hitanshudhawan.spannablestringparser.parser.Node
import com.hitanshudhawan.spannablestringparser.parser.Parser
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

internal fun String.addProperty(property: String, values: List<String>): String {
    return Formatter(this).addProperty(property, values)
}

internal fun safe(block: () -> Unit) {
    try {
        block.invoke()
    } catch (e: Exception) {
        Log.e("SpannableStringParser", e.toString())
    }
}
