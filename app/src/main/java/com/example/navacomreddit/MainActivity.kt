package com.example.navacomreddit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView_MainPage.layoutManager = LinearLayoutManager(this)
        recyclerView_MainPage.adapter = PostAdapter()

        fetchPosts()
    }

    fun fetchPosts(){
        val url = "https://www.reddit.com/reddits.json"
        val request = Request.Builder().url(url).build()
        val client = okhttp3.OkHttpClient()
        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                println("An error has occurred")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println("HEY WE WORKING")
                println(body)
            }
        })

    }
}
