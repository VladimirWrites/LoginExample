package dev.vladimirj.login.domain.usecase

import dev.vladimirj.login.domain.entity.CiphertextWrapper
import dev.vladimirj.login.domain.store.CryptographicStore
import javax.crypto.Cipher
import javax.inject.Inject

class EncryptData @Inject constructor(
    private val cryptographicStore: CryptographicStore
) {
    operator fun invoke(plaintext: String, cipher: Cipher): CiphertextWrapper {
        return cryptographicStore.encryptData(plaintext, cipher)
    }
}