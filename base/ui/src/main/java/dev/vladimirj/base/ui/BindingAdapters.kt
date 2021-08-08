package dev.vladimirj.base.ui

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("goneUnless")
fun View.goneUnless(visible: Boolean) {
    this.visibility = if(visible) View.VISIBLE else View.GONE
}