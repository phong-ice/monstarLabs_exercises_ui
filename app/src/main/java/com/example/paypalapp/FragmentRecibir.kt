package com.example.paypalapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paypalapp.adapter.AdapterActividad
import com.example.paypalapp.adapter.AdapterPerson
import com.example.paypalapp.databinding.FragmentRecibirBinding
import com.example.paypalapp.model.Actividad
import com.example.paypalapp.model.Person

class FragmentRecibir : Fragment() {

    private lateinit var _binding: FragmentRecibirBinding
    private lateinit var persons: ArrayList<Person>
    private lateinit var actividads: ArrayList<Actividad>
    private lateinit var adapterPerson: AdapterPerson
    private lateinit var adapterActividad:AdapterActividad

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecibirBinding.inflate(inflater, container, false)
        val view = _binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataTeaser()

        adapterPerson = AdapterPerson(requireContext(), persons)
        adapterActividad = AdapterActividad(requireContext(),actividads)

        _binding.lvEnviar.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterPerson
        }
        _binding.lvActividad.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterActividad
        }

        _binding.btnHoy.setOnClickListener {
            startActivity(Intent(requireContext(),PayActivity::class.java))
        }

    }

    private fun getDataTeaser() {
        persons = arrayListOf()
        actividads = arrayListOf()
        var person1 = Person(1, "Carlos Roca", R.mipmap.bitmap_copy)
        var person2 = Person(2, "Ruby Sanz", R.mipmap.bitmap_copy_3)
        var person3 = Person(3, "Mary Rich", R.mipmap.bitmap_copy_4)
        var person4 = Person(4, "CJosé Porto", R.mipmap.bitmap_copy)
        persons.add(person1)
        persons.add(person2)
        persons.add(person3)
        persons.add(person4)

        var actividad1 = Actividad(1, "El corte inglés", "Pago aceptado", -50)
        var actividad2 = Actividad(1, "Maria Lujan", "Pago aceptado", 650)
        var actividad3 = Actividad(1, "Pago aceptado", "Pago aceptado", 250)
        actividads.add(actividad1)
        actividads.add(actividad2)
        actividads.add(actividad3)
    }

}