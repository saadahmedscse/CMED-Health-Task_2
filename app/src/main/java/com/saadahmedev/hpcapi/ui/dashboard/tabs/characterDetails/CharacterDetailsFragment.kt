package com.saadahmedev.hpcapi.ui.dashboard.tabs.characterDetails

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.saadahmedev.hpcapi.base.BaseFragment
import com.saadahmedev.hpcapi.databinding.FragmentCharacterDetailsBinding
import com.saadahmedev.hpcapi.helper.observe
import com.saadahmedev.hpcapi.ui.dashboard.tabs.characterDetails.viewmodel.HpCharacterDetailsViewModel
import com.saadahmedev.hpcapi.util.ProgressDialog
import com.saadahmedev.hpcapi.util.ResponseState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment : BaseFragment<FragmentCharacterDetailsBinding>(FragmentCharacterDetailsBinding::inflate) {

    override val title: String
        get() = tinyDB.getString("character_name", "Character Details")
    override val isBackButtonVisible: Boolean
        get() = true

    private val viewModel by viewModels<HpCharacterDetailsViewModel>()
    private lateinit var progressDialog: ProgressDialog

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        progressDialog = ProgressDialog.getInstance(requireContext())
        viewModel.getHpCharacterDetails(tinyDB.getString("character_id", null))
    }

    override fun observeData() {
        observe(viewModel.hpCharacterDetails) {
            when (it) {
                is ResponseState.Loading -> {
                    progressDialog.show("Loading details for ${tinyDB.getString("character_name", null)}.")
                }

                is ResponseState.Success -> {
                    it.data?.let { character ->
                        character.gender.shortSnackBar()
                    }
                    progressDialog.dismiss()
                }

                is ResponseState.Error -> {
                    it.message.longSnackBar()
                    progressDialog.dismiss()
                }
            }
        }
    }
}