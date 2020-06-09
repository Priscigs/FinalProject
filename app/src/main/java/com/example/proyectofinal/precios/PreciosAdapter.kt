package com.example.proyectofinal.precios

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import com.example.proyectofinal.database.ListaPrecios
import kotlinx.android.synthetic.main.fragment_precios.view.*
import kotlinx.android.synthetic.main.lista_precios.view.*


class PreciosAdapter(private val lista: List<ListaPrecios>): RecyclerView.Adapter<PreciosAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lista_precios, parent, false)

        return ViewHolder(itemView)

    }

    override fun getItemCount() = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = lista[position]
        holder.precio.text = currentItem.precio
        holder.medicamento.text = currentItem.medicamento
        holder.direccion.text = currentItem.direccion
        holder.numero.text = currentItem.numero
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val medicamento: TextView = itemView.medicamento2
        val precio: TextView = itemView.precio2
        val direccion: TextView = itemView.direccion2
        val numero: TextView = itemView.numero2

    }

}