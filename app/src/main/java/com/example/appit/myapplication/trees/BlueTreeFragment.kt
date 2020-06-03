package com.example.appit.myapplication.trees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.appit.myapplication.R
import kotlinx.android.synthetic.main.fragment_blue_tree.*


class BlueTreeFragment : Fragment() {

    lateinit var navController: NavController;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blue_tree, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnBlue.setOnClickListener {
            navController.navigate(R.id.action_blueTreeFragment_to_blueChildFragment)
        }
        setUpToolbar()


    }
    private fun setUpToolbar() {
        blueToolbar.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.colorBlueDark))
        blueToolbar.title = getString(R.string.blue_fragment)
        blueToolbar.setTitleTextColor(ContextCompat.getColor(requireContext(),R.color.colorWhite))

    }
}
