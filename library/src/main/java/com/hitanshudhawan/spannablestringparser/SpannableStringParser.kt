package com.hitanshudhawan.spannablestringparser

// SpannableStringParser

private var customSpanner: (String, String) -> Any? = { _, _ -> null }

/**
 * Add custom properties to span.
 */
public fun spanner(spanner: (property: String, value: String) -> Any?) {
    customSpanner = spanner
}

/**
 * Converts a String into SpannableString.
 */
public fun String.spannify(): CharSequence = tokenize().parse().spannify(customSpanner)

/**
 * Add property to text.
 */
public fun String.property(property: String, vararg values: String): String = addProperty(property, values.toList())

// TODO : Improve Documentation (K-Doc)
