package com.metehanbolat.borutoappcompose.domain.repository

import com.metehanbolat.borutoappcompose.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}