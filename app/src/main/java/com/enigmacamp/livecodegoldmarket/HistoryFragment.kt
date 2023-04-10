package com.enigmacamp.livecodegoldmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enigmacamp.livecodegoldmarket.databinding.FragmentHistoryBinding
import com.enigmacamp.livecodegoldmarket.model.History
import com.enigmacamp.livecodegoldmarket.model.User
import com.enigmacamp.livecodegoldmarket.utils.DummyObject

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var history: History

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentHistoryBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.let {
            DummyObject.history.first().apply {
                it.tvItem.text = status
                it.tvUser.text = name
                it.tvPrice.text = "Rp $amount"
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = HistoryFragment()
    }
}