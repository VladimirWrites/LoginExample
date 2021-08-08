package dev.vladimirj.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId

object LoginInteractions {

    fun emailEditText(): ViewInteraction = onView(withId(R.id.edit_text_email))
    fun passwordEditText(): ViewInteraction = onView(withId(R.id.edit_text_password))
    fun loginButton(): ViewInteraction = onView(withId(R.id.button_login))

    fun snackbar(): ViewInteraction = onView(withId(com.google.android.material.R.id.snackbar_text))
}