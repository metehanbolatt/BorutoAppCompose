package com.metehanbolat.borutoappcompose.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.metehanbolat.borutoappcompose.data.repository.Repository
import com.metehanbolat.borutoappcompose.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>>{
        return repository.searchHeroes(query = query)
    }
}