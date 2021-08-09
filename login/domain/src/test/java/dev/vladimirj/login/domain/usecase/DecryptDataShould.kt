package dev.vladimirj.login.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import dev.vladimirj.login.domain.entity.CiphertextWrapper
import dev.vladimirj.login.domain.store.CryptographicStore
import org.junit.Test
import javax.crypto.Cipher

class DecryptDataShould {

    private val cryptographicStore = mock<CryptographicStore>()
    private val decryptData = DecryptData(cryptographicStore)

    private val cipher = mock<Cipher>()

    private val ciphertextWrapper = CiphertextWrapper(
        byteArrayOf(1),
        byteArrayOf(2)
    )

    @Test
    fun decryptDataFromCryptographicStore() {
        whenever(cryptographicStore.decryptData(ciphertextWrapper.ciphertext, cipher)).thenReturn("data")
        whenever(cryptographicStore.getCiphertextWrapperFromSharedPrefs()).thenReturn(ciphertextWrapper)

        val result = decryptData(cipher)

        verify(cryptographicStore).decryptData(ciphertextWrapper.ciphertext, cipher)
        assertThat(result).isEqualTo("data")
    }
}