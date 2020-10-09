package com.example.network.respositories

import androidx.room.*
import com.example.network.models.Joke

@Dao
interface JokeRespository {
    @Query("SELECT * FROM joke")
    fun getAll(): List<Joke>

    @Insert
    fun insert(vararg contact: Joke)

    @Delete
    fun delete(vararg contact: Joke)

    @Update
    fun update(vararg contact: Joke)
}