package dev.vladimirj.login.domain.usecase

import dev.vladimirj.login.domain.store.CryptographicStore
import javax.crypto.Cipher
import javax.inject.Inject

class DecryptData @Inject constructor(
    private val cryptographicStore: CryptographicStore
) {
    operator fun invoke(cipher: Cipher): String {
        val ciphertext: ByteArray = cryptographicStore.getCiphertextWrapperFromSharedPrefs()!!.ciphertext
        return cryptographicStore.decryptData(ciphertext, cipher)
    }
}