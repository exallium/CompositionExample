package com.exallium.compositionblogpost.viewmodels

import android.arch.lifecycle.ViewModel
import com.exallium.compositionblogpost.services.ToolbarService
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable

class BottomBarViewModel(private val toolbarService: ToolbarService) : ViewModel() {

    companion object {
        val PAGE_1 = ToolbarService.ToolbarState.NameOnly("Page 1")
        val PAGE_2 = ToolbarService.ToolbarState.NameOnly("Page 2")
    }

    sealed class PageState {
        object Page1Selected : PageState()
        object Page2Selected : PageState()
    }

    private val _pageState = BehaviorRelay.createDefault<PageState>(PageState.Page1Selected)
    val pageState: Observable<PageState> = _pageState

    init {
        toolbarService.setState(PAGE_1)
    }

    fun onPage1Selected() {
        _pageState.accept(PageState.Page1Selected)
        toolbarService.setState(PAGE_1)
    }

    fun onPage2Selected() {
        _pageState.accept(PageState.Page2Selected)
        toolbarService.setState(PAGE_2)
    }
}