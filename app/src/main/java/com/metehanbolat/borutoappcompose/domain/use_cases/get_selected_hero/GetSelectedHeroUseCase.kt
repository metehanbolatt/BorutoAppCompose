package com.metehanbolat.borutoappcompose.domain.use_cases.get_selected_hero

import com.metehanbolat.borutoappcompose.data.repository.Repository
import com.metehanbolat.borutoappcompose.domain.model.Hero

class GetSelectedHeroUseCase(private val repository: Repository) {

    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}