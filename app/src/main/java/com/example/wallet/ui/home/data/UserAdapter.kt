package com.example.wallet.ui.home.data

import com.example.wallet.ui.home.view.UserViewModel

class UserAdapter {
    fun getUserViewModel (userResponse: UserResponse): UserViewModel {
        return UserViewModel(userResponse.name, userResponse.userPhotoURL)
    }
}