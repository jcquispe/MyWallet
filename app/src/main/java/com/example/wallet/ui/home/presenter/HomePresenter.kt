package com.example.wallet.ui.home.presenter

import com.example.wallet.ui.home.FavoriteTransfer
import com.example.wallet.ui.home.HomeContract
import com.example.wallet.ui.home.data.HomeInteractor

class HomePresenter(private val view : HomeContract.View) : HomeContract.Presenter {

    private val homeInteractor = HomeInteractor()

    override fun retrieveFavoriteTransfers() {
        view.showLoader()
        homeInteractor.retrieveFavoriteTransferFromCache(object: HomeContract.OnResponseCallback {
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {
                view.hideLoader()
                view.showFavoriteTransfers(favoriteList)
            }

        })
    }

}