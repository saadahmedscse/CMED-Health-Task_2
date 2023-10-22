package com.saadahmedev.hpcapi.ui.dashboard.tabs.home.adapter

import com.saadahmedev.hpcapi.R
import com.saadahmedev.hpcapi.base.BaseRecyclerAdapter
import com.saadahmedev.hpcapi.databinding.ItemLayoutHpCharacterBinding
import com.saadahmedev.hpcapi.domain.model.HpCharacter
import com.saadahmedev.hpcapi.helper.gone
import com.saadahmedev.hpcapi.helper.onClicked
import com.saadahmedev.hpcapi.helper.visible
import com.squareup.picasso.Picasso

class CharacterAdapter(private val listener: OnAdapterItemClickListener) : BaseRecyclerAdapter<HpCharacter, ItemLayoutHpCharacterBinding>() {

    override val layoutRes: Int
        get() = R.layout.item_layout_hp_character

    override fun onBind(binding: ItemLayoutHpCharacterBinding, item: HpCharacter, position: Int) {
        if (!item.picture.isNullOrBlank()) Picasso.get().load(item.picture).into(binding.ivPicture)

        if (item.actorName.isNullOrBlank()) binding.layoutActor.gone()
        else binding.layoutActor.visible()

        if (item.houseName.isNullOrBlank()) binding.layoutHouse.gone()
        else binding.layoutHouse.visible()

        binding.item = item

        binding.root.onClicked {
            listener.onClicked(item.id)
        }
    }
}