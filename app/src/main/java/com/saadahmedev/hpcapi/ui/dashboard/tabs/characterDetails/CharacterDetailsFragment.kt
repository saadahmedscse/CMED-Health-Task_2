package com.saadahmedev.hpcapi.ui.dashboard.tabs.characterDetails

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.saadahmedev.hpcapi.R
import com.saadahmedev.hpcapi.base.BaseFragment
import com.saadahmedev.hpcapi.databinding.FragmentCharacterDetailsBinding
import com.saadahmedev.hpcapi.domain.model.HpCharacterDetails
import com.saadahmedev.hpcapi.helper.gone
import com.saadahmedev.hpcapi.helper.observe
import com.saadahmedev.hpcapi.helper.visible
import com.saadahmedev.hpcapi.ui.dashboard.tabs.characterDetails.viewmodel.HpCharacterDetailsViewModel
import com.saadahmedev.hpcapi.util.ProgressDialog
import com.saadahmedev.hpcapi.util.ResponseState
import com.saadahmedsoft.popupdialog.PopupDialog
import com.saadahmedsoft.popupdialog.Styles
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener
import com.squareup.picasso.Picasso
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
                        updateUi(character)
                    }
                    progressDialog.dismiss()
                }

                is ResponseState.Error -> {
                    progressDialog.dismiss()

                    if (it.message == "No Internet Connection") {
                        PopupDialog.getInstance(requireContext())
                            .setStyle(Styles.FAILED)
                            .setHeading("Uh-Oh!")
                            .setDescription("No internet connection detected and no cached data found.")
                            .showDialog(object : OnDialogButtonClickListener() {
                                override fun onDismissClicked(dialog: Dialog?) {
                                    super.onDismissClicked(dialog)
                                }
                            })
                    } else {
                        it.message.longSnackBar()
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateUi(item: HpCharacterDetails) {
        binding.item = item

        if (!item.picture.isNullOrBlank()) Picasso.get().load(item.picture).into(binding.ivPicture)
        else binding.ivPicture.setImageResource(R.drawable.app_logo)

        if (item.actorName.isNullOrBlank()) binding.layoutActor.gone()
        else binding.layoutActor.visible()

        if (item.houseName.isNullOrBlank()) binding.layoutHouse.gone()
        else binding.layoutHouse.visible()

        if (item.gender.isNullOrBlank()) {
            binding.tvGender.gone()
            binding.ivGender.gone()
        }
        else {
            if (item.gender == "male") {
                binding.tvGender.text = "Male"
                binding.ivGender.setImageResource(R.drawable.img_male)
                binding.ivHair.setImageResource(R.drawable.ic_hair_male)
            } else binding.tvGender.text = "Female"
        }

        if (item.dateOfBirth.isNullOrBlank()) {
            binding.ivDob.gone()
            binding.tvDob.gone()
        }

        if (item.eyeColour.isNullOrBlank()) {
            binding.ivEye.gone()
            binding.tvEye.gone()
        } else {
            binding.tvEye.text = "${item.eyeColour.substring(0, 1).uppercase()}${item.eyeColour.substring(1)}"
        }

        if (item.hairColour.isNullOrBlank()) {
            binding.ivHair.gone()
            binding.tvHair.gone()
        } else {
            binding.tvHair.text = "${item.hairColour.substring(0, 1).uppercase()}${item.hairColour.substring(1)}"
        }

        if (item.hogwartsStudent != null && item.hogwartsStudent) {
            binding.tvCharacterProfession.text = "Hogwarts Student"
        }
        else if (item.hogwartsStaff != null && item.hogwartsStaff) {
            binding.tvCharacterProfession.text = "Hogwarts Staff"
        }
        else binding.tvCharacterProfession.gone()

        if (item.wand?.wood == null || item.wand.core == null || item.wand.length == null) binding.layoutWand.gone()
        else {
            binding.tvWood.text = makeCamelCase(item.wand.wood)
            binding.tvCore.text = makeCamelCase(item.wand.core)
            binding.tvLength.text = item.wand.length.toString()
        }

        if (item.alternateNames.isEmpty()) {
            binding.layoutAlternativeNames.gone()
        } else {
            val stringBuilder = StringBuilder()
            item.alternateNames.map {
                stringBuilder.append("$it • ")
            }
            val alterNames = stringBuilder.substring(0, stringBuilder.length - 3)
            if (alterNames.length > 3) binding.tvAlternativeNames.text = alterNames
            else binding.layoutAlternativeNames.gone()
        }

        if (item.alive == null) {
            binding.layoutAlive.gone()
        } else {
            if (item.alive) binding.tvAliveStatus.text = "Alive"
            else binding.tvAliveStatus.text = "Dead"
        }

        if (item.wizard == null) binding.layoutWizard.gone()
        else {
            if (item.wizard) binding.tvWizard.text = "A Wizard"
            else binding.tvWizard.text = "Not a Wizard"
        }
    }

    private fun makeCamelCase(input: String?): String {
        if (input.isNullOrBlank()) {
            return input.orEmpty()
        }

        val result = StringBuilder()
        var capitalizeNext = true

        input.forEach { c ->
            if (c.isWhitespace()) {
                capitalizeNext = true
                result.append(c)
            } else if (capitalizeNext) {
                result.append(c.uppercase())
                capitalizeNext = false
            } else {
                result.append(c)
            }
        }

        return result.toString()
    }
}