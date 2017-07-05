package com.exallium.compositionblogpost.adapters

import android.view.MenuItem
import com.exallium.compositionblogpost.R
import com.exallium.compositionblogpost.viewmodels.BottomBarViewModel

class PageSelectedAdapter(val viewModel: BottomBarViewModel) : MenuItemAdapter {
    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.page1 -> viewModel.onPage1Selected()
            R.id.page2 -> viewModel.onPage2Selected()
        }
        return true
    }
}