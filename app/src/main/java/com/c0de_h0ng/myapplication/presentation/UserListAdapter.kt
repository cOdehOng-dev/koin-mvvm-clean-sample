package com.c0de_h0ng.myapplication.presentation

import android.view.ViewGroup
import com.c0de_h0ng.myapplication.R
import com.c0de_h0ng.myapplication.common.base.BaseListAdapter
import com.c0de_h0ng.myapplication.common.base.BaseViewHolder
import com.c0de_h0ng.myapplication.databinding.UserListItemBinding
import com.c0de_h0ng.myapplication.domain.model.User

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
class UserListAdapter : BaseListAdapter<User>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(parent)
    }

    inner class UserViewHolder(parent: ViewGroup) : BaseViewHolder<User, UserListItemBinding>(R.layout.user_list_item, parent) {
        override fun bind(data: User) {
            binding.run {
                this.profileUrl = data.profileUrl
                this.userName = data.login
            }
        }

    }
}