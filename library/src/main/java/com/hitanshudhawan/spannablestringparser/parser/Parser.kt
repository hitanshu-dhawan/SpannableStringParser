package com.hitanshudhawan.spannablestringparser.parser

import com.hitanshudhawan.spannablestringparser.lexer.Token
import com.hitanshudhawan.spannablestringparser.lexer.TokenType.*
import java.util.*
import kotlin.collections.ArrayList

class Parser(private val tokens: List<Token>) {

    fun parse(): List<Node> {

        val syntaxTree = ArrayList<Node>()

        val stateAutomaton = FiniteAutomaton()
        val queue: Queue<Token> = LinkedList<Token>()

        var text = ""

        for (token in tokens) {

            val state = stateAutomaton.transit(token)

            when (state) {
                stateAutomaton.initialState -> {
                    while (queue.isNotEmpty())
                        text += queue.remove().text()
                    text += token.text()
                }
                stateAutomaton.rightBraceState -> {
                    if (text.isNotEmpty())
                        syntaxTree.add(Node(text))
                    text = ""

                    val ruleSetTokens = ArrayList<Token>()
                    while (queue.isNotEmpty())
                        ruleSetTokens.add(queue.remove())
                    ruleSetTokens.add(token)

                    val ruleSetStateAutomaton = FiniteAutomaton()
                    var ruleSetText = ""
                    var ruleSetProperty = ""
                    var ruleSetValue = ""
                    val ruleSetDeclarations = ArrayList<Declaration>()
                    for (ruleSetToken in ruleSetTokens) {
                        val ruleSetState = ruleSetStateAutomaton.transit(ruleSetToken)
                        when (ruleSetState) {
                            ruleSetStateAutomaton.leftSingleQuote -> {
                                if (ruleSetToken.tokenType == WHITESPACE)
                                    ruleSetText += ruleSetToken.value ?: ""
                            }
                            ruleSetStateAutomaton.textState -> {
                                ruleSetText += ruleSetToken.value ?: ""
                            }
                            ruleSetStateAutomaton.propertyState -> {
                                if (ruleSetProperty.isEmpty())
                                    ruleSetProperty = ruleSetToken.value ?: ""
                            }
                            ruleSetStateAutomaton.valueState -> {
                                if (ruleSetValue.isEmpty())
                                    ruleSetValue = ruleSetToken.value ?: ""

                                if (ruleSetText.isNotEmpty() && ruleSetProperty.isNotEmpty() && ruleSetValue.isNotEmpty())
                                    ruleSetDeclarations.add(Declaration(ruleSetProperty, ruleSetValue))

                                ruleSetProperty = ""
                                ruleSetValue = ""
                            }
                        }
                    }
                    syntaxTree.add(Node(ruleSetText, ruleSetDeclarations))
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