package dev.vladimirj.login.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import dev.vladimirj.login.domain.store.CryptographicStore

import org.junit.Test
import javax.crypto.Cipher

class GetCipherForEncryptionShould {

    private val cryptographicStore = mock<CryptographicStore>()
    private val getCipherForEncryption = GetCipherForEncryption(cryptographicStore)
    private val cipher = mock<Cipher>()

    @Test
    fun useCorrectKey_toRetrieveCipherForEncryption_fromCryptographicStore() {
        whenever(cryptographicStore.getInitializedCipherForEncryption(KEY_NAME)).thenReturn(cipher)

        val result = getCipherForEncryption()

        verify(cryptographicStore).getInitializedCipherForEncryption(KEY_NAME)
        assertThat(result).isEqualTo(cipher)
    }
}