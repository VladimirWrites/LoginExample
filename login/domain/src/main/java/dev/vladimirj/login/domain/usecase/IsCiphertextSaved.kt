package dev.vladimirj.login.domain.usecase

import dev.vladimirj.login.domain.store.CryptographicStore
import javax.inject.Inject

class IsCiphertextSaved @Inject constructor(
    private val cryptographicStore: CryptographicStore
) {
    operator fun invoke(): Boolean {
        return cryptographicStore.getCiphertextWrapperFromSharedPrefs() != null
    }
}