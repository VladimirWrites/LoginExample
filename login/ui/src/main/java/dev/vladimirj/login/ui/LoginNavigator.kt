package dev.vladimirj.login.ui

import androidx.appcompat.app.AppCompatActivity

interface LoginNavigator {
    fun goToHome(activity: AppCompatActivity)
    fun goToLogin(activity: AppCompatActivity)
}