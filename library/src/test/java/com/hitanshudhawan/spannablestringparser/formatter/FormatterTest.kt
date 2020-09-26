package com.hitanshudhawan.spannablestringparser.formatter

import com.hitanshudhawan.spannablestringparser.property
import org.junit.Assert.assertEquals
import org.junit.Test

internal class FormatterTest {

    @Test
    fun `text having single property with single value`() {
        assertEquals(
            "{ `Hitanshu Dhawan` <text-color:#0000FF/> }",
            "Hitanshu Dhawan".property("text-color", "#0000FF")
        )
    }

    @Test
    fun `text having single property with multiple values`() {
        assertEquals(
            "{ `Hitanshu Dhawan` <text-decoration:underline|strike-through/> }",
            "Hitanshu Dhawan".property("text-decoration", "underline", "strike-through")
        )
    }

    @Test
    fun `text having multiple properties with single value`() {
        assertEquals(
            "{ `Hitanshu Dhawan` <text-color:#0000FF;text-decoration:underline/> }",
            "Hitanshu Dhawan".property("text-color", "#0000FF").property("text-decoration", "underline")
        )
        assertEquals(
            "{ `Hitanshu Dhawan` <text-decoration:underline;text-color:#0000FF/> }",
            "Hitanshu Dhawan".property("text-decoration", "underline").property("text-color", "#0000FF")
        )
    }

    @Test
    fun `text having multiple properties with multiple values`() {
        assertEquals(
            "{ `Hitanshu Dhawan` <text-color:#0000FF;text-decoration:underline|strike-through/> }",
            "Hitanshu Dhawan".property("text-color", "#0000FF").property("text-decoration", "underline", "strike-through")
        )
        assertEquals(
            "{ `Hitanshu Dhawan` <text-decoration:strike-through|underline;text-color:#0000FF/> }",
            "Hitanshu Dhawan".property("text-decoration", "strike-through", "underline").property("text-color", "#0000FF")
        )
    }

    //

    @Test(expected = IllegalArgumentException::class)
    fun `text having single invalid property with single value`() {
        "Hitanshu Dhawan".property("text color", "#0000FF")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having single invalid property with multiple values`() {
        "Hitanshu Dhawan".property("text decoration", "underline", "strike-through")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having multiple invalid properties with single value`() {
        "Hitanshu Dhawan".property("text color", "#0000FF").property("text decoration", "underline")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having multiple invalid properties with multiple values`() {
        "Hitanshu Dhawan".property("text color", "#0000FF").property("text decoration", "underline", "strike-through")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having single empty property with single value`() {
        "Hitanshu Dhawan".property("", "#0000FF")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having single empty property with multiple values`() {
        "Hitanshu Dhawan".property("", "underline", "strike-through")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having multiple empty properties with single value`() {
        "Hitanshu Dhawan".property("", "#0000FF").property("", "underline")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having multiple empty properties with multiple values`() {
        "Hitanshu Dhawan".property("", "#0000FF").property("", "underline", "strike-through")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having single blank property with single value`() {
        "Hitanshu Dhawan".property("  ", "#0000FF")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having single blank property with multiple values`() {
        "Hitanshu Dhawan".property("  ", "underline", "strike-through")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having multiple blank properties with single value`() {
        "Hitanshu Dhawan".property("  ", "#0000FF").property("  ", "underline")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having multiple blank properties with multiple values`() {
        "Hitanshu Dhawan".property("  ", "#0000FF").property("  ", "underline", "strike-through")
    }

    //

    @Test
    fun `text having single property with single invalid value`() {
        assertEquals(
            "{ `Hitanshu Dhawan` <url:`https://www.google.com`/> }",
            "Hitanshu Dhawan".property("url", "https://www.google.com")
        )
    }

    @Test
    fun `text having single property with multiple invalid values`() {
        assertEquals(
            "{ `Hitanshu Dhawan` <text-decoration:underline|`strike through`/> }",
            "Hitanshu Dhawan".property("text-decoration", "underline", "strike through")
        )
    }

    @Test
    fun `text having multiple properties with single invalid value`() {
        assertEquals(
            "{ `Hitanshu Dhawan` <url:`https://www.google.com`;text-decoration:underline/> }",
            "Hitanshu Dhawan".property("url", "https://www.google.com").property("text-decoration", "underline")
        )
        assertEquals(
            "{ `Hitanshu Dhawan` <text-decoration:underline;url:`https://www.google.com`/> }",
            "Hitanshu Dhawan".property("text-decoration", "underline").property("url", "https://www.google.com")
        )
    }

    @Test
    fun `text having multiple properties with multiple invalid values`() {
        assertEquals(
            "{ `Hitanshu Dhawan` <url:`https://www.google.com`;text-decoration:underline|`strike through`/> }",
            "Hitanshu Dhawan".property("url", "https://www.google.com").property("text-decoration", "underline", "strike through")
        )
        assertEquals(
            "{ `Hitanshu Dhawan` <text-decoration:`strike through`|underline;url:`https://www.google.com`/> }",
            "Hitanshu Dhawan".property("text-decoration", "strike through", "underline").property("url", "https://www.google.com")
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having single property with single empty value`() {
        "Hitanshu Dhawan".property("url", "")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having single property with multiple empty values`() {
        "Hitanshu Dhawan".property("text-decoration", "", "")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having multiple properties with single empty value`() {
        "Hitanshu Dhawan".property("url", "").property("text-decoration", "")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having multiple properties with multiple empty values`() {
        "Hitanshu Dhawan".property("url", "").property("text-decoration", "", "")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having single property with single blank value`() {
        "Hitanshu Dhawan".property("url", "  ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having single property with multiple blank values`() {
        "Hitanshu Dhawan".property("text-decoration", "  ", "  ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having multiple properties with single blank value`() {
        "Hitanshu Dhawan".property("url", "  ").property("text-decoration", "  ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `text having multiple properties with multiple blank values`() {
        "Hitanshu Dhawan".property("url", "  ").property("text-decoration", "  ", "  ")
    }

    //

    @Test(expected = IllegalArgumentException::class)
    fun `text having property with no value`() {
        "Hitanshu Dhawan".property("text-color")
    }

    @Test
    fun `text having empty string`() {
        assertEquals(
            "",
            "".property("text-color", "#0000FF")
        )
        assertEquals(
            "",
            "".property("text-color", "#0000FF").property("text-decoration", "underline", "strike-through")
        )
    }

    @Test
    fun `text having blank string`() {
        assertEquals(
            "  ",
            "  ".property("text-color", "#0000FF")
        )
        assertEquals(
            "  ",
            "  ".property("text-color", "#0000FF").property("text-decoration", "underline", "strike-through")
        )
    }
}
