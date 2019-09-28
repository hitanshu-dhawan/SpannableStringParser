package com.hitanshudhawan.spannablestringparser.parser

import com.hitanshudhawan.spannablestringparser.lexer.Token
import com.hitanshudhawan.spannablestringparser.lexer.TokenType.*

internal class FiniteAutomaton {

    val initialState = 1
    val leftBraceState = 2
    val leftSingleQuote = 3
    val textState = 4
    val rightSingleQuote = 5
    val startTagState = 6
    val propertyState = 7
    val colonState = 8
    val valueState = 9
    val endTagState = 10
    val rightBraceState = 11

    private val automatonMap by lazy {
        mapOf(
            1 to mapOf(LEFT_BRACE to 2),
            2 to mapOf(WHITESPACE to 2, SINGLE_QUOTE to 3),
            3 to mapOf(
                WHITESPACE to 3,
                TEXT to 4,
                LEFT_BRACE to 4,
                RIGHT_BRACE to 4,
                SINGLE_QUOTE to 4,
                START_TAG to 4,
                END_TAG to 4,
                COLON to 4,
                PIPE to 4,
                SEMICOLON to 4
            ),
            4 to mapOf(
                WHITESPACE to 4,
                TEXT to 4,
                LEFT_BRACE to 4,
                RIGHT_BRACE to 4,
                START_TAG to 4,
                END_TAG to 4,
                COLON to 4,
                PIPE to 4,
                SEMICOLON to 4,
                SINGLE_QUOTE to 5
            ),
            5 to mapOf(WHITESPACE to 5, START_TAG to 6),
            6 to mapOf(WHITESPACE to 6, TEXT to 7),
            7 to mapOf(WHITESPACE to 7, COLON to 8),
            8 to mapOf(WHITESPACE to 8, TEXT to 9),
            9 to mapOf(WHITESPACE to 9, PIPE to 8, SEMICOLON to 6, END_TAG to 10),
            10 to mapOf(WHITESPACE to 10, RIGHT_BRACE to 11)
        )
    }

    private var currentState = 1

    fun transit(token: Token): Int {
        if (currentState == rightBraceState)
            currentState = initialState

        currentState = automatonMap.getValue(currentState)[token.tokenType] ?: initialState

        if (currentState == initialState)
            currentState = automatonMap.getValue(currentState)[token.tokenType] ?: initialState

        return currentState
    }

}