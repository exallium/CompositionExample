package com.exallium.compositionblogpost.viewmodels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class Page1ViewModel : ViewModel() {
    val clicks: ObservableField<String> = ObservableField("0")

    fun onClick() {
        val clickCount = clicks.get().toInt()
        clicks.set(clickCount.inc().toString())
    }
}