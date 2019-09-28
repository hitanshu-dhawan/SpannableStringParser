package com.hitanshudhawan.spannablestringparser.parser

import com.hitanshudhawan.spannablestringparser.lexer.Token
import com.hitanshudhawan.spannablestringparser.lexer.TokenType.*
import java.util.*
import kotlin.collections.ArrayList

internal class Parser(private val tokens: List<Token>) {

    fun parse(): List<Node> {

        val syntaxTree = ArrayList<Node>()

        val finiteAutomaton = FiniteAutomaton()
        val queue: Queue<Token> = LinkedList<Token>()

        var text = "" // todo : use string builder

        for (token in tokens) {
            val state = finiteAutomaton.transit(token)
            when (state) {
                finiteAutomaton.initialState -> {
                    while (queue.isNotEmpty())
                        text += queue.remove().text()
                    text += token.text()
                }
                finiteAutomaton.leftBraceState -> {
                    if (token.tokenType != WHITESPACE) {
                        while (queue.isNotEmpty())
                            text += queue.remove().text()
                    }
                    queue.add(token)
                }
                finiteAutomaton.rightBraceState -> {
                    if (text.isNotEmpty())
                        syntaxTree.add(Node(text))
                    text = ""

                    val ruleSetTokens = ArrayList<Token>()
                    while (queue.isNotEmpty())
                        ruleSetTokens.add(queue.remove())
                    ruleSetTokens.add(token)

                    syntaxTree.add(getRuleSetNode(ruleSetTokens))
                }
                else -> {
                    queue.add(token)
                }
            }
        }

        while (queue.isNotEmpty())
            text += queue.remove().text()
        if (text.isNotEmpty())
            syntaxTree.add(Node(text))

        return syntaxTree
    }

    private fun getRuleSetNode(ruleSetTokens: List<Token>): Node {

        val finiteAutomaton = FiniteAutomaton()
        var ruleSetText = ""
        var ruleSetProperty = ""
        var ruleSetValue = ""
        val ruleSetDeclarations = ArrayList<Declaration>()
        for (ruleSetToken in ruleSetTokens) {
            val ruleSetState = finiteAutomaton.transit(ruleSetToken)
            when (ruleSetState) {
                finiteAutomaton.leftBraceState -> { // 2
                    //
                }
                finiteAutomaton.leftSingleQuote -> { // 3
                    if (ruleSetToken.tokenType != SINGLE_QUOTE)
                        ruleSetText += ruleSetToken.text()
                }
                finiteAutomaton.textState -> { // 4
                    ruleSetText += ruleSetToken.text()
                }
                finiteAutomaton.rightSingleQuote -> { // 5
                    //
                }
                finiteAutomaton.startTagState -> { // 6
                    // ruleSetProperty = ""
                    // ruleSetValue = ""
                }
                finiteAutomaton.propertyState -> { // 7
                    if (ruleSetToken.tokenType == TEXT)
                        ruleSetProperty = ruleSetToken.value ?: ""
                }
                finiteAutomaton.colonState -> { // 8
                    //
                }
                finiteAutomaton.valueState -> { // 9
                    if (ruleSetToken.tokenType == TEXT) {
                        ruleSetValue = ruleSetToken.value ?: ""

                        // if (ruleSetText.isNotEmpty() && ruleSetProperty.isNotEmpty() && ruleSetValue.isNotEmpty())
                        ruleSetDeclarations.add(Declaration(ruleSetProperty, ruleSetValue))

                        // ruleSetProperty = ""
                        // ruleSetValue = ""
                    }
                }
                finiteAutomaton.endTagState -> { // 10
                    //
                }
                finiteAutomaton.rightBraceState -> { // 11
                    //
                }
            }
        }

        return Node(ruleSetText, ruleSetDeclarations)
    }

    private fun Token.text(): String {
        return when (this.tokenType) {
            TEXT -> this.value ?: ""
            WHITESPACE -> this.value ?: ""
            LEFT_BRACE -> "{"
            RIGHT_BRACE -> "}"
            SINGLE_QUOTE -> "'"
            START_TAG -> "<"
            END_TAG -> "/>"
            COLON -> ":"
            PIPE -> "|"
            SEMICOLON -> ";"
        }
    }

}