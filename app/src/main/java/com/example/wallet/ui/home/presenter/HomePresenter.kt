package com.example.wallet.ui.home.presenter

import com.example.wallet.ui.home.FavoriteTransfer
import com.example.wallet.ui.home.HomeContract
import com.example.wallet.ui.home.data.HomeInteractor

class HomePresenter : HomeContract.Presenter {
    private val homeInteractor = HomeInteractor()

    override fun retrieveFavoriteTransfers(): List<FavoriteTransfer> {

    }

}