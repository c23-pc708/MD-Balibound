package com.bangkit.capstone.balibound.di

import com.bangkit.capstone.balibound.data.api.ApiAuthInterface
import com.bangkit.capstone.balibound.data.api.ApiDestinationInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://django-backend-dev-7n2cqvfd2q-uc.a.run.app/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun apiAuth(retrofit: Retrofit): ApiAuthInterface {
        return retrofit.create(ApiAuthInterface::class.java)
    }

    @Provides
    @Singleton
    fun apiDestination(retrofit: Retrofit) : ApiDestinationInterface{
        return retrofit.create(ApiDestinationInterface::class.java)
    }
}