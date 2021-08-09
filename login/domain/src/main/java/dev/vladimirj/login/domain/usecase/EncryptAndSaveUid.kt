package dev.vladimirj.login.domain.usecase

import dev.vladimirj.login.domain.store.CryptographicStore
import javax.crypto.Cipher
import javax.inject.Inject

class EncryptAndSaveUid @Inject constructor(
    private val cryptographicStore: CryptographicStore,
    private val encryptData: EncryptData
) {
    operator fun invoke(uid: String, cipher: Cipher) {
        val ciphertextWrapper = encryptData(uid, cipher)
        cryptographicStore.persistCiphertextWrapperToSharedPrefs(ciphertextWrapper)
    }
}