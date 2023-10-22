package com.saadahmedev.hpcapi.ui.dashboard.tabs.home

import android.os.Bundle
import com.saadahmedev.hpcapi.R
import com.saadahmedev.hpcapi.base.BaseFragment
import com.saadahmedev.hpcapi.databinding.FragmentHomeBinding
import com.saadahmedev.hpcapi.util.Constants.AppInfo.APP_NAME

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val title: String
        get() = APP_NAME
    override val isBackButtonVisible: Boolean
        get() = false

    override fun onFragmentCreate(savedInstanceState: Bundle?) {}

    override fun observeData() {}
}