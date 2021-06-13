package com.example.blogapp.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.blogapp.R
import com.example.blogapp.data.remote.auth.AuthDataSource
import com.example.blogapp.databinding.FragmentRegisterBinding
import com.example.blogapp.domain.auth.AuthRepoImpl
import com.example.blogapp.presentation.auth.AuthViewModelFactory
import com.example.blogapp.presentation.auth.AuthViewModel
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.blogapp.core.Result

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding

    private val viewModel by viewModels<AuthViewModel> {
        AuthViewModelFactory(
            AuthRepoImpl(
                AuthDataSource()
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)
        checkSignUpInfo()

    }

    private fun checkSignUpInfo() {
        binding.btnSignUp.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmPassword = binding.etConfirmPassword.text.toString().trim()
            var estado = "ok"

            if (email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                estado = "empty"
            } else if (password != confirmPassword) {
                estado = "password"
            }

            when (estado) {
                "ok" -> { createUser(email,password,username) }

                "password" -> Toast.makeText(
                    requireContext(),
                    "Error: Passwords don't match.",
                    Toast.LENGTH_SHORT
                ).show()

                "empty" -> Toast.makeText(
                    requireContext(),
                    "Error: Empty field.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun createUser(email: String, password: String, username: String) {
        viewModel.signUp(email, password, username).observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.btnSignUp.isEnabled = false
                }

                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    findNavController().navigate(R.id.action_registerFragment_to_setupProfileFragment)
                }

                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    binding.btnSignUp.isEnabled = true
                    Toast.makeText(requireContext(),"Error: ${result.exception}",Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}