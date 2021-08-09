package dev.vladimirj.login.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import dev.vladimirj.login.domain.entity.CiphertextWrapper
import dev.vladimirj.login.domain.store.CryptographicStore

import org.junit.Test
import javax.crypto.Cipher

class GetCipherForDecryptionShould {

    private val cryptographicStore = mock<CryptographicStore>()
    private val getCipherForDecryption = GetCipherForDecryption(cryptographicStore)
    private val cipher = mock<Cipher>()
    private val ciphertextWrapper = CiphertextWrapper(
        byteArrayOf(1),
        byteArrayOf(2)
    )

    @Test
    fun useCorrectData_toRetrieveCipherForEncryption_fromCryptographicStore() {
        whenever(cryptographicStore.getCiphertextWrapperFromSharedPrefs()).thenReturn(ciphertextWrapper)

        whenever(cryptographicStore.getInitializedCipherForDecryption(KEY_NAME, ciphertextWrapper.initializationVector)).thenReturn(cipher)

        val result = getCipherForDecryption()

        verify(cryptographicStore).getInitializedCipherForDecryption(KEY_NAME, ciphertextWrapper.initializationVector)
        assertThat(result).isEqualTo(cipher)
    }
}