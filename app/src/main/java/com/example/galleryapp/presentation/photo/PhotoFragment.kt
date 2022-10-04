package com.example.galleryapp.presentation.photo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.galleryapp.R
import com.example.galleryapp.databinding.FragmentPhotoBinding
import com.example.galleryapp.utils.extensions.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhotoFragment():Fragment(R.layout.fragment_photo) {
    private val binding:FragmentPhotoBinding by viewBinding()

    private val viewModel:PhotoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       viewModel.showGallery(arguments?.getString("id")?:"")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers(){
        viewModel.gallery.observe(viewLifecycleOwner){
            binding.photoFragment.loadImage(it.urls.full)
        }
    }
}