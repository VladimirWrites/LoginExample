package dev.vladimirj.login.ui

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import dev.vladimirj.base.ui.CoroutineDispatcherProvider
import dev.vladimirj.login.domain.usecase.Login
import kotlinx.coroutines.Dispatchers

import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule


class LoginViewModelShould {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val login = mock<Login>()
    private val coroutineDispatcherProvider = CoroutineDispatcherProvider(
        main = Dispatchers.Unconfined,
        io = Dispatchers.Unconfined
    )
    private val viewModel = LoginViewModel(login, coroutineDispatcherProvider)

    @Before
    fun setup() {
        // MediatorLiveData needs observer to update it's values
        viewModel.isLoginEnabled.observeForever{}
    }

    @Test
    fun enableLogin_whenEmailAndPassword_notEmpty() {
        assertThat(viewModel.isLoginEnabled.value).isFalse()

        viewModel.email.postValue("test@email.com")
        viewModel.password.postValue("test123")

        assertThat(viewModel.isLoginEnabled.value).isTrue()
    }

    //TODO: Add other tests
}