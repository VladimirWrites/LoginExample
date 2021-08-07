package dev.vladimirj.login

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LoginApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}