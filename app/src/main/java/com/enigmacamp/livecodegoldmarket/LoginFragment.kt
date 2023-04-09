package com.enigmacamp.livecodegoldmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.enigmacamp.livecodegoldmarket.databinding.FragmentLoginBinding
import com.enigmacamp.livecodegoldmarket.model.User
import com.enigmacamp.livecodegoldmarket.utils.DummyObject

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var user: User? = null
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentLoginBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loginButton.setOnClickListener {
                if(arguments != null){
                    user = arguments?.getParcelable<User>("user")
                }
                validation()
            }

            signupButton.setOnClickListener {
                goToRegisterFragment()
            }
        }
    }

    private fun validation() = binding.apply {
        email = binding.emailTextField.text.toString()
        password = binding.passwordTextField.text.toString()

        when {
            email.isBlank() -> {
                toast("Email & Password tidak boleh kosong")
            }
            password.isBlank() -> {
                toast("Email & Password tidak boleh kosong")
            }
            else -> checkLogin()
        }
    }

    fun checkLogin() {
        if (user != null) {
            user?.let {
                if (it.email == email && it.password == password) {
                    goToHomeFragment()
                }
                else {
                    toast("Akun tidak ditemukan")
                }

            }
        } else toast( "Akun tidak ditemukan")
    }
    private fun goToHomeFragment() {
        if (user != null) {
            DummyObject.user.add(this.user as User)
        }
        findNavController().navigate(R.id.action_loginFragment_to_homeFragment,
            null,
            NavOptions.Builder().setPopUpTo(R.id.nav_graph, true).build()
        )
    }

    fun toast(str: String){
        Toast.makeText(requireActivity(),str, Toast.LENGTH_LONG).show()
    }

    private fun goToRegisterFragment() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = LoginFragment()
    }
}