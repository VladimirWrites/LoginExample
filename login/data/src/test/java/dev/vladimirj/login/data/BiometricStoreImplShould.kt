package dev.vladimirj.login.data

import androidx.biometric.BiometricManager
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test

class BiometricStoreImplShould {

    private val biometricManager = mock<BiometricManager>()
    private val biometricStoreImpl = BiometricStoreImpl(biometricManager)

    @Test
    fun returnAuthenticationSupported_whenBiometricManagerCanAuthenticate() {
        whenever(biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK))
            .thenReturn(BiometricManager.BIOMETRIC_SUCCESS)

        assertThat(biometricStoreImpl.isAuthenticationSupported()).isTrue()
    }

    @Test
    fun returnAuthenticationNotSupported_whenBiometricManagerCanNotAuthenticate() {
        whenever(biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK))
            .thenReturn(BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE)

        assertThat(biometricStoreImpl.isAuthenticationSupported()).isFalse()
    }
}