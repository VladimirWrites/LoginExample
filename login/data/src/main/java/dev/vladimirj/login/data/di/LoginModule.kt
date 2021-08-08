package dev.vladimirj.login.data.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.vladimirj.login.data.UserStoreImpl
import dev.vladimirj.login.domain.store.UserStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Singleton
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return Firebase.auth
    }

    @Singleton
    @Provides
    fun provideLogin(firebaseAuth: FirebaseAuth): UserStore {
        return UserStoreImpl(firebaseAuth)
    }
}



