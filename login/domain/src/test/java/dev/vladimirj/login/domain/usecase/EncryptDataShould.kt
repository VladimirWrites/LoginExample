package dev.vladimirj.login.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import dev.vladimirj.login.domain.entity.CiphertextWrapper
import dev.vladimirj.login.domain.store.CryptographicStore
import org.junit.Test
import javax.crypto.Cipher

class EncryptDataShould {

    private val cryptographicStore = mock<CryptographicStore>()
    private val encryptData = EncryptData(cryptographicStore)
    private val cipher = mock<Cipher>()
    private val ciphertextWrapper = CiphertextWrapper(
        byteArrayOf(1),
        byteArrayOf(2)
    )

    @Test
    fun useCryptographicStore_toEncryptData() {
        whenever(cryptographicStore.encryptData("data", cipher)).thenReturn(ciphertextWrapper)

        val result = encryptData("data", cipher)

        verify(cryptographicStore).encryptData("data", cipher)
        assertThat(result).isEqualTo(ciphertextWrapper)
    }
}