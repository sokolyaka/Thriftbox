package thriftbox.mobile.domain.auth

import kotlin.math.round

fun defineStrength(password: String): Int {
    var strength = 0
    if (password.length >= 8) {
        strength += 1
    }
    if (password.contains(Regex("[A-Z]"))) {
        strength += 1
    }
    if (password.contains(Regex("[a-z]"))) {
        strength += 1
    }
    if (password.contains(Regex("[\\d]"))) {
        strength += 1
    }
    if (password.contains(Regex("-"))) {
        strength += 1
    }
    if (password.contains(Regex("_"))) {
        strength += 1
    }
    if (password.contains(Regex("\\s"))) {
        strength += 1
    }
    if (password.contains(Regex("[!@#$%^&*~\'\"/]"))) {
        strength += 1
    }
    if (password.length < 8) {
        strength = 0
    }

    return strength
}

fun defineStrengthIn100Range(password: String): Int {
    return round(100.0 / 8 * defineStrength(password)).toInt()
}
