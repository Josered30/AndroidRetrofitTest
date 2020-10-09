package com.example.network.controller

import com.example.network.models.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeController {
    @GET("api")
    fun getJoke(@Query("format") format: String): Call<Joke>
}