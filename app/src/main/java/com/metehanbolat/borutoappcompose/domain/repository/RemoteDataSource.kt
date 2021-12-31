package com.metehanbolat.borutoappcompose.domain.repository

import androidx.paging.PagingData
import com.metehanbolat.borutoappcompose.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(query: String): Flow<PagingData<Hero>>
}