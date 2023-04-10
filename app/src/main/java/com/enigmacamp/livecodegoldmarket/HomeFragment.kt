package com.enigmacamp.livecodegoldmarket

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enigmacamp.livecodegoldmarket.databinding.FragmentHomeBinding
import com.enigmacamp.livecodegoldmarket.model.History
import com.enigmacamp.livecodegoldmarket.model.User
import com.enigmacamp.livecodegoldmarket.utils.DummyObject

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var hargaBeliEmas = 1020000
    private var hargaJualEmas = 980000
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            buttonTopUp.isEnabled = false
            buttonMakePocket.setOnClickListener {
                buttonTopUp.isEnabled = true
            }

            user = DummyObject.user.first()
            enableDisableButton()

            userGoldAmountRp.text = "Rp ${user.balance}"
            userGoldAmountGram.text = "${user.gold} gram"

            hargaBeli.text = "Rp ${hargaBeliEmas}"
            hargaJual.text = "Rp ${hargaJualEmas}"

            buttonTopUp.setOnClickListener {
                topUp()
                enableDisableButton()
            }

            btnBeli.setOnClickListener {
                buyGold()
                enableDisableButton()
            }

            btnJual.setOnClickListener {
                sellGold()
                enableDisableButton()
            }


        }
    }

    private fun enableDisableButton() {
        val mainActivity = activity as MainActivity
        binding.apply {
            user = DummyObject.user.first()
            buttonTopUp.isEnabled = user.balance > 0
            btnBeli.isEnabled = user.balance > hargaBeliEmas
            btnJual.isEnabled = user.gold > 0
        }
    }

    private fun topUp() {
        user.balance += 100_000
        binding.userGoldAmountRp.text = "Rp ${user.balance}"
        DummyObject.user[0] = user
        user = DummyObject.user.first()
    }

    private fun sellGold() {
        if (user.gold > 0) {
            user.gold--
            user.balance += hargaJualEmas
            binding.userGoldAmountGram.text = "${user.gold} gram"
            binding.userGoldAmountRp.text = "Rp ${user.balance}"
            DummyObject.user[0] = user
            user = DummyObject.user.first()
        }
    }

    private fun buyGold() {
        if (user.balance > hargaBeliEmas) {
            user.gold++
            user.balance -= hargaBeliEmas
            binding.userGoldAmountGram.text = "${user.gold} gram"
            binding.userGoldAmountRp.text = "Rp ${user.balance}"
            DummyObject.user[0] = user
            val history = History(
                user.firstName,
                1,
                "Beli",
                hargaBeliEmas
            )
            DummyObject.history.add(history)
            user = DummyObject.user.first()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = HomeFragment()
    }
}