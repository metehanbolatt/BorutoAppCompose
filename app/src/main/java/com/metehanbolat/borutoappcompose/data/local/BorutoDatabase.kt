package com.metehanbolat.borutoappcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.metehanbolat.borutoappcompose.data.local.dao.HeroDao
import com.metehanbolat.borutoappcompose.data.local.dao.HeroRemoteKeyDao
import com.metehanbolat.borutoappcompose.domain.model.Hero
import com.metehanbolat.borutoappcompose.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
abstract class BorutoDatabase: RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}