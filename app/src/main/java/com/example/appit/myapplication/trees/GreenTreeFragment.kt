package com.example.appit.myapplication.trees

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.appit.myapplication.R
import kotlinx.android.synthetic.main.fragment_blue_tree.*
import kotlinx.android.synthetic.main.fragment_green_tree.*

class GreenTreeFragment : Fragment() {

    lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_green_tree, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btnGreen.setOnClickListener {
            navController.navigate(R.id.action_greenTreeFragment_to_greenChildFragment)
        }
        setUpToolbar()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_green_fragment,menu)
        super.onCreateOptionsMenu(menu, inflater)

    }
    private fun setUpToolbar() {
        greenToolbar.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.colorGreenDark))
        greenToolbar.title = getString(R.string.green_fragment)
        greenToolbar.setTitleTextColor(ContextCompat.getColor(requireContext(),R.color.colorWhite))
        (activity as AppCompatActivity?)!!.setSupportActionBar(greenToolbar)

    }
}
