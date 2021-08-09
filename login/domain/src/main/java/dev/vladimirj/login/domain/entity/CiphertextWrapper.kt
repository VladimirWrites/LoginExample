package dev.vladimirj.login.domain.entity

data class CiphertextWrapper(
    val ciphertext: ByteArray,
    val initializationVector: ByteArray
)