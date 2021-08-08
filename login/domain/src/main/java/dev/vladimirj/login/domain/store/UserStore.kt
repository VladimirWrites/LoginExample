package dev.vladimirj.login.domain.store

import dev.vladimirj.login.domain.entity.LoginResult

interface UserStore {
    suspend fun login(email: String, password: String): LoginResult
}