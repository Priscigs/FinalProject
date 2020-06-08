package com.example.proyectofinal.fase1

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.FragmentFase1Binding
import com.example.proyectofinal.databinding.FragmentMainBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_fase1.*

/**
 * A simple [Fragment] subclass.
 */
class Fase1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentFase1Binding>(inflater,
            R.layout.fragment_fase1, container, false)

        binding.signUpButton.setOnClickListener {
            if (emailText.text.isNotEmpty() && passwordText.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword( emailText.text.toString(),
                    passwordText.text.toString()).addOnCompleteListener {

                    if (it.isSuccessful){
                        goToFase2()
                    }else {
                        mostrarError()
                    }

                }
            }
        }

        binding.lifecycleOwner = this
        setHasOptionsMenu(false)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.navdrawer_menu, menu)

    }

    private fun goToFase2(){
        view?.findNavController()?.navigate(R.id.action_fase1_to_fase2)
    }


    private fun mostrarError()
    {
        val constructor = AlertDialog.Builder(activity)
        constructor.setTitle("Error")
        constructor.setMessage("Se ha producido un error en el registro de usuario")
        constructor.setPositiveButton("Aceptar", null)
        val dialogo: AlertDialog = constructor.create()
        dialogo.show()
    }

}
