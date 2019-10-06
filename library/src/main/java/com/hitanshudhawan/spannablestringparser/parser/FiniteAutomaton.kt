package com.hitanshudhawan.spannablestringparser.parser

import com.hitanshudhawan.spannablestringparser.lexer.Token
import com.hitanshudhawan.spannablestringparser.lexer.TokenType.*

internal class FiniteAutomaton {

    val initialState = 1
    val leftBraceState = 2
    val leftSingleQuote = 3
    val rightSingleQuote = 4
    val startTagState = 5
    val propertyState = 6
    val colonState = 7
    val valueState = 8
    val endTagState = 9
    val rightBraceState = 10

    private val automatonMap by lazy {
        mapOf(
            1 to mapOf(WHITESPACE to 1, LEFT_BRACE to 2),
            2 to mapOf(WHITESPACE to 2, BACKTICK to 3),
            3 to mapOf(
                TEXT to 3,
                WHITESPACE to 3,
                LEFT_BRACE to 3,
                RIGHT_BRACE to 3,
                START_TAG to 3,
                END_TAG to 3,
                COLON to 3,
                PIPE to 3,
                SEMICOLON to 3,
                BACKTICK to 4
            ),
            4 to mapOf(WHITESPACE to 4, START_TAG to 5),
            5 to mapOf(WHITESPACE to 5, TEXT to 6),
            6 to mapOf(WHITESPACE to 6, COLON to 7),
            7 to mapOf(WHITESPACE to 7, TEXT to 8),
            8 to mapOf(WHITESPACE to 8, PIPE to 7, SEMICOLON to 5, END_TAG to 9),
            9 to mapOf(WHITESPACE to 9, RIGHT_BRACE to 10)
        )
    }

    private var currentState = 1

    fun transit(token: Token): Int {
        currentState = automatonMap[currentState]?.get(token.tokenType) ?: initialState
        if (currentState == initialState)
            currentState = automatonMap[currentState]?.get(token.tokenType) ?: initialState
        return currentState
    }

}