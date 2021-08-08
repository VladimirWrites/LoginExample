package dev.vladimirj.login.domain.entity

sealed class LoginResult {
    data class Successful(val uid: String, val email: String): LoginResult()
    data class Error(val message: String): LoginResult()
}