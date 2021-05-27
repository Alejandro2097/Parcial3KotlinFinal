package com.example.parcial3kt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.parcial3kt.data.LigaResponse
import com.example.parcial3kt.data.RetrofitInstance
import com.example.parcial3kt.databinding.FragmentServiciosBinding
import com.xwray.groupie.GroupieAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Servicios : Fragment() {

    private lateinit var binding: FragmentServiciosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentServiciosBinding>(inflater, R.layout.fragment_servicios, container, false)
        binding.equipos.layoutManager = GridLayoutManager(context, 2)

        val adapter = GroupieAdapter()
        binding.equipos.adapter = adapter

        RetrofitInstance().bingApi().searchLeague(17).enqueue(object: Callback<LigaResponse> {

            override fun onResponse(call: Call<LigaResponse>, response: Response<LigaResponse>) {
                response.body()?.let {
                    val listText = it.country
                    val items = listText.map { LeagueRespone(it) }
                    adapter.update(items)
                }
            }

            override fun onFailure(call: Call<LigaResponse>, t: Throwable) {
                Toast.makeText(context, "ERROR !! ", Toast.LENGTH_SHORT).show()
            }

        } )

        return binding.root
    }
}