package com.saadahmedev.hpcapi.ui.dashboard.tabs.characterDetails

import android.os.Bundle
import com.saadahmedev.hpcapi.base.BaseFragment
import com.saadahmedev.hpcapi.databinding.FragmentCharacterDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment : BaseFragment<FragmentCharacterDetailsBinding>(FragmentCharacterDetailsBinding::inflate) {

    override val title: String
        get() = tinyDB.getString("character_name", "Character Details")
    override val isBackButtonVisible: Boolean
        get() = true

    override fun onFragmentCreate(savedInstanceState: Bundle?) {}

    override fun observeData() {}
}