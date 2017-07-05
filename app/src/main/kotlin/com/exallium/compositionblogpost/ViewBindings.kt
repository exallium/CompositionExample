package com.exallium.compositionblogpost

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView
import com.exallium.compositionblogpost.adapters.MenuItemAdapter

@BindingAdapter("onNavItemSelected")
fun onNavItemSelected(bottomNavigationView: BottomNavigationView, menuItemAdapter: MenuItemAdapter) {
    bottomNavigationView.setOnNavigationItemSelectedListener(menuItemAdapter::onMenuItemSelected)
}
