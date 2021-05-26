package com.example.blogapp.ui.camera

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.blogapp.R
import com.example.blogapp.databinding.FragmentCameraBinding

class CameraFragment : Fragment(R.layout.fragment_camera) {

    private lateinit var binding: FragmentCameraBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCameraBinding.bind(view)
    }
}