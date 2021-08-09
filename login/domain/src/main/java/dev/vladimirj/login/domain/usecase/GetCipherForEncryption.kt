package dev.vladimirj.login.domain.usecase

import dev.vladimirj.login.domain.store.CryptographicStore
import javax.crypto.Cipher
import javax.inject.Inject

class GetCipherForEncryption @Inject constructor(
    private val cryptographicStore: CryptographicStore
) {
    operator fun invoke(): Cipher {
        return cryptographicStore.getInitializedCipherForEncryption(KEY_NAME)
    }
}