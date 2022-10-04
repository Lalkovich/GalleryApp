package com.example.galleryapp.presentation.gallery

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.galleryapp.R
import com.example.galleryapp.databinding.FragmentGalleryBinding
import com.example.galleryapp.presentation.gallery.adapter.GalleryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class GalleryFragment:Fragment(R.layout.fragment_gallery) {
    private val binding:FragmentGalleryBinding by viewBinding()

    private val vM:GalleryViewModel by viewModel()

    private val adapter = GalleryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.galleryList.adapter = adapter
        initListener()
        initObservers()
    }

    private fun initListener(){
        adapter.setOnClickListener {findNavController().navigate(R.id.action_galleryFragment_to_photoFragment,
            bundleOf("id" to it)
        ) }
    }

    private fun initObservers(){
    vM.gallery.observe(viewLifecycleOwner){
        adapter.submitList(it)
    }
    }
}