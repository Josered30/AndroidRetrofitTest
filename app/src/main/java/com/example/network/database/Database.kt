package com.example.network.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.network.models.Joke
import com.example.network.respositories.JokeRespository

@Database(entities = [Joke::class],version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun jokeRepository(): JokeRespository

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "AgendaDatabase"
                ).allowMainThreadQueries().build()
            }
            return INSTANCE as AppDatabase

        }
    }


}