package com.example.wallet.ui.home.data

import android.app.AlertDialog
import android.content.Context

class MessageFactory {

    companion object {
        val TYPE_ERROR = "typeError"
        val TYPE_SUCCESS = "typeSuccess"
        val TYPE_INFO = "typeInfo"
    }

    fun getDialog(context: Context, type: String) =
        when (type) {
            TYPE_ERROR -> AlertDialog.Builder(context).setMessage("Ha ocurrido un error")
            TYPE_SUCCESS -> AlertDialog.Builder(context).setMessage("Se ha cargado exitosamente")
            TYPE_INFO -> AlertDialog.Builder(context).setMessage("Es solo información")
            else -> AlertDialog.Builder(context).setMessage("No se reconoce el tipo")
        }
}