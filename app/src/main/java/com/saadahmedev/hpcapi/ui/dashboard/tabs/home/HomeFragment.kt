package com.saadahmedev.hpcapi.ui.dashboard.tabs.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.saadahmedev.hpcapi.R
import com.saadahmedev.hpcapi.base.BaseFragment
import com.saadahmedev.hpcapi.databinding.FragmentHomeBinding
import com.saadahmedev.hpcapi.helper.observe
import com.saadahmedev.hpcapi.helper.setLinearLayoutManager
import com.saadahmedev.hpcapi.ui.dashboard.tabs.home.adapter.CharacterAdapter
import com.saadahmedev.hpcapi.ui.dashboard.tabs.home.adapter.OnAdapterItemClickListener
import com.saadahmedev.hpcapi.ui.dashboard.tabs.home.viewmodel.HpCharacterListViewModel
import com.saadahmedev.hpcapi.util.Constants.AppInfo.APP_NAME
import com.saadahmedev.hpcapi.util.ResponseState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate), OnAdapterItemClickListener {

    override val title: String
        get() = APP_NAME
    override val isBackButtonVisible: Boolean
        get() = false

    private val viewModel by viewModels<HpCharacterListViewModel>()
    private val adapter by lazy {
        CharacterAdapter(this)
    }

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        binding.recyclerView.setLinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.getCharacters()
    }

    override fun observeData() {
        observe(viewModel.hpCharacterList) {
            when (it) {
                is ResponseState.Loading -> {
                    //
                }

                is ResponseState.Success -> {
                    it.data?.let { characters ->
                        adapter.addItems(characters)
                    }
                }

                is ResponseState.Error -> {
                    it.message.longSnackBar()
                }
            }
        }
    }

    override fun onClicked(id: String?) {
        //
    }
}