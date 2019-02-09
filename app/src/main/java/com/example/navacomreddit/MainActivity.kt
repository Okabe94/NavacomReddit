package com.example.navacomreddit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView_MainPage.layoutManager = LinearLayoutManager(this)
        //Populate the view.
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
                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)
                runOnUiThread(){
                    recyclerView_MainPage.adapter = PostAdapter(homeFeed)
                }
            }
        })
    }
}

//Json Abstraction
class HomeFeed(val data: Data)
class Data(val children: List<Children>)
class Children(val data: ChildrenData)
class ChildrenData(val banner_img: String, val public_description: String, val icon_img: String,
      val subscribers: Long, val banner_background_color: String, val primary_color: String, val url: String, val created_utc: Long)
