package com.example.wallet.ui.home.view

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.R
import com.example.wallet.ui.home.FavoriteTransfer
import com.squareup.picasso.Picasso

class FavoriteTransferViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    @SuppressLint("SetTextI18n")
    fun bind(item: FavoriteTransfer) {
        val photoImageView = view.findViewById<ImageView>(R.id.profilePhotoImageView)
        val name = view.findViewById<TextView>(R.id.nameTextView)
        val transferAmount = view.findViewById<TextView>(R.id.transferredAmountTextView)
        val transferTime = view.findViewById<TextView>(R.id.transferTimeTextView)

        Picasso.get().load(item.photoUrl).into(photoImageView)
        name.text = item.name
        transferAmount.text = "$${formatingAmountOnDisplay(item)}"
        transferTime.text = item.date
    }

    private fun formatingAmountOnDisplay(item: FavoriteTransfer): String {
        val amount = item.amount.toString()
        var firstSegment: String = ""
        var secondSegment: String = ""
        var formatedText : String = ""

        if ((amount.length - 2) > 3 && (amount.length - 2) >= 6 ) {

            for (i in 0..2) {
                firstSegment += amount[i].toString()
            }

            for (j in 3 until amount.length) {
                secondSegment += amount[j].toString()
            }

            formatedText = "${firstSegment},${secondSegment}"

        }else if ((amount.length - 2) > 3 && (amount.length - 2) >= 5) {
            for (i in 0..1) {
                firstSegment += amount[i].toString()
            }

            for (j in 2 until amount.length) {
                secondSegment += amount[j].toString()
            }

            formatedText = "${firstSegment},${secondSegment}"

        }else if ((amount.length - 2) > 3 && (amount.length - 2) >= 4) {
            for (i in 0..0) {
                firstSegment += amount[i].toString()
            }

            for (j in 1 until amount.length) {
                secondSegment += amount[j].toString()
            }

            formatedText = "${firstSegment},${secondSegment}"
        }else {
            formatedText = item.amount.toString()
        }

        return formatedText
    }








//    fun bind(item: FavoriteTransfer) {
//        val photoImageView = view.findViewById<ImageView>(R.id.profilePhotoImageView)
//        Picasso.get().load(item.photoUrl).into(photoImageView)
//    }
}