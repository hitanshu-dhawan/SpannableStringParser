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

        val text = StringBuilder()

        for (token in tokens) {
            val state = finiteAutomaton.transit(token)
            when (state) {
                finiteAutomaton.initialState -> {
                    while (queue.isNotEmpty())
                        text.append(queue.remove().text())
                    text.append(token.text())
                }
                finiteAutomaton.leftBraceState -> {
                    if (token.tokenType == LEFT_BRACE)
                        while (queue.isNotEmpty())
                            text.append(queue.remove().text())
                    queue.add(token)
                }
                finiteAutomaton.rightBraceState -> {
                    if (text.isNotEmpty())
                        syntaxTree.add(Node(text.toString()))
                    text.clear()

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
            text.append(queue.remove().text())
        if (text.isNotEmpty())
            syntaxTree.add(Node(text.toString()))

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
                finiteAutomaton.startTextState -> {
                    if (ruleSetToken.tokenType != BACKTICK)
                        ruleSetText += ruleSetToken.text()
                }
                finiteAutomaton.propertyState -> {
                    if (ruleSetToken.tokenType == TEXT)
                        ruleSetProperty = ruleSetToken.text()
                }
                finiteAutomaton.startValueState -> {
                    if (ruleSetToken.tokenType != BACKTICK)
                        ruleSetValue += ruleSetToken.text()
                }
                finiteAutomaton.endValueState -> {
                    if (ruleSetToken.tokenType == BACKTICK)
                        ruleSetDeclarations.add(Declaration(property = ruleSetProperty, value = ruleSetValue))
                    if (ruleSetToken.tokenType == TEXT)
                        ruleSetDeclarations.add(Declaration(property = ruleSetProperty, value = ruleSetToken.text()))

                    ruleSetValue = ""
                }
            }
        }

        return Node(text = ruleSetText, declarations = ruleSetDeclarations)
    }

    private fun Token.text(): String {
        return when (this.tokenType) {
            TEXT -> this.value ?: ""
            WHITESPACE -> this.value ?: ""
            LEFT_BRACE -> "{"
            RIGHT_BRACE -> "}"
            BACKTICK -> "`"
            START_TAG -> "<"
            END_TAG -> "/>"
            COLON -> ":"
            PIPE -> "|"
            SEMICOLON -> ";"
        }
    }

}