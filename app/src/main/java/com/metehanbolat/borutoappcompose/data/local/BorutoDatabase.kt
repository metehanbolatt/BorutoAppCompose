package com.metehanbolat.borutoappcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.metehanbolat.borutoappcompose.data.local.dao.HeroDao
import com.metehanbolat.borutoappcompose.domain.model.Hero

@Database(entities = [Hero::class], version = 1)
abstract class BorutoDatabase: RoomDatabase() {

    abstract fun heroDao(): HeroDao
}