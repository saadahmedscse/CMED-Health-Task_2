package com.saadahmedev.hpcapi.ui.dashboard

import android.os.Bundle
import com.saadahmedev.hpcapi.base.BaseActivity
import com.saadahmedev.hpcapi.databinding.ActivityDashboardBinding
import com.saadahmedev.hpcapi.databinding.AppToolbarBinding

class DashboardActivity : BaseActivity<ActivityDashboardBinding>(ActivityDashboardBinding::inflate) {

    override val toolbarBinding: AppToolbarBinding
        get() = binding.appToolbar

    override fun onActivityCreate(savedInstanceState: Bundle?) {}

    override fun observeData() {}
}