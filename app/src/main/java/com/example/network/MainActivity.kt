package com.example.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.network.controller.JokeController
import com.example.network.database.AppDatabase
import com.example.network.models.Joke
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title="Network"
        initViews()
    }

    private fun initViews(){
        mainButton.setOnClickListener{
            getJoke()
        }

    }

    private fun getJoke(){
        val retrofit =Retrofit.Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeController = retrofit.create(JokeController::class.java)

        val request = jokeController.getJoke("json")
        request.enqueue( object: Callback<Joke>{

            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if(response.isSuccessful){
                    val joke = response.body()
                    jokeText.text = joke!!.joke
                    AppDatabase.getInstance(this@MainActivity).jokeRepository().insert(joke)
                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                Log.d("Network: ", t.toString())
            }
        })
    }
}