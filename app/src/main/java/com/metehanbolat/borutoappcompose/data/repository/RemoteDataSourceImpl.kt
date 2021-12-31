package com.metehanbolat.borutoappcompose.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.metehanbolat.borutoappcompose.data.local.BorutoDatabase
import com.metehanbolat.borutoappcompose.data.paging_source.HeroRemoteMediator
import com.metehanbolat.borutoappcompose.data.paging_source.SearchHeroesSource
import com.metehanbolat.borutoappcompose.data.remote.BorutoApi
import com.metehanbolat.borutoappcompose.domain.model.Hero
import com.metehanbolat.borutoappcompose.domain.repository.RemoteDataSource
import com.metehanbolat.borutoappcompose.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase
): RemoteDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = { SearchHeroesSource(borutoApi = borutoApi, query = query) }
        ).flow
    }
}