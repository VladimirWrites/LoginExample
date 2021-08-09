package dev.vladimirj.login.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import dev.vladimirj.login.domain.store.BiometricStore
import org.junit.Test


class IsAuthenticationSupportedShould {

    private val biometricStore = mock<BiometricStore>()
    private val isAuthenticationSupported = IsAuthenticationSupported(biometricStore)

    @Test
    fun returnTrue_ifAuthenticationIsSupported_byBiometricStore() {
        whenever(biometricStore.isAuthenticationSupported()).thenReturn(true)

        assertThat(isAuthenticationSupported()).isTrue()
    }

    @Test
    fun returnFalse_ifAuthenticationIsNotSupported_byBiometricStore() {
        whenever(biometricStore.isAuthenticationSupported()).thenReturn(false)

        assertThat(isAuthenticationSupported()).isFalse()
    }
}