package com.example.navacomreddit

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.post_row.view.*
import java.text.DateFormat
import java.text.NumberFormat
import java.util.*

class PostAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return homeFeed.data.children.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.post_row, parent,false)
        return ViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = homeFeed.data.children.get(position)
        holder.view.textView_Name.text = post.data.url
        holder.view.textView_Description.text = post.data.public_description
        holder.view.textView_Subscribers.text = NumberFormat.getInstance().format(post.data.subscribers)
        val utc = Date(post.data.created_utc)
        val date = DateFormat.getDateInstance(DateFormat.LONG).format(utc)
        holder.view.textView_CreationDate.text = date.toString()
    }

}

class ViewHolder(val view: View): RecyclerView.ViewHolder(view){

}