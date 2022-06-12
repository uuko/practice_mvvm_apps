package com.example.practice_apps.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.practice_apps.Users
import com.example.practice_apps.ui.home.HomeAdapter
import com.example.practice_apps.ui.home.HomeViewModel


@BindingAdapter(("imageUrl"))
fun loadImageUrl(view: ImageView, url: String?) {
    url?.let { view.loadEclipseImage(url) }
}

// Function : for load image from id into ImageView
@BindingAdapter(("drawableId"))
fun loadImageId(view: ImageView, id: Int?) {
    id?.let { view.loadImage(id) }
}
@BindingAdapter("refreshing")
fun SwipeRefreshLayout.refreshing(visible: Boolean) {
    isRefreshing = visible
}

@BindingAdapter(value = ["bookmarks", "viewModel"])
fun setBookmarks(view: RecyclerView, items: List<Users>, vm: HomeViewModel) {
//    val llm = LinearLayoutManager(this)
//    llm.orientation = LinearLayoutManager.VERTICAL
    view.adapter?.run {
        Log.e("setBookmarks", "setBookmarks: aaaaaaaaa")
        if (this is HomeAdapter) this.submitList(items)
    } ?: run {
        Log.e("setBookmarks", "setBookmarks: bbbbbbbbbb")
        HomeAdapter(vm).apply {
            view.adapter = this
            this.submitList(items)
        }
    }
}