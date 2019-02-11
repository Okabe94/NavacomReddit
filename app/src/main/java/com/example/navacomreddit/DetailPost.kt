package com.example.navacomreddit

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailPost: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setUpView(this)
        button_Submit.setOnClickListener{
            val snackbar = Snackbar.make(it, "Thank you for posting",Snackbar.LENGTH_LONG)
            snackbar.show()
            editText_Comment.text.clear()
        }
    }
}