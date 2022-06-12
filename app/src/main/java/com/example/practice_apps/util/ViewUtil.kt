package com.example.practice_apps.util

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.practice_apps.R


fun View.changeNavigation(direction: NavDirections) {
    Navigation.findNavController(this).navigate(direction)
}

fun View.navigation(navStep:Int){
    findNavController().navigate(navStep, null)
}
fun ImageView.loadImage(id: Int?) {
    id?.let { this.setImageResource(it) }
}
fun ImageView.loadEclipseImage(url: String?) {
    Log.e(
        "loadEclipseImage", "$url ", )
    val loader = CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 40f
        start()
    }

    val option = RequestOptions()
        .error(R.drawable.img_picture)
        .placeholder(loader)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .circleCrop()

    try {
        Glide.with(context)
            .setDefaultRequestOptions(option)
            .load(url)
            .into(this)
    } catch (e: Exception) {
        Log.e("loadEclipseImage", "loadEclipseImage: $e", )
        e.printStackTrace()
    }
}