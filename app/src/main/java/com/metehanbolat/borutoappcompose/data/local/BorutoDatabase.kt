package com.metehanbolat.borutoappcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.metehanbolat.borutoappcompose.data.local.dao.HeroDao
import com.metehanbolat.borutoappcompose.data.local.dao.HeroRemoteKeysDao
import com.metehanbolat.borutoappcompose.domain.model.Hero
import com.metehanbolat.borutoappcompose.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase: RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}