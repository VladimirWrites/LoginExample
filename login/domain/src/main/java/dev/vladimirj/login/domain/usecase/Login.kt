package dev.vladimirj.login.domain.usecase

import dev.vladimirj.login.domain.entity.LoginResult
import dev.vladimirj.login.domain.store.UserStore
import javax.inject.Inject

class Login @Inject constructor(private val userStore: UserStore) {
    suspend operator fun invoke(email: String, password: String): LoginResult {
        return userStore.login(email.removeWhitespaces(), password.removeWhitespaces())
    }

    private fun String.removeWhitespaces()  = filter { !it.isWhitespace()
    }
}