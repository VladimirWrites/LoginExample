package dev.vladimirj.login.data.di

import android.content.Context
import androidx.biometric.BiometricManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.vladimirj.login.data.BiometricStoreImpl
import dev.vladimirj.login.data.CryptographicStoreImpl
import dev.vladimirj.login.data.UserStoreImpl
import dev.vladimirj.login.domain.store.BiometricStore
import dev.vladimirj.login.domain.store.CryptographicStore
import dev.vladimirj.login.domain.store.UserStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BiometricLoginModule {

    @Singleton
    @Provides
    fun provideCryptographicStore(@ApplicationContext appContext: Context): CryptographicStore {
        return CryptographicStoreImpl(appContext)
    }

    @Singleton
    @Provides
    fun provideBiometricStore(@ApplicationContext appContext: Context): BiometricStore {
        return BiometricStoreImpl(BiometricManager.from(appContext))
    }
}



