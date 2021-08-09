package dev.vladimirj.login.domain.usecase

import dev.vladimirj.login.domain.store.BiometricStore
import javax.inject.Inject

class IsAuthenticationSupported @Inject constructor(
    private val biometricStore: BiometricStore
) {
    operator fun invoke(): Boolean = biometricStore.isAuthenticationSupported()
}