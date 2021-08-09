package dev.vladimirj.login.ui

import androidx.fragment.app.FragmentActivity

interface LoginNavigator {
    fun goToHome(activity: FragmentActivity, uid: String)
    fun goToLogin(activity: FragmentActivity)
}