package com.example.wallet.ui.observable

interface Observer<T> {

    fun notifyChange(newValue: T?)
}