package com.example.wallet.ui.home

class UserSingleton {

    var userName = "Juanky"

    companion object {
        private var instance: UserSingleton? = null

        fun getInstance(): UserSingleton {
            if (instance == null)
                instance = UserSingleton()
            return instance as UserSingleton
        }
    }
}