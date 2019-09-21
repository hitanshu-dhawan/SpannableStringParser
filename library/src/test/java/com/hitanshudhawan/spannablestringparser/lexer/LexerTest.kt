package com.hitanshudhawan.spannablestringparser.lexer

import com.hitanshudhawan.spannablestringparser.TestingUtils.testingStrings
import com.hitanshudhawan.spannablestringparser.lexer.TokenType.TEXT
import com.hitanshudhawan.spannablestringparser.lexer.TokenType.WHITESPACE
import com.hitanshudhawan.spannablestringparser.tokenize
import org.junit.Assert.assertEquals
import org.junit.Test

class LexerTest {

    @Test
    fun test001() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(TEXT, "Hitanshu")
            ),
            testingStrings.getValue(1).tokenize()
        )
    }

}