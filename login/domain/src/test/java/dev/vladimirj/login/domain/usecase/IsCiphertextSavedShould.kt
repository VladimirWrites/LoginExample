package dev.vladimirj.login.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import dev.vladimirj.login.domain.entity.CiphertextWrapper
import dev.vladimirj.login.domain.store.CryptographicStore
import org.junit.Test

class IsCiphertextSavedShould {

    private val cryptographicStore = mock<CryptographicStore>()
    private val isCiphertextSaved = IsCiphertextSaved(cryptographicStore)
    private val ciphertextWrapper = CiphertextWrapper(
        byteArrayOf(1),
        byteArrayOf(2)
    )

    @Test
    fun returnTrue_ifCiphertextWrapperFromSharedPrefs_isNotNull() {
        whenever(cryptographicStore.getCiphertextWrapperFromSharedPrefs()).thenReturn(ciphertextWrapper)
        assertThat(isCiphertextSaved()).isTrue()
    }

    @Test
    fun returnFalse_ifCiphertextWrapperFromSharedPrefs_isNull() {
        whenever(cryptographicStore.getCiphertextWrapperFromSharedPrefs()).thenReturn(null)
        assertThat(isCiphertextSaved()).isFalse()
    }
}