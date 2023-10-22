package com.saadahmedev.hpcapi.ui.dashboard.tabs.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.saadahmedev.hpcapi.R
import com.saadahmedev.hpcapi.base.BaseFragment
import com.saadahmedev.hpcapi.databinding.FragmentHomeBinding
import com.saadahmedev.hpcapi.helper.observe
import com.saadahmedev.hpcapi.ui.dashboard.tabs.home.viewmodel.HpCharacterListViewModel
import com.saadahmedev.hpcapi.util.Constants.AppInfo.APP_NAME
import com.saadahmedev.hpcapi.util.ResponseState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val title: String
        get() = APP_NAME
    override val isBackButtonVisible: Boolean
        get() = false

    private val viewModel by viewModels<HpCharacterListViewModel>()

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        viewModel.getCharacters()
    }

    override fun observeData() {
        observe(viewModel.hpCharacterList) {
            when (it) {
                is ResponseState.Loading -> {
                    //
                }

                is ResponseState.Success -> {
                    it.data!![0].name.longSnackBar()
                }

                is ResponseState.Error -> {
                    it.message.longSnackBar()
                }
            }
        }
    }
}