package com.example.wallet.ui.observable

interface Observable<T> {

    fun addObserver(observer: Observer<T>)
    fun removeObserver(observer: Observer<T>)
    fun notifyObservers(newValue: T?)
}