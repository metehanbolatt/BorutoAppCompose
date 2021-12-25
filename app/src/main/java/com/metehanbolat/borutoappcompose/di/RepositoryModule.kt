package com.metehanbolat.borutoappcompose.di

import android.content.Context
import com.metehanbolat.borutoappcompose.data.repository.DataStoreOperationsImpl
import com.metehanbolat.borutoappcompose.data.repository.Repository
import com.metehanbolat.borutoappcompose.domain.repository.DataStoreOperations
import com.metehanbolat.borutoappcompose.domain.use_cases.UseCases
import com.metehanbolat.borutoappcompose.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.metehanbolat.borutoappcompose.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(@ApplicationContext context: Context): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository = repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository = repository)
        )
    }
}