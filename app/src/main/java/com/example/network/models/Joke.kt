package com.example.network.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "joke")
class Joke(

    @PrimaryKey(autoGenerate = true)
    var uid: Int,

    @ColumnInfo(name = "joke")
    @SerializedName ("joke")
    var joke: String

) {
}