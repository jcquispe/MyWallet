package com.example.wallet.ui.home

interface HomeContract {

    interface View {
        fun showLoader()
        fun hideLoader()
        fun showFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>)
    }

    interface Presenter {
        fun retrieveFavoriteTransfers(): List<FavoriteTransfer>
    }
}