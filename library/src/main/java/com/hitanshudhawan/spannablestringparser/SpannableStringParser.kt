package com.hitanshudhawan.spannablestringparser


// SpannableStringParser

fun String.spannify() = tokenize().parse().spannify()