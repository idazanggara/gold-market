package com.enigmacamp.livecodegoldmarket

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

class SplashScreenFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashScreenFragment_to_welcomeFragment,
                null,
                NavOptions.Builder().setPopUpTo(R.id.splashScreenFragment, true).build()
            )
        },3000L)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = SplashScreenFragment()
    }
}