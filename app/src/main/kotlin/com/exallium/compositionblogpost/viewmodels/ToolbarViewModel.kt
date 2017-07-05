package com.exallium.compositionblogpost.viewmodels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.exallium.compositionblogpost.services.ToolbarService
import io.reactivex.disposables.Disposable

class ToolbarViewModel(toolbarService: ToolbarService) : ViewModel() {
    val title: ObservableField<String> = ObservableField()

    val disposable: Disposable

    init {
        disposable = toolbarService.state.subscribe {
            when (it) {
                is ToolbarService.ToolbarState.NameOnly -> title.set(it.name)
            }
        }
    }

    override fun onCleared() {
        disposable.dispose()
    }
}