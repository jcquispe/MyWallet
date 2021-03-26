package com.example.wallet.ui.home

data class FavoriteTransfer(
    val id: Int,
    val name: String = "",
    val amount: Double = 0.0,
    val date: String?,
    val photoUrl: String?
)