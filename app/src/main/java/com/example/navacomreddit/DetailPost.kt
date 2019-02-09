package com.example.navacomreddit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class DetailPost: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView_MainPage.layoutManager = LinearLayoutManager(this)
        recyclerView_MainPage.adapter = DetailPostAdapter()
    }

    private class DetailPostAdapter: RecyclerView.Adapter<DetailPostViewHolder>(){
        override fun getItemCount(): Int {
            return 3
        }

        override fun onBindViewHolder(p0: DetailPostViewHolder, p1: Int) {

        }

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DetailPostViewHolder {

        }
    }

    private class DetailPostViewHolder(val customView: View): RecyclerView.ViewHolder(customView){

    }

}