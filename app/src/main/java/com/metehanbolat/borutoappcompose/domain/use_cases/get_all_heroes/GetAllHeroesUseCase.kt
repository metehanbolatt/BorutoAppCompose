package com.metehanbolat.borutoappcompose.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.metehanbolat.borutoappcompose.data.repository.Repository
import com.metehanbolat.borutoappcompose.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}