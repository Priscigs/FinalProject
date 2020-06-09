package com.example.proyectofinal.fase2

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.FragmentFase2Binding

/**
 * A simple [Fragment] subclass.
 */

class Fase2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentFase2Binding>(
            inflater,
            R.layout.fragment_fase2, container, false)

        binding.lunes.setOnClickListener {
            binding.ordenLun.visibility =View.VISIBLE
        }
        binding.martes.setOnClickListener {
            binding.ordenMar.visibility =View.VISIBLE
        }
        binding.miercoles.setOnClickListener {
            binding.ordenMier.visibility =View.VISIBLE
        }
        binding.jueves.setOnClickListener {
            binding.ordenJue.visibility =View.VISIBLE
        }
        binding.viernes.setOnClickListener {
            binding.ordenVier2.visibility =View.VISIBLE
        }
        binding.sabado.setOnClickListener {
            binding.ordenSab.visibility =View.VISIBLE
        }
        binding.domingo.setOnClickListener {
            binding.ordenDom.visibility =View.VISIBLE
        }
        binding.dia.setOnClickListener {
            Toast.makeText(activity, "Mañana", Toast.LENGTH_SHORT).show()
        }
        binding.medio.setOnClickListener {
            Toast.makeText(activity, "Media día", Toast.LENGTH_SHORT).show()
        }
        binding.noche.setOnClickListener {
            Toast.makeText(activity, "Noche", Toast.LENGTH_SHORT).show()
        }
        binding.siguiente1.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_fase2_to_fase3)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.navdrawer_menu, menu)

    }

}
