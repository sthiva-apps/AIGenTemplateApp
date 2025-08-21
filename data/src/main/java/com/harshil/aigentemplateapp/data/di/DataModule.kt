package com.harshil.aigentemplateapp.data.di

import com.harshil.aigentemplateapp.data.DataSource
import com.harshil.aigentemplateapp.data.remote.ApiService
import com.harshil.aigentemplateapp.data.remote.RemoteDataSource
import com.harshil.aigentemplateapp.data.repository.RepositoryImpl
import com.harshil.aigentemplateapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com/") // Replace with actual base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDataSource(apiService: ApiService): DataSource {
        return RemoteDataSource(apiService)
    }

    @Provides
    @Singleton
    fun provideRepository(dataSource: DataSource): Repository {
        return RepositoryImpl(dataSource)
    }
}
