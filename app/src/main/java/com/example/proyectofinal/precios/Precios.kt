package com.example.proyectofinal.precios
//referencias: https://medium.com/@info.anikdey003/kotlin-recyclerview-in-a-proper-and-re-usable-way-bb14717daa93

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinal.R
import com.example.proyectofinal.database.ListaPrecios
import com.example.proyectofinal.databinding.FragmentPreciosBinding
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_precios.*


/**
 * A simple [Fragment] subclass.
 */
class Precios : Fragment() {

    companion object {
        fun newInstance(): Precios = Precios()
        /*var TAG = Precios::class.java.simpleName
        const val ARG_POSITION: String = "positioin"

        fun newInstance(): Precios {
            var fragment = Precios();
            val args = Bundle()
            args.putInt(ARG_POSITION, 1)
            fragment.arguments = args
            return fragment
        */}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentPreciosBinding>(
            inflater,
            R.layout.fragment_precios, container, false)
        /*
        binding.siguiente2.setOnClickListener{
            // Write a message to the database

            // Write a message to the database
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("Precio")
            val farmacia = hashMapOf(
                "medicamento" to "Loratadina",
                "precio" to "130",
                "direccion" to "6A Avenida, Cdad. de Guatemala.",
                "numero" to "2422-2422")
            myRef.child("farmacia2").setValue(farmacia)
        }*/

        //RECYCLERVIEW
       /* rootView = inflater.inflate(R.layout.fragment_precios, container, false);
        initView()
        return rootView

*/
        setHasOptionsMenu(true)
        return binding.root
    }

    /*private fun initView() {
        initializeRecyclerView()
    }
    private fun initializeRecyclerView() {
        recyclerView =
            rootView.findViewById(R.id.recycler_view)
                recyclerView.layoutManager =
                    LinearLayoutManager(activity)
    }
*/
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.navdrawer_menu, menu)

    }
    private fun listaPrueba(size: Int): List<ListaPrecios> {
        val list = ArrayList<ListaPrecios>()
        for(i in 0 until size) {

            val item = ListaPrecios("lamictal", "200", "12 calle, zona 10, 6-36, apartamento santa maria.", "41577988")
            list += item
        }
        return list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PreciosAdapter(listaPrueba(12))
        }
    }

}
