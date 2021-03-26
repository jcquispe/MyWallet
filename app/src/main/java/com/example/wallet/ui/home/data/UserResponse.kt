package com.example.wallet.ui.home.data

data class UserResponse (
    val id: String,
    val name: String,
    val token: String,
    val userPhotoURL: String,
    val tokenTransfer: String
)