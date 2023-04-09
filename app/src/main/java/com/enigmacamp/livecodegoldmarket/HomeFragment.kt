package com.enigmacamp.livecodegoldmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enigmacamp.livecodegoldmarket.databinding.FragmentHomeBinding
import com.enigmacamp.livecodegoldmarket.model.User

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var goldSellPrice = 1021000
    private var goldBuyPrice = 981000
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = HomeFragment()
    }
}