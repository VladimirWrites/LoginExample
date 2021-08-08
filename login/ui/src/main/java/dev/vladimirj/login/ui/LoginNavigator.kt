package dev.vladimirj.login.ui

import androidx.fragment.app.FragmentActivity

interface LoginNavigator {
    fun goToHome(activity: FragmentActivity)
    fun goToLogin(activity: FragmentActivity)
}