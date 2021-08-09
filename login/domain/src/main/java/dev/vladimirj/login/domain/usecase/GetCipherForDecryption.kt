package dev.vladimirj.login.domain.usecase

import dev.vladimirj.login.domain.store.CryptographicStore
import javax.crypto.Cipher
import javax.inject.Inject

class GetCipherForDecryption @Inject constructor(
    private val cryptographicStore: CryptographicStore
) {
    operator fun invoke(): Cipher {
        val ciphertextWrapper = cryptographicStore.getCiphertextWrapperFromSharedPrefs()
        return cryptographicStore.getInitializedCipherForDecryption(KEY_NAME, ciphertextWrapper!!.initializationVector)
    }
}