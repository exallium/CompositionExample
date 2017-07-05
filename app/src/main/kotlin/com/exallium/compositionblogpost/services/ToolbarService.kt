package com.exallium.compositionblogpost.services

import android.arch.lifecycle.ViewModel
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable

class ToolbarService : ViewModel() {

    sealed class ToolbarState {
        data class NameOnly(val name: String): ToolbarState()
    }

    private val stateRelay = BehaviorRelay.create<ToolbarState>()
    val state: Observable<ToolbarState> = stateRelay

    fun setState(state: ToolbarState) {
        stateRelay.accept(state)
    }
}