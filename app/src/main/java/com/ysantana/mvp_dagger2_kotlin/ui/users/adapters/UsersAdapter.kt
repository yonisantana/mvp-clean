package com.ysantana.mvp_dagger2_kotlin.ui.users.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ysantana.mvp_dagger2_kotlin.R
import com.ysantana.mvp_dagger2_kotlin.domain.models.UsersResponse
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.ItemViewHolder>() {

    private val list = mutableListOf<UsersResponse>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_user, p0, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(p0: ItemViewHolder, p1: Int) {
        p0.bind(list[p1])
    }

    fun loadData(list: List<UsersResponse>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: UsersResponse) {
            itemView.txtName.text = model.name
            itemView.txtEmail.text = model.email

        }
    }
}