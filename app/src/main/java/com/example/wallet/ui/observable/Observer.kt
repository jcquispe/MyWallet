package com.example.wallet.ui.observable

interface Observer {

    fun notifyChange(newValue: Double)
}