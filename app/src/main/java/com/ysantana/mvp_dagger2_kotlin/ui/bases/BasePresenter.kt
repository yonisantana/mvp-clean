package com.ysantana.mvp_dagger2_kotlin.ui.bases

abstract class BasePresenter<V : BaseView> {

    private var view: V? = null

    fun setView(mvpView: V) {
        this.view = mvpView
    }

    fun getView(): V? {
        return this.view
    }

    fun clearView() {
        this.view = null
    }

    abstract fun pause()

}