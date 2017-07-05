package com.exallium.compositionblogpost.adapters

import android.view.MenuItem

interface MenuItemAdapter {
    fun onMenuItemSelected(menuItem: MenuItem): Boolean
}
