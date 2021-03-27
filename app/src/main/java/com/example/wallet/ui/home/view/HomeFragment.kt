package com.example.wallet.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.R
import com.example.wallet.ui.home.FavoriteTransfer
import com.example.wallet.ui.home.HomeContract
import com.example.wallet.ui.home.UserSingleton
import com.example.wallet.ui.home.UserSingletonObject
import com.example.wallet.ui.home.data.MessageFactory
import com.example.wallet.ui.home.data.MessageFactory.Companion.TYPE_ERROR
import com.example.wallet.ui.home.presenter.HomePresenter
import com.example.wallet.ui.observable.AvailableBalanceObservable
import com.example.wallet.ui.observable.Observer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val favoriteTransferAdapter =
        FavoriteTransferAdapter()

    private val availableBalanceObservable = AvailableBalanceObservable()

    private lateinit var homePresenter: HomeContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        homePresenter = HomePresenter(this)
        homePresenter.retrieveFavoriteTransfers()
        circularProgress.setProgressWithAnimation(
            70f,
            1000,
            AccelerateDecelerateInterpolator(),
            500
        )
        Picasso
            .get()
            .load("https://media.licdn.com/dms/image/C4E03AQFcCuDIJl0mKg/profile-displayphoto-shrink_200_200/0?e=1583366400&v=beta&t=ymt3xgMe5bKS-2knNDL9mQYFksP9ZHne5ugIqEyRjZs")
            .into(profilePhotoImageView)
        availableBalanceObservable.addObserver(object : Observer {
            override fun notifyChange(newValue: Double) {
                amountValueTextView.text = "$ $newValue"
            }

        })
    }

    private fun initRecyclerView() {
        favoriteTransfersRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        favoriteTransfersRecyclerView.adapter = favoriteTransferAdapter

    }

    override fun showLoader() {
        homeLoader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        homeLoader.visibility = View.GONE
        println(UserSingleton.getInstance().userName)
        println(UserSingletonObject.userName)
    }

    override fun showFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>) {
        favoriteTransferAdapter.setData(favoriteTransfer)
        //FACTORY
        val dialogFactory = MessageFactory()
        context?.let {
            dialogFactory.getDialog(it, "typeInfo").show()
        }
    }
}