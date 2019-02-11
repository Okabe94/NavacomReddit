package com.example.navacomreddit

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.post_row.view.*
import java.text.DateFormat
import java.text.NumberFormat
import java.util.*

const val noBannerColor = Color.BLUE
const val noIconColor = Color.CYAN

class PostAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return homeFeed.data.children.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.post_row, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Populating with the values obtained
        val post = homeFeed.data.children[position]
        holder.view.textView_DetailName.text = post.data.url
        holder.view.textView_Description.text = post.data.public_description
        holder.view.textView_DetailSubscribers.text = NumberFormat.getInstance().format(post.data.subscribers)

        // Converting UTC to Useful date
        val utc = Date(post.data.created_utc)
        val date = DateFormat.getDateInstance(DateFormat.LONG).format(utc)
        holder.view.textView_DetailCreationDate.text = date.toString()
        val bannerImg = holder.view.imageView_Banner
        val communityIcon = holder.view.imageView_DetailCommunityIcon

        // Checking the links of the images
        val apiBannerImg = post.data.banner_img
        val apiIcon = post.data.icon_img

        // Checking their contents
        // Some pages do not have an image to set
        if(apiBannerImg.isNotBlank()) {
            Picasso.get().load(apiBannerImg).into(bannerImg)
            fillShape(bannerImg, Color.TRANSPARENT)
        }else {
            val defaultColor = post.data.banner_background_color
            if(defaultColor.isNotBlank()){
                fillShape(bannerImg, defaultColor)
            } else {
                fillShape(bannerImg, noBannerColor)
            }
        }
        if(apiIcon.isNotBlank()) {
            Picasso.get().load(apiIcon).into(communityIcon)
            fillShape(communityIcon, Color.TRANSPARENT)
        } else {
            val defaultIcon = post.data.primary_color
            if(defaultIcon.isNotBlank()){
                fillShape(communityIcon, defaultIcon)
            } else {
                fillShape(communityIcon, noIconColor)
            }
        }
        holder.post = post
    }
    // Reusable functions based on the outcome of the API request
    private fun fillShape(space: ImageView, color: String){
        space.setColorFilter(Color.parseColor(color))
        space.setBackgroundColor(Color.parseColor(color))
    }
    private fun fillShape(space: ImageView, color: Int){
        space.setColorFilter(color)
        space.setBackgroundColor(color)
    }
}
