package com.example.navacomreddit

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View

class ViewHolder(val view: View, var post: Children? = null): RecyclerView.ViewHolder(view){
    companion object {
        const val SUBREDDIT_TITLE_KEY = "SUBREDDIT_TITLE"
        const val SUBREDDIT_BANNER = "SUBREDDIT_BANNER"
        const val SUBREDDIT_DESCRIPTION = "SUBREDDIT_DESCRIPTION"
        const val SUBREDDIT_CONTENT = "SUBREDDIT_CONTENT"
        const val SUBREDDIT_NAME = "SUBREDDIT_NAME"
        const val SUBREDDIT_SUBSCRIBERS = "SUBSCRIBERS"
        const val SUBREDDIT_CREATION_DATE = "CREATION_DATE"
        const val SUBREDDIT_ICON = "SUBREDDIT_ICON"
        const val SUBREDDIT_HINT = "SUBREDDIT_HINT"
        const val SUBREDDIT_HEADER_TITLE = "SUBREDDIT_HEADER_TITLE"
    }
    init{
        view.setOnClickListener {
            val values = post?.data
            val intent = Intent(view.context, DetailPost::class.java)
            intent.putExtra(SUBREDDIT_TITLE_KEY, values?.display_name)
            intent.putExtra(SUBREDDIT_DESCRIPTION, values?.public_description)
            intent.putExtra(SUBREDDIT_CONTENT, values?.description)
            intent.putExtra(SUBREDDIT_BANNER, values?.banner_img)
            intent.putExtra(SUBREDDIT_NAME, values?.display_name)
            intent.putExtra(SUBREDDIT_SUBSCRIBERS, values?.subscribers)
            intent.putExtra(SUBREDDIT_CREATION_DATE, values?.created_utc)
            intent.putExtra(SUBREDDIT_ICON, values?.icon_img)
            intent.putExtra(SUBREDDIT_HINT, values?.submit_text)
            intent.putExtra(SUBREDDIT_HEADER_TITLE, values?.header_title)
            view.context.startActivity(intent)
        }
    }

}
