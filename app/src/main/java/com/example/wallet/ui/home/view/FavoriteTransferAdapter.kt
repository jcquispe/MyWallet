package com.example.wallet.ui.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.R
import com.example.wallet.ui.home.FavoriteTransfer

class FavoriteTransferAdapter : RecyclerView.Adapter<FavoriteTransferViewHolder>() {

    private var favoriteTransferItems: List<FavoriteTransfer> ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTransferViewHolder =
        FavoriteTransferViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.favorite_transfer_row,
                parent,
                false
            )
        )


    override fun getItemCount(): Int = favoriteTransferItems?.size?: 0

    override fun onBindViewHolder(holder: FavoriteTransferViewHolder, position: Int) =
            holder.bind(favoriteTransferItems?.get(position)!!)

    fun setData(favoriteTransferItems: List<FavoriteTransfer>) {
        this.favoriteTransferItems = favoriteTransferItems
        notifyDataSetChanged()
    }


}