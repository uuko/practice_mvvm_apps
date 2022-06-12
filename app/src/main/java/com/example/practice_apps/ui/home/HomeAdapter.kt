package com.example.practice_apps.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.practice_apps.R
import com.example.practice_apps.Users
import com.example.practice_apps.databinding.ItemUserBinding
import com.example.practice_apps.util.BindingViewHolder

class HomeAdapter (val vm: HomeViewModel) :
    ListAdapter<Users, HomeAdapter.BookmarkViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
//        Log.e("HomeAdapter", "onCreateViewHolder: ", )
        return BookmarkViewHolder(
                LayoutInflater.from(parent.context).inflate(
                R.layout.item_user,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
//        Log.e("HomeAdapter", "onBindViewHolder: ", )
        getItem(position)?.run {
            holder.binding.user = this
            holder.binding.vm = vm
        }
    }


    class BookmarkViewHolder(view: View) : BindingViewHolder<ItemUserBinding>(view)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Users>() {
            override fun areItemsTheSame(oldItem: Users, newItem: Users) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Users, newItem: Users) = oldItem.equals(newItem)
        }
    }
}