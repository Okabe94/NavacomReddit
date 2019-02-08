package com.example.navacomreddit

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PostAdapter: RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return 15
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.post_row, p0,false)
        return ViewHolder(cellForRow)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
    }

}

class ViewHolder(view: View): RecyclerView.ViewHolder(view){

}