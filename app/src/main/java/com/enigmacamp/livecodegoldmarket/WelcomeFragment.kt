package com.enigmacamp.livecodegoldmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.enigmacamp.livecodegoldmarket.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment, null,
                NavOptions.Builder().setPopUpTo(
                    R.id.welcomeFragment,
                    true
                ).build()
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = WelcomeFragment()
    }
}