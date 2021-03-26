package com.example.wallet.ui.home.presenter

import com.example.wallet.ui.home.FavoriteTransfer
import com.example.wallet.ui.home.HomeContract
import com.example.wallet.ui.home.UserSingleton
import com.example.wallet.ui.home.UserSingletonObject
import com.example.wallet.ui.home.data.HomeInteractor
import com.example.wallet.ui.home.data.User

class HomePresenter(private val view: HomeContract.View) : HomeContract.Presenter {

    private val homeInteractor = HomeInteractor()

    override fun retrieveFavoriteTransfers() {
        view.showLoader()
        homeInteractor.retrieveFavoriteTransferFromCache(object : HomeContract.OnResponseCallback {
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {
                //SINGLETON
                UserSingleton.getInstance().userName = "Juan Carlos"
                UserSingletonObject.userName = "Carlos"
                //BUILDER
                val user = User.Builder()
                    .setUserName("JUANKY")
                    .setPassword("987654")
                    .build()

                view.hideLoader()
                view.showFavoriteTransfers(favoriteList)
            }

        })
    }

}