package com.hitanshudhawan.spannablestringparser

import android.widget.TextView


// SpannableStringParser

private var customSpanner: (String, String) -> Any? = { _, _ -> }

fun spanner(spanner: (property: String, value: String) -> Any?) {
    customSpanner = spanner
}

fun String.spannify() = tokenize().parse().spannify(customSpanner)

fun TextView.spannify(text: String) = setText(text.spannify())