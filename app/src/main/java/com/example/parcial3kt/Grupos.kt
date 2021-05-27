package com.example.parcial3kt

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial3kt.data.ImageResponse
import com.example.parcial3kt.databinding.FragmentGruposBinding
import com.xwray.groupie.GroupieAdapter
import kotlinx.android.synthetic.main.item_grupo.*

class Grupos : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGruposBinding>(inflater, R.layout.fragment_grupos, container, false)
        binding.gruposRecyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = GroupieAdapter()
        adapter.add(GroupItem("C:\\Users\\jdps1\\IntelliJIDEAProjects\\Parcial3 - Revenge\\app\\src\\main\\res\\drawable\\imagen_miguel.jpg","Daniel  Alfonso Cuellar Calvo", "torre eiffel, Francia", "Primero"))
        adapter.add(GroupItem("@drawable/imagen_miguel.jpg","David  Alejandro Huertas Castellanos", " Basílica de San Pedro, Vaticano", "Segundo"))
        adapter.add(GroupItem("@drawable/imagen_miguel.jpg","Jason  David Pineda Serna", "Taj Mahal, India", "Tercero"))
        adapter.add(GroupItem("@drawable/imagen_miguel.jpg","Miguel Angel Perez Cifuentes" , "Puente Golden Gate, EE.UU.", "Cuarto"))

        binding.gruposRecyclerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}