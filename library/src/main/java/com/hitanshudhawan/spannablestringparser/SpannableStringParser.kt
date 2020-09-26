package com.hitanshudhawan.spannablestringparser

// SpannableStringParser

private var customSpanner: (String, String) -> Any? = { _, _ -> null }

/**
 * Add custom properties to the Spanner.
 */
public fun spanner(spanner: (property: String, value: String) -> Any?) {
    customSpanner = spanner
}

/**
 * Converts a String into SpannableString.
 */
public fun String.spannify(): CharSequence = tokenize().parse().spannify(customSpanner)

/**
 * Add properties and values to a text.
 * Make sure to call [spannify] method afterwards for converting it to SpannableString.
 */
public fun String.property(property: String, vararg values: String): String = addProperty(property, values.toList())
