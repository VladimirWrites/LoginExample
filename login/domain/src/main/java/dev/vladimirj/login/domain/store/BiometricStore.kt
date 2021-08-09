package dev.vladimirj.login.domain.store

interface BiometricStore {
    fun isAuthenticationSupported(): Boolean
}