package dev.vladimirj.login.domain.usecase

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import dev.vladimirj.login.domain.entity.CiphertextWrapper
import dev.vladimirj.login.domain.store.CryptographicStore
import org.junit.Test
import javax.crypto.Cipher


class EncryptAndSaveUidShould {
    private val cryptographicStore = mock<CryptographicStore>()
    private val encryptData = mock<EncryptData>()
    private val encryptAndSaveUid = EncryptAndSaveUid(cryptographicStore, encryptData)

    private val cipher = mock<Cipher>()

    private val ciphertextWrapper = CiphertextWrapper(
        byteArrayOf(1),
        byteArrayOf(2)
    )

    @Test
    fun encryptData_fromCryptographicStore_usingEncryptData_andSaveThem() {
        whenever(encryptData.invoke("uid", cipher)).thenReturn(ciphertextWrapper)

        encryptAndSaveUid("uid", cipher)

        verify(cryptographicStore).persistCiphertextWrapperToSharedPrefs(ciphertextWrapper)
    }
}