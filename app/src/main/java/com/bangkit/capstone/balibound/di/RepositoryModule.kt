package com.bangkit.capstone.balibound.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.bangkit.capstone.balibound.data.api.ApiAuthInterface
import com.bangkit.capstone.balibound.data.api.ApiDestinationInterface
import com.bangkit.capstone.balibound.data.repository.AuthRepository
import com.bangkit.capstone.balibound.data.repository.DestinationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.userDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "user_preferences"
)

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(
        @ApplicationContext context: Context, ApiAuthInterface: ApiAuthInterface
    ): AuthRepository {
        return AuthRepository(context.userDataStore, ApiAuthInterface)
    }

    @Provides
    @Singleton
    fun provideDestinationRepository(
        apiDestinationInterface: ApiDestinationInterface
    ): DestinationRepository {
        return DestinationRepository(apiDestinationInterface)
    }

}