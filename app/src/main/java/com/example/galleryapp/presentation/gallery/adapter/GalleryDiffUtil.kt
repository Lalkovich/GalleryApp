package com.example.galleryapp.presentation.gallery.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.galleryapp.data.response.UserImageResponse

class GalleryDiffUtil():DiffUtil.ItemCallback<UserImageResponse>() {
    override fun areItemsTheSame(oldItem: UserImageResponse, newItem: UserImageResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: UserImageResponse,
        newItem: UserImageResponse
    ): Boolean {
        return oldItem == newItem
    }

}