package com.enigmacamp.livecodegoldmarket.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    var balance: Int = 0,
    var gold: Int = 0
): Parcelable
