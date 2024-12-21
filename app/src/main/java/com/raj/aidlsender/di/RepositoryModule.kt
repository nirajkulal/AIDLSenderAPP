package com.raj.aidlsender.di

import com.raj.aidlsender.data.repository.RepositoryImp
import com.raj.aidlsender.data.service.ServiceManager
import com.raj.aidlsender.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providesRepository(): Repository {
        return RepositoryImp(ServiceManager())
    }
}