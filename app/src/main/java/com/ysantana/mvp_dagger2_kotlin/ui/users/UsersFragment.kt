package com.ysantana.mvp_dagger2_kotlin.ui.users

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.ysantana.mvp_dagger2_kotlin.MyApp
import com.ysantana.mvp_dagger2_kotlin.R
import com.ysantana.mvp_dagger2_kotlin.domain.exception.AppException
import com.ysantana.mvp_dagger2_kotlin.domain.exception.AppNetworkException
import com.ysantana.mvp_dagger2_kotlin.domain.models.UsersResponse
import com.ysantana.mvp_dagger2_kotlin.ui.bases.BaseFragment
import com.ysantana.mvp_dagger2_kotlin.ui.users.adapters.UsersAdapter
import kotlinx.android.synthetic.main.fragment_users.*
import javax.inject.Inject

class UsersFragment : BaseFragment(), UsersView {

    private var mUsersAdapter: UsersAdapter? = null

    companion object {
        fun newInstance() = UsersFragment()
    }

    @Inject
    lateinit var presenter: UsersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInjectComponents()
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        super.initView(view, savedInstanceState)

        mUsersAdapter = UsersAdapter()
        rvUsers.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvUsers.adapter = mUsersAdapter

        presenter.getUsers()
    }

    override fun getFragmentLayout() = R.layout.fragment_users

    private fun initInjectComponents() {
        MyApp.applicationComponent.inject(this)
        presenter.setView(this)
    }

    override fun showUsers(response: List<UsersResponse>) {
        mUsersAdapter?.loadData(response)
    }

    override fun showUsersError(throwable: AppException) {
        view?.let { Snackbar.make(it, getMsg(throwable), Snackbar.LENGTH_LONG).show() }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun getcontext() = activity!!

    private fun getMsg(throwable: AppException): String {
        return if (throwable is AppNetworkException) getString(R.string.network_error)
        else getString(R.string.unknown_error)
    }
}