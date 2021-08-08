package dev.vladimirj.login

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import dev.vladimirj.login.LoginInteractions.emailEditText
import dev.vladimirj.login.LoginInteractions.loginButton
import dev.vladimirj.login.LoginInteractions.passwordEditText
import dev.vladimirj.login.LoginInteractions.snackbar

fun loginScreen(block: LoginRobot.() -> Unit): LoginRobot {
    return LoginRobot().apply { block() }
}

class LoginRobot {

    fun enterEmail(email: String) {
        emailEditText().perform(typeText(email))
    }

    fun enterPassword(password: String) {
        passwordEditText().perform(typeText(password))
    }

    fun clickLoginButton() {
        loginButton().perform(click())
    }

    fun checkSnackbarShown(text: String) {
        snackbar().check(matches(withText(text)))
    }
}