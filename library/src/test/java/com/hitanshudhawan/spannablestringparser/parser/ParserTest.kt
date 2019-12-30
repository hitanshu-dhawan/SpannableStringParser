package com.hitanshudhawan.spannablestringparser.parser

import com.hitanshudhawan.spannablestringparser.*
import com.hitanshudhawan.spannablestringparser.TestingUtils.testStrings
import org.junit.Assert.assertEquals
import org.junit.Test

class ParserTest {

    @Test
    fun test001() {
        assertEquals(
            listOf(
                Node("Hello Hitanshu")
            ),
            testStrings.getValue(1).tokenize().parse()
        )
    }

    @Test
    fun test002() {
        assertEquals(
            listOf(
                Node("Hello {Hitanshu}")
            ),
            testStrings.getValue(2).tokenize().parse()
        )
    }

    @Test
    fun test003() {
        assertEquals(
            listOf(
                Node("Hello `Hitanshu`")
            ),
            testStrings.getValue(3).tokenize().parse()
        )
    }

    @Test
    fun test004() {
        assertEquals(
            listOf(
                Node("Hello <Hitanshu>")
            ),
            testStrings.getValue(4).tokenize().parse()
        )
    }

    @Test
    fun test005() {
        assertEquals(
            listOf(
                Node("Hello :Hitanshu:")
            ),
            testStrings.getValue(5).tokenize().parse()
        )
    }

    @Test
    fun test006() {
        assertEquals(
            listOf(
                Node("Hello |Hitanshu|")
            ),
            testStrings.getValue(6).tokenize().parse()
        )
    }

    @Test
    fun test007() {
        assertEquals(
            listOf(
                Node("Hello ;Hitanshu;")
            ),
            testStrings.getValue(7).tokenize().parse()
        )
    }

    @Test
    fun test008() {
        assertEquals(
            listOf(
                Node("Hello /Hitanshu/")
            ),
            testStrings.getValue(8).tokenize().parse()
        )
    }

    @Test
    fun test009() {
        assertEquals(
            listOf(
                Node("Hello </Hitanshu/>")
            ),
            testStrings.getValue(9).tokenize().parse()
        )
    }

