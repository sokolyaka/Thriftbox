package thriftbox.mobile.domain.auth

import java.util.regex.Pattern

class VerifyEmailUseCase(
    private val pattern: Pattern
) {
    fun verify(email: String): Boolean {
        return pattern.matcher(email).matches()
    }
}