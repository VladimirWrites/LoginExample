package dev.vladimirj.login.ui

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import dev.vladimirj.base.ui.CoroutineDispatcherProvider
import kotlinx.coroutines.Dispatchers

import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.whenever
import dev.vladimirj.login.domain.usecase.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule


class LoginViewModelShould {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val login = mock<Login>()
    private val getCipherForEncryption = mock<GetCipherForEncryption>()
    private val getCipherForDecryption = mock<GetCipherForDecryption>()
    private val encryptAndSaveUid = mock<EncryptAndSaveUid>()
    private val decryptData = mock<DecryptData>()
    private val isCiphertextSaved = mock<IsCiphertextSaved>()
    private val isAuthenticationSupported = mock<IsAuthenticationSupported>()

    private val coroutineDispatcherProvider = CoroutineDispatcherProvider(
        main = Dispatchers.Unconfined,
        io = Dispatchers.Unconfined
    )
    private val viewModel = LoginViewModel(
        login,
        getCipherForEncryption,
        getCipherForDecryption,
        encryptAndSaveUid,
        decryptData,
        isCiphertextSaved,
        isAuthenticationSupported,
        coroutineDispatcherProvider
    )

    @Before
    fun setup() {
        // MediatorLiveData needs observer to update it's values
        viewModel.isLoginEnabled.observeForever{}
    }

    @Test
    fun enableLogin_whenEmailAndPasswordNotEmpty() {
        assertThat(viewModel.isLoginEnabled.value).isFalse()

        viewModel.email.postValue("test@email.com")
        viewModel.password.postValue("test123")

        assertThat(viewModel.isLoginEnabled.value).isTrue()
    }

    //TODO: Add other tests
}