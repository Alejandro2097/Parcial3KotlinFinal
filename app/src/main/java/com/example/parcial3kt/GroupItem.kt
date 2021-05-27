package com.example.parcial3kt

import com.example.parcial3kt.data.ImageResponse
import com.example.parcial3kt.databinding.ItemGrupoBinding
import com.squareup.picasso.Picasso
import com.xwray.groupie.databinding.BindableItem

    class GroupItem(val image: ImageResponse, val name: String, val location: String, val hint: String): BindableItem<ItemGrupoBinding>() {
        override fun bind(viewBinding: ItemGrupoBinding, position: Int) {
            Picasso.get().load(image.thumbnailUrl).into(viewBinding.idImagen)
            viewBinding.nameTextView.text = name
            viewBinding.locationTextView.text = location
            viewBinding.verMapa.hint = hint
        }

        override fun getLayout(): Int {
            return R.layout.item_grupo
        }
    }