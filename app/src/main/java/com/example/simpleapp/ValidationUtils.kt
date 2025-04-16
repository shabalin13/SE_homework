package com.example.simpleapp

fun validateLogin(email: String, password: String): LoginValidationResult {
    val emailValid = isValidEmail(email)
    val passwordValid = password.isNotBlank()
    return LoginValidationResult(emailValid, passwordValid)
}

fun isValidEmail(email: String): Boolean {
    return Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$").matches(email)
}

data class LoginValidationResult(
    val isEmailValid: Boolean,
    val isPasswordValid: Boolean
)
