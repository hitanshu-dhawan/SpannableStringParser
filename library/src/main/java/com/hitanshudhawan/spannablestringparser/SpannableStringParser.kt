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
public fun CharSequence.spannify(): CharSequence = tokenize().parse().spannify(customSpanner)
