package com.hitanshudhawan.spannablestringparser.parser

import com.hitanshudhawan.spannablestringparser.lexer.Token
import com.hitanshudhawan.spannablestringparser.lexer.TokenType.*

/**
 * FiniteAutomaton : A finite-state machine to recognize proper syntax.
 */
internal class FiniteAutomaton {

    val initialState = 1
    val leftBraceState = 2
    val startTextState = 3
    val endTextState = 4
    val startTagState = 5
    val propertyState = 6
    val colonState = 7
    val startValueState = 8
    val endValueState = 9
    val endTagState = 10
    val rightBraceState = 11

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
            7 to mapOf(WHITESPACE to 7, BACKTICK to 8, TEXT to 9),
            8 to mapOf(
                TEXT to 8,
                WHITESPACE to 8,
                LEFT_BRACE to 8,
                RIGHT_BRACE to 8,
                START_TAG to 8,
                END_TAG to 8,
                COLON to 8,
                PIPE to 8,
                SEMICOLON to 8,
                BACKTICK to 9
            ),
            9 to mapOf(WHITESPACE to 9, PIPE to 7, SEMICOLON to 5, END_TAG to 10),
            10 to mapOf(WHITESPACE to 10, RIGHT_BRACE to 11)
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
