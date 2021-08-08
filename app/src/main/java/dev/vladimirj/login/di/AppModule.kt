package dev.vladimirj.login.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.vladimirj.base.ui.CoroutineDispatcherProvider
import dev.vladimirj.login.LoginNavigatorImpl
import dev.vladimirj.login.ui.LoginNavigator
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTaxiNavigator(): LoginNavigator {
        return LoginNavigatorImpl()
    }

    @Provides
    fun provideCoroutineDispatcherProvider(): CoroutineDispatcherProvider {
        return CoroutineDispatcherProvider(main = Dispatchers.Main, io = Dispatchers.IO)
    }
}



