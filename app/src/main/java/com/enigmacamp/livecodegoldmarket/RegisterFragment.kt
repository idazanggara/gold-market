package com.enigmacamp.livecodegoldmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.enigmacamp.livecodegoldmarket.databinding.FragmentRegisterBinding
import com.enigmacamp.livecodegoldmarket.model.User

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            signinButton.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
            newRegisButton.setOnClickListener {
                regis()
            }
        }
    }

    private fun regis() = with(binding) {
        val firstName = firstNameTextField.text.toString()
        val lastName = lastNameTextField.text.toString()
        val email = emailTextField.text.toString()
        val password = passwordTextField.text.toString()
        val user = User(firstName, lastName, email, password)


        when {
            firstName.isBlank() -> toast("Nama depan tidak boleh kosong")
            lastName.isBlank() -> toast( "Nama belakang tidak boleh kosong")
            email.isBlank() -> toast("email tidak boleh kosong")
            password.isBlank() -> toast("password tidak boleh kosong")
            else -> goToSignInFragment(user)
        }
    }

    private fun goToSignInFragment(user: User) {
        val bundle = Bundle()
        bundle.putParcelable("user", user)

        findNavController().navigate(
            R.id.action_registerFragment_to_loginFragment,
            bundle
        )
    }
    fun toast(str: String){
        Toast.makeText(requireActivity(),str,Toast.LENGTH_LONG).show()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = RegisterFragment()
    }
}