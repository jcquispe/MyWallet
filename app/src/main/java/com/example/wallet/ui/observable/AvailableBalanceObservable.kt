package com.example.wallet.ui.observable

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class AvailableBalanceObservable<T>(lifecycleOwner: LifecycleOwner) : Observable<T> {

    init {
        lifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun removeAllObservers() {
                amountObserverList.clear()
                lifecycleOwner.lifecycle.removeObserver(this)
            }
        })
    }

    private val amountObserverList: ArrayList<Observer<T>> = arrayListOf()
    private var amount: T? = null

    fun changeAmount(newValue: T) {
        amount = newValue
        notifyObservers(amount)
    }

    override fun addObserver(observer: Observer<T>) {
        amountObserverList.add(observer)
    }

    override fun removeObserver(observer: Observer<T>) {
        amountObserverList.remove(observer)
    }

    override fun notifyObservers(newValue: T?) {
        amountObserverList.forEach {
            it.notifyChange(newValue)
        }
    }
}