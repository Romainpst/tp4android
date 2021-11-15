package com.example.tp4.randomUselessFacts.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tp4.randomUselessFacts.model.RandomFactsRoom

@Dao
interface RandomFactsDao {


    @Query("SELECT * FROM random_useless_facts")
    fun selectAll() : LiveData<List<RandomFactsRoom>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(randomFactsRoom: RandomFactsRoom)


    @Query("DELETE FROM random_useless_facts")
    fun deleteAll()
}