package dev.vladimirj.login.domain.store;

import dev.vladimirj.login.domain.entity.CiphertextWrapper
import javax.crypto.Cipher;

interface CryptographicStore {

    fun getInitializedCipherForEncryption(keyName: String): Cipher

    fun getInitializedCipherForDecryption(keyName: String, initializationVector: ByteArray): Cipher

    fun encryptData(plaintext: String, cipher: Cipher): CiphertextWrapper

    fun decryptData(ciphertext: ByteArray, cipher: Cipher): String

    fun persistCiphertextWrapperToSharedPrefs(
        ciphertextWrapper: CiphertextWrapper,
    )

    fun getCiphertextWrapperFromSharedPrefs(): CiphertextWrapper?
}