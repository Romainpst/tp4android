package com.example.tp4.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp4.randomUselessFacts.dao.RandomFactsDao
import com.example.tp4.randomUselessFacts.model.RandomFactsRoom


@Database(
    entities = [
        RandomFactsRoom::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun randomFactsDao() : RandomFactsDao
}
