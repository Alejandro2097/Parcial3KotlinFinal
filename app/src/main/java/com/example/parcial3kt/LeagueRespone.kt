package com.example.parcial3kt

import com.example.parcial3kt.data.DataResponse
import com.example.parcial3kt.data.LigaResponse
import com.example.parcial3kt.databinding.ItemLigaBinding
import com.xwray.groupie.databinding.BindableItem

class LeagueRespone(private val lista: DataResponse): BindableItem<ItemLigaBinding>() {

    override fun bind(viewBinding: ItemLigaBinding, position: Int) {
        viewBinding.textB.text = lista.name
    }

    override fun getLayout(): Int {
        return R.layout.item_liga
    }

}