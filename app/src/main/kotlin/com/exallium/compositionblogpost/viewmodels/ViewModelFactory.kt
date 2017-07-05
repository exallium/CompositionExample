package com.exallium.compositionblogpost.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.exallium.compositionblogpost.services.ToolbarService

class ViewModelFactory(private val toolbarService: ToolbarService) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            ToolbarViewModel::class.java -> ToolbarViewModel(toolbarService)
            BottomBarViewModel::class.java -> BottomBarViewModel(toolbarService)
            else -> throw IllegalArgumentException("Cannot construct ${modelClass.canonicalName}")
        } as T
    }
}