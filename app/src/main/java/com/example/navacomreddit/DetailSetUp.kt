package com.example.navacomreddit

import android.graphics.Color
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import java.lang.Exception
import java.lang.reflect.Executable
import java.text.DateFormat
import java.text.NumberFormat
import java.util.*

fun setUpView(context: DetailPost) {
    // NavBar title
    context.supportActionBar?.title = context.intent.getStringExtra(ViewHolder.SUBREDDIT_TITLE_KEY)
    // Native string data
    context.textView_DetailName.text = context.intent.getStringExtra(ViewHolder.SUBREDDIT_NAME)
    context.textView_Description.text = context.intent.getStringExtra(ViewHolder.SUBREDDIT_DESCRIPTION)
    context.textView_Hint.text = context.intent.getStringExtra(ViewHolder.SUBREDDIT_HINT)
    context.textVIew_HeaderTitle.text = context.intent.getStringExtra(ViewHolder.SUBREDDIT_HEADER_TITLE)
    context.textView_DetailContent.text = context.intent.getStringExtra(ViewHolder.SUBREDDIT_CONTENT)
    // Images
    val spaceBanner = context.imageView_DetailBanner
    val banner = context.intent.getStringExtra(ViewHolder.SUBREDDIT_BANNER)
    try {
        Picasso.get().load(banner).into(spaceBanner )
    } catch (e: Exception){
        fillShape(spaceBanner, noBannerColor)
    }
    val spaceIcon = context.imageView_DetailCommunityIcon
    val icon = context.intent.getStringExtra(ViewHolder.SUBREDDIT_ICON)
    try {
        Picasso.get().load(icon).into(spaceIcon)
    } catch (e: Exception){
        fillShape(spaceIcon, noIconColor)
    }
    // Date
    val dateUtc = context.intent.getLongExtra(ViewHolder.SUBREDDIT_CREATION_DATE,0)
    val utc = Date(dateUtc)
    val date = DateFormat.getDateInstance(DateFormat.LONG).format(utc)
    context.textView_DetailCreationDate.text = date.toString()
    // Integers
    context.textView_DetailSubscribers.text = NumberFormat.getInstance().format(context.intent.getLongExtra(ViewHolder.SUBREDDIT_SUBSCRIBERS,0))
}

private fun fillShape(space: ImageView, color: Int){
    space.setColorFilter(color)
    space.setBackgroundColor(color)
}