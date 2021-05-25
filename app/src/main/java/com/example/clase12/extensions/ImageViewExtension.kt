package com.example.clase10.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.clase10.R


fun ImageView.loadImage(url: String?){
    val options = RequestOptions()
        .centerCrop()
        .placeholder(R.drawable.ic_action_name)
        .error(R.drawable.ic_action_name)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}
