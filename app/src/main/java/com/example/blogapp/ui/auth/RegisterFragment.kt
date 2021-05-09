package com.example.blogapp.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.blogapp.R
import com.example.blogapp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)

        binding.btnSignUp.setOnClickListener {
            checkSignUpInfo()
        }
    }

    private fun checkSignUpInfo() {

        val email = binding.etEmail.text.toString().trim()
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val confirmPassword = binding.etConfirmPassword.text.toString().trim()
        var estado = "ok"

        if (email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            estado = "empty"
        }else if(password!= confirmPassword ){
            estado = "password"
        }

        when (estado) {
            "ok" -> Toast.makeText(
                requireContext(),
                "All good.",
                Toast.LENGTH_SHORT
            ).show()

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