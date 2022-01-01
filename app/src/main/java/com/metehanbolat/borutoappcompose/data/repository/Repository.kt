package com.metehanbolat.borutoappcompose.data.repository

import androidx.paging.PagingData
import com.metehanbolat.borutoappcompose.domain.model.Hero
import com.metehanbolat.borutoappcompose.domain.repository.DataStoreOperations
import com.metehanbolat.borutoappcompose.domain.repository.LocalDataSource
import com.metehanbolat.borutoappcompose.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllHeroes(): Flow<PagingData<Hero>>{
        return remote.getAllHeroes()
    }

    fun searchHeroes(query: String): Flow<PagingData<Hero>>{
        return remote.searchHeroes(query = query)
    }

    suspend fun getSelectedHero(heroId: Int): Hero {
        return local.getSelectedHero(heroId = heroId)
    }

    suspend fun saveOnBoardingState(completed: Boolean){
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean>{
        return dataStore.readOnBoardingState()
    }

}