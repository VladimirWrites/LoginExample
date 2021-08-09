package dev.vladimirj.login.data

import androidx.biometric.BiometricManager
import dev.vladimirj.login.domain.store.BiometricStore

class BiometricStoreImpl(private val biometricManager: BiometricManager) : BiometricStore {
    override fun isAuthenticationSupported(): Boolean =
        biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK) == BiometricManager.BIOMETRIC_SUCCESS
}