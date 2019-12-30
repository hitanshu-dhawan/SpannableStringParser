package com.hitanshudhawan.spannablestringparser.lexer

import com.hitanshudhawan.spannablestringparser.TestingUtils.testStrings
import com.hitanshudhawan.spannablestringparser.lexer.TokenType.*
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
            testStrings.getValue(1).tokenize()
        )
    }

    @Test
    fun test002() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(LEFT_BRACE),
                Token(TEXT, "Hitanshu"),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(2).tokenize()
        )
    }

    @Test
    fun test003() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK)
            ),
            testStrings.getValue(3).tokenize()
        )
    }

    @Test
    fun test004() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(TEXT, "Hitanshu>")
            ),
            testStrings.getValue(4).tokenize()
        )
    }

    @Test
    fun test005() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(TEXT, "Hitanshu"),
                Token(COLON)
            ),
            testStrings.getValue(5).tokenize()
        )
    }

    @Test
    fun test006() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(PIPE),
                Token(TEXT, "Hitanshu"),
                Token(PIPE)
            ),
            testStrings.getValue(6).tokenize()
        )
    }

    @Test
    fun test007() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(SEMICOLON),
                Token(TEXT, "Hitanshu"),
                Token(SEMICOLON)
            ),
            testStrings.getValue(7).tokenize()
        )
    }

    @Test
    fun test008() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(TEXT, "/Hitanshu/")
            ),
            testStrings.getValue(8).tokenize()
        )
    }

    @Test
    fun test009() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(TEXT, "/Hitanshu"),
                Token(END_TAG)
            ),
            testStrings.getValue(9).tokenize()
        )
    }

    @Test
    fun test010() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(10).tokenize()
        )
    }

    @Test
    fun test011() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(11).tokenize()
        )
    }

    @Test
    fun test012() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(12).tokenize()
        )
    }

    @Test
    fun test013() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(WHITESPACE, " "),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(13).tokenize()
        )
    }

    @Test
    fun test014() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(WHITESPACE, " "),
                Token(TEXT, "a"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(14).tokenize()
        )
    }

    @Test
    fun test015() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(WHITESPACE, " "),
                Token(TEXT, "a"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(15).tokenize()
        )
    }

    @Test
    fun test016() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(WHITESPACE, " "),
                Token(TEXT, "a"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "b"),
                Token(WHITESPACE, " "),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(16).tokenize()
        )
    }

    @Test
    fun test017() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(WHITESPACE, " "),
                Token(TEXT, "a"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "b"),
                Token(WHITESPACE, " "),
                Token(PIPE),
                Token(WHITESPACE, " "),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(17).tokenize()
        )
    }

    @Test
    fun test018() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(WHITESPACE, " "),
                Token(TEXT, "a"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "b"),
                Token(WHITESPACE, " "),
                Token(PIPE),
                Token(WHITESPACE, " "),
                Token(TEXT, "c"),
                Token(WHITESPACE, " "),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(18).tokenize()
        )
    }

    @Test
    fun test019() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(WHITESPACE, " "),
                Token(TEXT, "a"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "b"),
                Token(WHITESPACE, " "),
                Token(PIPE),
                Token(WHITESPACE, " "),
                Token(TEXT, "c"),
                Token(WHITESPACE, " "),
                Token(SEMICOLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(19).tokenize()
        )
    }

    @Test
    fun test020() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(WHITESPACE, " "),
                Token(TEXT, "a"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "b"),
                Token(WHITESPACE, " "),
                Token(PIPE),
                Token(WHITESPACE, " "),
                Token(TEXT, "c"),
                Token(WHITESPACE, " "),
                Token(SEMICOLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "d"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(20).tokenize()
        )
    }

    @Test
    fun test021() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(WHITESPACE, " "),
                Token(TEXT, "a"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "b"),
                Token(WHITESPACE, " "),
                Token(PIPE),
                Token(WHITESPACE, " "),
                Token(TEXT, "c"),
                Token(WHITESPACE, " "),
                Token(SEMICOLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "d"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(21).tokenize()
        )
    }

    @Test
    fun test022() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(WHITESPACE, " "),
                Token(TEXT, "a"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "b"),
                Token(WHITESPACE, " "),
                Token(PIPE),
                Token(WHITESPACE, " "),
                Token(TEXT, "c"),
                Token(WHITESPACE, " "),
                Token(SEMICOLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "d"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "e"),
                Token(WHITESPACE, " "),
                Token(END_TAG),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(22).tokenize()
        )
    }

    @Test
    fun test023() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(WHITESPACE, " "),
                Token(TEXT, "a"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "b"),
                Token(WHITESPACE, " "),
                Token(PIPE),
                Token(WHITESPACE, " "),
                Token(TEXT, "c"),
                Token(WHITESPACE, " "),
                Token(SEMICOLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "d"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "e"),
                Token(WHITESPACE, " "),
                Token(END_TAG),
                Token(WHITESPACE, " "),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(23).tokenize()
        )
    }

    @Test
    fun test024() {
        assertEquals(
            listOf(
                Token(WHITESPACE, "  "),
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE),
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Dhawan"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE),
                Token(WHITESPACE, "  ")
            ),
            testStrings.getValue(24).tokenize()
        )
    }

    @Test
    fun test025() {
        assertEquals(
            listOf(
                Token(WHITESPACE, " "),
                Token(LEFT_BRACE),
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE),
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Dhawan"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE),
                Token(RIGHT_BRACE),
                Token(WHITESPACE, " ")
            ),
            testStrings.getValue(25).tokenize()
        )
    }

    @Test
    fun test026() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE),
                Token(RIGHT_BRACE),
                Token(LEFT_BRACE),
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Dhawan"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(26).tokenize()
        )
    }

    @Test
    fun test027() {
        assertEquals(
            listOf(
                Token(WHITESPACE, "   "),
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE),
                Token(WHITESPACE, " "),
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Dhawan"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE),
                Token(WHITESPACE, "   ")
            ),
            testStrings.getValue(27).tokenize()
        )
    }

    @Test
    fun test028() {
        assertEquals(
            listOf(
                Token(WHITESPACE, "  "),
                Token(LEFT_BRACE),
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE),
                Token(WHITESPACE, " "),
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Dhawan"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE),
                Token(RIGHT_BRACE),
                Token(WHITESPACE, "  ")
            ),
            testStrings.getValue(28).tokenize()
        )
    }

    @Test
    fun test029() {
        assertEquals(
            listOf(
                Token(WHITESPACE, " "),
                Token(LEFT_BRACE),
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE),
                Token(RIGHT_BRACE),
                Token(WHITESPACE, " "),
                Token(LEFT_BRACE),
                Token(LEFT_BRACE),
                Token(BACKTICK),
                Token(TEXT, "Dhawan"),
                Token(BACKTICK),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(RIGHT_BRACE),
                Token(RIGHT_BRACE),
                Token(WHITESPACE, " ")
            ),
            testStrings.getValue(29).tokenize()
        )
    }

    @Test
    fun test030() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(WHITESPACE, " "),
                Token(TEXT, "Dhawan"),
                Token(WHITESPACE, " "),
                Token(COLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "Android"),
                Token(WHITESPACE, " "),
                Token(TEXT, "Developer"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(WHITESPACE, " "),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(30).tokenize()
        )
    }

    @Test
    fun test031() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(WHITESPACE, " "),
                Token(TEXT, "Dhawan"),
                Token(WHITESPACE, " "),
                Token(PIPE),
                Token(WHITESPACE, " "),
                Token(TEXT, "Android"),
                Token(WHITESPACE, " "),
                Token(TEXT, "Developer"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(WHITESPACE, " "),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(31).tokenize()
        )
    }

    @Test
    fun test032() {
        assertEquals(
            listOf(
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(WHITESPACE, " "),
                Token(TEXT, "Dhawan"),
                Token(WHITESPACE, " "),
                Token(SEMICOLON),
                Token(WHITESPACE, " "),
                Token(TEXT, "Android"),
                Token(WHITESPACE, " "),
                Token(TEXT, "Developer"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(WHITESPACE, " "),
                Token(RIGHT_BRACE)
            ),
            testStrings.getValue(32).tokenize()
        )
    }

    @Test
    fun test033() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(WHITESPACE, " "),
                Token(TEXT, "Dhawan"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(WHITESPACE, " "),
                Token(RIGHT_BRACE),
                Token(TEXT, ","),
                Token(WHITESPACE, " "),
                Token(TEXT, "How"),
                Token(WHITESPACE, " "),
                Token(TEXT, "are"),
                Token(WHITESPACE, " "),
                Token(TEXT, "you"),
                Token(WHITESPACE, " "),
                Token(TEXT, "bro?")
            ),
            testStrings.getValue(33).tokenize()
        )
    }

    @Test
    fun test034() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "Hitanshu"),
                Token(WHITESPACE, " "),
                Token(TEXT, "Dhawan"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(WHITESPACE, " "),
                Token(RIGHT_BRACE),
                Token(TEXT, ","),
                Token(WHITESPACE, " "),
                Token(TEXT, "How"),
                Token(WHITESPACE, " "),
                Token(TEXT, "are"),
                Token(WHITESPACE, " "),
                Token(TEXT, "you"),
                Token(WHITESPACE, " "),
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(TEXT, "bro"),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(WHITESPACE, " "),
                Token(RIGHT_BRACE),
                Token(TEXT, "?")
            ),
            testStrings.getValue(34).tokenize()
        )
    }

    @Test
    fun test035() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(TEXT, "Hitanshu"),
                Token(WHITESPACE, " "),
                Token(TEXT, "Dhawan"),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(WHITESPACE, " "),
                Token(RIGHT_BRACE),
                Token(TEXT, ","),
                Token(WHITESPACE, " "),
                Token(TEXT, "How"),
                Token(WHITESPACE, " "),
                Token(TEXT, "are"),
                Token(WHITESPACE, " "),
                Token(TEXT, "you"),
                Token(WHITESPACE, " "),
                Token(TEXT, "bro?")
            ),
            testStrings.getValue(35).tokenize()
        )
    }

    @Test
    fun test036() {
        assertEquals(
            listOf(
                Token(TEXT, "Hello"),
                Token(WHITESPACE, " "),
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(TEXT, "Hitanshu"),
                Token(WHITESPACE, " "),
                Token(TEXT, "Dhawan"),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(WHITESPACE, " "),
                Token(RIGHT_BRACE),
                Token(TEXT, ","),
                Token(WHITESPACE, " "),
                Token(TEXT, "How"),
                Token(WHITESPACE, " "),
                Token(TEXT, "are"),
                Token(WHITESPACE, " "),
                Token(TEXT, "you"),
                Token(WHITESPACE, " "),
                Token(LEFT_BRACE),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(TEXT, "bro"),
                Token(WHITESPACE, " "),
                Token(BACKTICK),
                Token(WHITESPACE, " "),
                Token(START_TAG),
                Token(TEXT, "a"),
                Token(COLON),
                Token(TEXT, "b"),
                Token(PIPE),
                Token(TEXT, "c"),
                Token(SEMICOLON),
                Token(TEXT, "d"),
                Token(COLON),
                Token(TEXT, "e"),
                Token(END_TAG),
                Token(WHITESPACE, " "),
                Token(RIGHT_BRACE),
                Token(TEXT, "?")
            ),
            testStrings.getValue(36).tokenize()
        )
    }

}
