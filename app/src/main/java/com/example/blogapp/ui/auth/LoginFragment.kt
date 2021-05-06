package com.example.blogapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.blogapp.R
import com.example.blogapp.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(R.layout.fragment_login) {

   private lateinit var binding : FragmentLoginBinding
   private val firebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        isUserLoggedIn()
    }

    private fun isUserLoggedIn(){
        firebaseAuth.currentUser.let {
            findNavController().navigate(R.id.action_loginFragment_to_homeScreenFragment)
        }
    }
}