package com.metehanbolat.borutoappcompose.di

import android.content.Context
import com.metehanbolat.borutoappcompose.data.local.BorutoDatabase
import com.metehanbolat.borutoappcompose.data.repository.DataStoreOperationsImpl
import com.metehanbolat.borutoappcompose.data.repository.LocalDataSourceImpl
import com.metehanbolat.borutoappcompose.data.repository.Repository
import com.metehanbolat.borutoappcompose.domain.repository.DataStoreOperations
import com.metehanbolat.borutoappcompose.domain.repository.LocalDataSource
import com.metehanbolat.borutoappcompose.domain.use_cases.UseCases
import com.metehanbolat.borutoappcompose.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.metehanbolat.borutoappcompose.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.metehanbolat.borutoappcompose.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.metehanbolat.borutoappcompose.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.metehanbolat.borutoappcompose.domain.use_cases.search_heroes.SearchHeroesUseCase
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
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository = repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository = repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository = repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository = repository)
        )
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(database: BorutoDatabase): LocalDataSource {
        return LocalDataSourceImpl(borutoDatabase = database)
    }
}