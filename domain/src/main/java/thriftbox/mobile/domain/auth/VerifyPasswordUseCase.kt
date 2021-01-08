package thriftbox.mobile.domain.auth

class VerifyPasswordUseCase {
    fun verify(password: String): Boolean {
        return defineStrengthIn100Range(password) > 50
    }

}