    @Test
    fun test010() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(10).tokenize().parse()
        )
    }

    @Test
    fun test011() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(11).tokenize().parse()
        )
    }

    @Test
    fun test012() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(12).tokenize().parse()
        )
    }

    @Test
    fun test013() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(13).tokenize().parse()
        )
    }

    @Test
    fun test014() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(14).tokenize().parse()
        )
    }

    @Test
    fun test015() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(15).tokenize().parse()
        )
    }

    @Test
    fun test016() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(16).tokenize().parse()
        )
    }

    @Test
    fun test017() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(17).tokenize().parse()
        )
    }

    @Test
    fun test018() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(18).tokenize().parse()
        )
    }

    @Test
    fun test019() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(19).tokenize().parse()
        )
    }

    @Test
    fun test020() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(20).tokenize().parse()
        )
    }

    @Test
    fun test021() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(21).tokenize().parse()
        )
    }

    @Test
    fun test022() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(22).tokenize().parse()
        )
    }

    @Test
    fun test023() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(23).tokenize().parse()
        )
    }

    @Test
    fun test024() {
        assertEquals(
            listOf(
                Node("  "),
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(
                    "Dhawan",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("  ")
            ),
            testStrings.getValue(24).tokenize().parse()
        )
    }

    @Test
    fun test025() {
        assertEquals(
            listOf(
                Node(" {"),
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(
                    "Dhawan",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("} ")
            ),
            testStrings.getValue(25).tokenize().parse()
        )
    }

    @Test
    fun test026() {
        assertEquals(
            listOf(
                Node("{"),
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("}{"),
                Node(
                    "Dhawan",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("}")
            ),
            testStrings.getValue(26).tokenize().parse()
        )
    }

    @Test
    fun test027() {
        assertEquals(
            listOf(
                Node("   "),
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(" "),
                Node(
                    "Dhawan",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("   ")
            ),
            testStrings.getValue(27).tokenize().parse()
        )
    }

    @Test
    fun test028() {
        assertEquals(
            listOf(
                Node("  {"),
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(" "),
                Node(
                    "Dhawan",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("}  ")
            ),
            testStrings.getValue(28).tokenize().parse()
        )
    }

    @Test
    fun test029() {
        assertEquals(
            listOf(
                Node(" {"),
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("} {"),
                Node(
                    "Dhawan",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("} ")
            ),
            testStrings.getValue(29).tokenize().parse()
        )
    }

    @Test
    fun test030() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu Dhawan : Android Developer",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(30).tokenize().parse()
        )
    }

    @Test
    fun test031() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu Dhawan | Android Developer",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(31).tokenize().parse()
        )
    }

    @Test
    fun test032() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu Dhawan ; Android Developer",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(32).tokenize().parse()
        )
    }

    @Test
    fun test033() {
        assertEquals(
            listOf(
                Node("Hello "),
                Node(
                    "Hitanshu Dhawan",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(", How are you bro?")
            ),
            testStrings.getValue(33).tokenize().parse()
        )
    }

    @Test
    fun test034() {
        assertEquals(
            listOf(
                Node("Hello "),
                Node(
                    "Hitanshu Dhawan",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(", How are you "),
                Node(
                    "bro",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("?")
            ),
            testStrings.getValue(34).tokenize().parse()
        )
    }

    @Test
    fun test035() {
        assertEquals(
            listOf(
                Node("Hello "),
                Node(
                    " Hitanshu Dhawan ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(", How are you bro?")
            ),
            testStrings.getValue(35).tokenize().parse()
        )
    }

    @Test
    fun test036() {
        assertEquals(
            listOf(
                Node("Hello "),
                Node(
                    " Hitanshu Dhawan ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(", How are you "),
                Node(
                    " bro ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("?")
            ),
            testStrings.getValue(36).tokenize().parse()
        )
    }

    @Test
    fun test037() {
        assertEquals(
            listOf(
                Node("Hello "),
                Node(
                    "    ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(37).tokenize().parse()
        )
    }

    @Test
    fun test038() {
        assertEquals(
            listOf(
                Node("Hello "),
                Node(
                    "",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(38).tokenize().parse()
        )
    }

    @Test
    fun test039() {
        assertEquals(
            listOf(
                Node("Hello   `Hitanshu` < a : b | c ; d : e /> }")
            ),
            testStrings.getValue(39).tokenize().parse()
        )
    }

    @Test
    fun test040() {
        assertEquals(
            listOf(
                Node("Hello {  Hitanshu` < a : b | c ; d : e /> }")
            ),
            testStrings.getValue(40).tokenize().parse()
        )
    }

    @Test
    fun test041() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu  < a : b | c ; d : e /> }")
            ),
            testStrings.getValue(41).tokenize().parse()
        )
    }

    @Test
    fun test042() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu`   a : b | c ; d : e /> }")
            ),
            testStrings.getValue(42).tokenize().parse()
        )
    }

    @Test
    fun test043() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` <   : b | c ; d : e /> }")
            ),
            testStrings.getValue(43).tokenize().parse()
        )
    }

    @Test
    fun test044() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a   b | c ; d : e /> }")
            ),
            testStrings.getValue(44).tokenize().parse()
        )
    }

    @Test
    fun test045() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a :   | c ; d : e /> }")
            ),
            testStrings.getValue(45).tokenize().parse()
        )
    }

    @Test
    fun test046() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b   c ; d : e /> }")
            ),
            testStrings.getValue(46).tokenize().parse()
        )
    }

    @Test
    fun test047() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b |   ; d : e /> }")
            ),
            testStrings.getValue(47).tokenize().parse()
        )
    }

    @Test
    fun test048() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c   d : e /> }")
            ),
            testStrings.getValue(48).tokenize().parse()
        )
    }

    @Test
    fun test049() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ;   : e /> }")
            ),
            testStrings.getValue(49).tokenize().parse()
        )
    }

    @Test
    fun test050() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d   e /> }")
            ),
            testStrings.getValue(50).tokenize().parse()
        )
    }

    @Test
    fun test051() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d :   /> }")
            ),
            testStrings.getValue(51).tokenize().parse()
        )
    }

    @Test
    fun test052() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e  > }")
            ),
            testStrings.getValue(52).tokenize().parse()
        )
    }

    @Test
    fun test053() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e /  }")
            ),
            testStrings.getValue(53).tokenize().parse()
        )
    }

    @Test
    fun test054() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e    }")
            ),
            testStrings.getValue(54).tokenize().parse()
        )
    }

    @Test
    fun test055() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e />  ")
            ),
            testStrings.getValue(55).tokenize().parse()
        )
    }

    @Test
    fun test056() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e | /> }")
            ),
            testStrings.getValue(56).tokenize().parse()
        )
    }

    @Test
    fun test057() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e ; /> }")
            ),
            testStrings.getValue(57).tokenize().parse()
        )
    }

    @Test
    fun test058() {
        assertEquals(
            listOf(
                Node("Hello "),
                Node(
                    "    ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(", How are you bro?")
            ),
            testStrings.getValue(58).tokenize().parse()
        )
    }

    @Test
    fun test059() {
        assertEquals(
            listOf(
                Node("Hello "),
                Node(
                    "",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(", How are you bro?")
            ),
            testStrings.getValue(59).tokenize().parse()
        )
    }

    @Test
    fun test060() {
        assertEquals(
            listOf(
                Node("Hello   `Hitanshu` < a : b | c ; d : e /> }, How are you bro?")
            ),
            testStrings.getValue(60).tokenize().parse()
        )
    }

    @Test
    fun test061() {
        assertEquals(
            listOf(
                Node("Hello {  Hitanshu` < a : b | c ; d : e /> }, How are you bro?")
            ),
            testStrings.getValue(61).tokenize().parse()
        )
    }

    @Test
    fun test062() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu  < a : b | c ; d : e /> }, How are you bro?")
            ),
            testStrings.getValue(62).tokenize().parse()
        )
    }

    @Test
    fun test063() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu`   a : b | c ; d : e /> }, How are you bro?")
            ),
            testStrings.getValue(63).tokenize().parse()
        )
    }

    @Test
    fun test064() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` <   : b | c ; d : e /> }, How are you bro?")
            ),
            testStrings.getValue(64).tokenize().parse()
        )
    }

    @Test
    fun test065() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a   b | c ; d : e /> }, How are you bro?")
            ),
            testStrings.getValue(65).tokenize().parse()
        )
    }

    @Test
    fun test066() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a :   | c ; d : e /> }, How are you bro?")
            ),
            testStrings.getValue(66).tokenize().parse()
        )
    }

    @Test
    fun test067() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b   c ; d : e /> }, How are you bro?")
            ),
            testStrings.getValue(67).tokenize().parse()
        )
    }

    @Test
    fun test068() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b |   ; d : e /> }, How are you bro?")
            ),
            testStrings.getValue(68).tokenize().parse()
        )
    }

    @Test
    fun test069() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c   d : e /> }, How are you bro?")
            ),
            testStrings.getValue(69).tokenize().parse()
        )
    }

    @Test
    fun test070() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ;   : e /> }, How are you bro?")
            ),
            testStrings.getValue(70).tokenize().parse()
        )
    }

    @Test
    fun test071() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d   e /> }, How are you bro?")
            ),
            testStrings.getValue(71).tokenize().parse()
        )
    }

    @Test
    fun test072() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d :   /> }, How are you bro?")
            ),
            testStrings.getValue(72).tokenize().parse()
        )
    }

    @Test
    fun test073() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e  > }, How are you bro?")
            ),
            testStrings.getValue(73).tokenize().parse()
        )
    }

    @Test
    fun test074() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e /  }, How are you bro?")
            ),
            testStrings.getValue(74).tokenize().parse()
        )
    }

    @Test
    fun test075() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e    }, How are you bro?")
            ),
            testStrings.getValue(75).tokenize().parse()
        )
    }

    @Test
    fun test076() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e />  , How are you bro?")
            ),
            testStrings.getValue(76).tokenize().parse()
        )
    }

    @Test
    fun test077() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e | /> }, How are you bro?")
            ),
            testStrings.getValue(77).tokenize().parse()
        )
    }

    @Test
    fun test078() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e ; /> }, How are you bro?")
            ),
            testStrings.getValue(78).tokenize().parse()
        )
    }

    @Test
    fun test079() {
        assertEquals(
            listOf(
                Node(
                    "{",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(79).tokenize().parse()
        )
    }

    @Test
    fun test080() {
        assertEquals(
            listOf(
                Node("{  ```  <a:b|c;d:e/> }")
            ),
            testStrings.getValue(80).tokenize().parse()
        )
    }

    @Test
    fun test081() {
        assertEquals(
            listOf(
                Node(
                    "<",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(81).tokenize().parse()
        )
    }

    @Test
    fun test082() {
        assertEquals(
            listOf(
                Node(
                    ":",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(82).tokenize().parse()
        )
    }

    @Test
    fun test083() {
        assertEquals(
            listOf(
                Node(
                    "|",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(83).tokenize().parse()
        )
    }

    @Test
    fun test084() {
        assertEquals(
            listOf(
                Node(
                    ";",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(84).tokenize().parse()
        )
    }

    @Test
    fun test085() {
        assertEquals(
            listOf(
                Node(
                    "/>",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(85).tokenize().parse()
        )
    }

    @Test
    fun test086() {
        assertEquals(
            listOf(
                Node(
                    "}",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(86).tokenize().parse()
        )
    }

    @Test
    fun test087() {
        assertEquals(
            listOf(
                Node(
                    " { ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(87).tokenize().parse()
        )
    }

    @Test
    fun test088() {
        assertEquals(
            listOf(
                Node("{  ` ` `  <a:b|c;d:e/> }")
            ),
            testStrings.getValue(88).tokenize().parse()
        )
    }

    @Test
    fun test089() {
        assertEquals(
            listOf(
                Node(
                    " < ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(89).tokenize().parse()
        )
    }

    @Test
    fun test090() {
        assertEquals(
            listOf(
                Node(
                    " : ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(90).tokenize().parse()
        )
    }

    @Test
    fun test091() {
        assertEquals(
            listOf(
                Node(
                    " | ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(91).tokenize().parse()
        )
    }

    @Test
    fun test092() {
        assertEquals(
            listOf(
                Node(
                    " ; ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(92).tokenize().parse()
        )
    }

    @Test
    fun test093() {
        assertEquals(
            listOf(
                Node(
                    " /> ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(93).tokenize().parse()
        )
    }

    @Test
    fun test094() {
        assertEquals(
            listOf(
                Node(
                    " } ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(94).tokenize().parse()
        )
    }

    @Test
    fun test095() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b | c ; d : e : f /> }, How are you bro?")
            ),
            testStrings.getValue(95).tokenize().parse()
        )
    }

    @Test
    fun test096() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a   b   c   d   e   f /> }, How are you bro?")
            ),
            testStrings.getValue(96).tokenize().parse()
        )
    }

    @Test
    fun test097() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a : b : c : d : e : f /> }, How are you bro?")
            ),
            testStrings.getValue(97).tokenize().parse()
        )
    }

    @Test
    fun test098() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a | b | c | d | e | f /> }, How are you bro?")
            ),
            testStrings.getValue(98).tokenize().parse()
        )
    }

    @Test
    fun test099() {
        assertEquals(
            listOf(
                Node("Hello { `Hitanshu` < a ; b ; c ; d ; e ; f /> }, How are you bro?")
            ),
            testStrings.getValue(99).tokenize().parse()
        )
    }

    @Test
    fun test100() {
        assertEquals(
            listOf(
                Node("Hello   Hitanshu < a : b | c ; d : e />  , How are you bro?")
            ),
            testStrings.getValue(100).tokenize().parse()
        )
    }

    @Test
    fun test101() {
        assertEquals(
            listOf(
                Node("Hello { Hitanshu < a : b | c ; d : e /> }, How are you bro?")
            ),
            testStrings.getValue(101).tokenize().parse()
        )
    }

    @Test
    fun test102() {
        assertEquals(
            listOf(
                Node("{{"),
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(
                    "Dhawan",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("}}")
            ),
            testStrings.getValue(102).tokenize().parse()
        )
    }

    @Test
    fun test103() {
        assertEquals(
            listOf(
                Node("{{{"),
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(
                    "Dhawan",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("}}}")
            ),
            testStrings.getValue(103).tokenize().parse()
        )
    }

    @Test
    fun test104() {
        assertEquals(
            listOf(
                Node("Hello { < a : b | c ; d : e /> }, How are you bro?")
            ),
            testStrings.getValue(104).tokenize().parse()
        )
    }

    @Test
    fun test105() {
        assertEquals(
            listOf(
                Node(
                    "'",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(105).tokenize().parse()
        )
    }

    @Test
    fun test106() {
        assertEquals(
            listOf(
                Node(
                    " ' ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                )
            ),
            testStrings.getValue(106).tokenize().parse()
        )
    }

    @Test
    fun test107() {
        assertEquals(
            listOf(
                Node("Hello "),
                Node(
                    "Hitanshu's Friend",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(", How are you "),
                Node(
                    "bro",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("?")
            ),
            testStrings.getValue(107).tokenize().parse()
        )
    }

    @Test
    fun test108() {
        assertEquals(
            listOf(
                Node("Hello "),
                Node(
                    " Hitanshu's Friend ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node(", How are you "),
                Node(
                    " bro ",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "e")
                    )
                ),
                Node("?")
            ),
            testStrings.getValue(108).tokenize().parse()
        )
    }

    @Test
    fun test109() {
        assertEquals(
            listOf(
                Node("{ `Google` < a : b | c ; d :  https://www.google.com   /> }")
            ),
            testStrings.getValue(109).tokenize().parse()
        )
    }

    @Test
    fun test110() {
        assertEquals(
            listOf(
                Node("{ `Google` < a : b | c ; d :  https://www.google.com/  /> }")
            ),
            testStrings.getValue(110).tokenize().parse()
        )
    }

    @Test
    fun test111() {
        assertEquals(
            listOf(
                Node(
                    "Google",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "https://www.google.com")
                    )
                )
            ),
            testStrings.getValue(111).tokenize().parse()
        )
    }

    @Test
    fun test112() {
        assertEquals(
            listOf(
                Node(
                    "Google",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "https://www.google.com/")
                    )
                )
            ),
            testStrings.getValue(112).tokenize().parse()
        )
    }

    @Test
    fun test113() {
        assertEquals(
            listOf(
                Node(
                    "Google",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "www"),
                        Declaration("d", "www")
                    )
                )
            ),
            testStrings.getValue(113).tokenize().parse()
        )
    }

    @Test
    fun test114() {
        assertEquals(
            listOf(
                Node(
                    "Google",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "www|www")
                    )
                )
            ),
            testStrings.getValue(114).tokenize().parse()
        )
    }

    @Test
    fun test115() {
        assertEquals(
            listOf(
                Node("{ `Google` < a : b | c ; d :  www;www   /> }")
            ),
            testStrings.getValue(115).tokenize().parse()
        )
    }

    @Test
    fun test116() {
        assertEquals(
            listOf(
                Node(
                    "Google",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "www;www")
                    )
                )
            ),
            testStrings.getValue(116).tokenize().parse()
        )
    }

    @Test
    fun test117() {
        assertEquals(
            listOf(
                Node(
                    "Google",
                    listOf(
                        Declaration("a", "b"),
                        Declaration("a", "c"),
                        Declaration("d", "https://www.one.com"),
                        Declaration("d", "https://www.two.com"),
                        Declaration("e", "https://www.three.com")
                    )
                )
            ),
            testStrings.getValue(117).tokenize().parse()
        )
    }

    @Test
    fun test118() {
        assertEquals(
            listOf(
                Node("{`Hitanshu``Dhawan`<a:b|c;d:e/>}")
            ),
            testStrings.getValue(118).tokenize().parse()
        )
    }

    @Test
    fun test119() {
        assertEquals(
            listOf(
                Node("{ `Hitanshu` `Dhawan` < a : b | c ; d : e /> }")
            ),
            testStrings.getValue(119).tokenize().parse()
        )
    }

    @Test
    fun test120() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("property", "v a l u e")
                    )
                )
            ),
            testStrings.getValue(120).tokenize().parse()
        )
    }

    @Test
    fun test121() {
        assertEquals(
            listOf(
                Node(
                    "Hitanshu",
                    listOf(
                        Declaration("property", " v a l u e ")
                    )
                )
            ),
            testStrings.getValue(121).tokenize().parse()
        )
    }

}
