package com.example.galleryapp.presentation.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.galleryapp.core.recycler_view.BindingHolder
import com.example.galleryapp.databinding.RvItemGalleryBinding
import com.example.galleryapp.utils.extensions.loadImage
import com.example.gallerytestapp.core.recycler_view.BaseListAdapter
import com.example.galleryapp.data.response.UserImageResponse

class GalleryAdapter():BaseListAdapter<UserImageResponse,RvItemGalleryBinding>(GalleryDiffUtil()) {
    private var onClickListener: ((String) -> Unit)? = null

    fun setOnClickListener(listener: (String) -> Unit) {
        onClickListener = listener
    }

    override fun onBind(binding: RvItemGalleryBinding, currentItem: UserImageResponse) {
        binding.photo.loadImage(currentItem.urls.small)
        binding.authorName.text = currentItem.user.username
        binding.photoName.text = currentItem.createdAt
        binding.root.setOnClickListener {
          onClickListener?.invoke(currentItem.id)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingHolder<RvItemGalleryBinding> {
        return BindingHolder(RvItemGalleryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}