package dev.vladimirj.login.domain.usecase

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import dev.vladimirj.login.domain.store.UserStore
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class LoginShould {

    private val userStoreMock = mock<UserStore>()

    private val login = Login(userStoreMock)

    @Test
    fun trimInput() = runBlockingTest {
        login(" test @email.com ", "test 123 ")
        verify(userStoreMock).login("test@email.com", "test123")
    }
}