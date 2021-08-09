package dev.vladimirj.login

import android.os.Build
import com.nhaarman.mockitokotlin2.*
import dagger.hilt.android.testing.*
import dev.vladimirj.base.ui.CoroutineDispatcherProvider
import dev.vladimirj.login.di.AppModule
import dev.vladimirj.login.domain.entity.LoginResult
import dev.vladimirj.login.domain.usecase.IsAuthenticationSupported
import dev.vladimirj.login.domain.usecase.Login
import dev.vladimirj.login.ui.LoginFragment
import dev.vladimirj.login.ui.LoginNavigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@UninstallModules(AppModule::class)
@HiltAndroidTest
@Config(sdk = [Build.VERSION_CODES.P], application = HiltTestApplication::class)
class LoginFragmentShould {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @BindValue
    val login = mock<Login>()

    @BindValue
    val navigator = mock<LoginNavigator>()

    @BindValue
    val isAuthenticationSupported = mock<IsAuthenticationSupported>()

    @BindValue
    val coroutineDispatcherProvider = CoroutineDispatcherProvider(
        io = Dispatchers.Unconfined,
        main = Dispatchers.Unconfined
    )

    @Test
    fun sendDataToLoginUsecase() = runBlockingTest {
        launchFragmentInHiltContainer<LoginFragment>()

        loginScreen {
            enterEmail("test@email.com")
            enterPassword("test123")
            clickLoginButton()
        }

        verify(login).invoke("test@email.com", "test123")
    }

    @Test
    fun navigateToHomeScreen_whenCorrectDataEntered_andAuthenticationNotSupported() = runBlockingTest {
        val email = "test@email.com"
        val password = "test123"
        val uid = "uid"
        whenever(login.invoke(email, password)).thenReturn(LoginResult.Successful(uid, email))
        whenever(isAuthenticationSupported.invoke()).thenReturn(false)
        launchFragmentInHiltContainer<LoginFragment>()

        loginScreen {
            enterEmail(email)
            enterPassword(password)
            clickLoginButton()
        }

        verify(navigator).goToHome(any(), eq(uid))
    }

    @Test
    fun showError_whenIncorrectDataEntered() = runBlockingTest {
        val message = "Error message"
        whenever(login.invoke(any(), any())).thenReturn(LoginResult.Error(message))
        launchFragmentInHiltContainer<LoginFragment>()

        loginScreen {
            enterEmail("test@email.com")
            enterPassword("test123")
            clickLoginButton()
            checkSnackbarShown(message)
        }
    }

    // TODO: Test paths where authentication is supported if possible
}
