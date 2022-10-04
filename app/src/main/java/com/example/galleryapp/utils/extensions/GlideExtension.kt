package com.example.galleryapp.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(imgUrl:String){
    Glide.with(context).load(imgUrl).into(this)
}