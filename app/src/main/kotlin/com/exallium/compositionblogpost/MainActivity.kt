package com.exallium.compositionblogpost

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.exallium.compositionblogpost.adapters.PageSelectedAdapter
import com.exallium.compositionblogpost.databinding.MainActivityBinding
import com.exallium.compositionblogpost.services.ToolbarService
import com.exallium.compositionblogpost.viewmodels.BottomBarViewModel
import com.exallium.compositionblogpost.viewmodels.Page1ViewModel
import com.exallium.compositionblogpost.viewmodels.ToolbarViewModel
import com.exallium.compositionblogpost.viewmodels.ViewModelFactory
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class MainActivity : LifecycleActivity() {

    private lateinit var mainActivityBinding: MainActivityBinding

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        val toolbarService = ViewModelProviders.of(this).get(ToolbarService::class.java)
        val factory = ViewModelFactory(toolbarService)
        val toolbarViewModel = ViewModelProviders.of(this, factory).get(ToolbarViewModel::class.java)
        val bottomBarViewModel = ViewModelProviders.of(this, factory).get(BottomBarViewModel::class.java)
        val page1ViewModel = ViewModelProviders.of(this).get(Page1ViewModel::class.java)

        mainActivityBinding.toolbar.viewModel = toolbarViewModel
        mainActivityBinding.bottomBar.pageAdapter = PageSelectedAdapter(bottomBarViewModel)
        mainActivityBinding.page1View.viewModel = page1ViewModel

        disposables += bottomBarViewModel.pageState.subscribe(this::displayFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

    private fun displayFragment(pageState: BottomBarViewModel.PageState) {
        when (pageState) {
            is BottomBarViewModel.PageState.Page1Selected ->
                mainActivityBinding.container.displayedChild = 0
            is BottomBarViewModel.PageState.Page2Selected ->
                mainActivityBinding.container.displayedChild = 1
        }
    }

    private operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
        this.add(disposable)
    }
}