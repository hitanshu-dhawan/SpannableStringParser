package com.hitanshudhawan.spannablestringparser.parser

import com.hitanshudhawan.spannablestringparser.lexer.Token
import com.hitanshudhawan.spannablestringparser.lexer.TokenType.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * Parser : Converts a sequence of tokens into a syntax tree.
 */
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
                        text.append(queue.remove().run { tokenType.text ?: value!! })
                    text.append(token.run { tokenType.text ?: value!! })
                }
                finiteAutomaton.leftBraceState -> {
                    if (token.tokenType == LEFT_BRACE)
                        while (queue.isNotEmpty())
                            text.append(queue.remove().run { tokenType.text ?: value!! })
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
            text.append(queue.remove().run { tokenType.text ?: value!! })
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
                        ruleSetText += ruleSetToken.run { tokenType.text ?: value!! }
                }
                finiteAutomaton.propertyState -> {
                    if (ruleSetToken.tokenType == TEXT)
                        ruleSetProperty = ruleSetToken.run { tokenType.text ?: value!! }
                }
                finiteAutomaton.startValueState -> {
                    if (ruleSetToken.tokenType != BACKTICK)
                        ruleSetValue += ruleSetToken.run { tokenType.text ?: value!! }
                }
                finiteAutomaton.endValueState -> {
                    if (ruleSetToken.tokenType == BACKTICK)
                        ruleSetDeclarations.add(Declaration(property = ruleSetProperty, value = ruleSetValue))
                    if (ruleSetToken.tokenType == TEXT)
                        ruleSetDeclarations.add(Declaration(property = ruleSetProperty, value = ruleSetToken.run { tokenType.text ?: value!! }))

                    ruleSetValue = ""
                }
            }
        }

        return Node(text = ruleSetText, declarations = ruleSetDeclarations)
    }

}
