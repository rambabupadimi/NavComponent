package com.example.appit.myapplication.trees

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.appit.myapplication.R
import kotlinx.android.synthetic.main.fragment_blue_child.*
import kotlinx.android.synthetic.main.fragment_green_child.*
import kotlinx.android.synthetic.main.fragment_green_child.btnComplete


class GreenChildFragment : Fragment() {

    lateinit var navController: NavController
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_green_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        btnComplete.setOnClickListener {
            val user = User(inputName.text.toString(),
                            inputEmail.text.toString(),
                            inputPhone.text.toString())
            var action = GreenChildFragmentDirections.actionGreenChildFragmentToCompleteTreeFragment(message = "",user = user)
            navController.navigate(action)
        }
        setUpToolbar()
    }

    private fun setUpToolbar() {
        toolbarGreenChild.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.colorGreenDark))
        toolbarGreenChild.title = getString(R.string.green_child_fragment)
        toolbarGreenChild.setTitleTextColor(ContextCompat.getColor(requireContext(),R.color.colorWhite))
        toolbarGreenChild.navigationIcon = ContextCompat.getDrawable(requireContext(),R.drawable.ic_arrow_back)
        toolbarGreenChild.setNavigationOnClickListener {
            navController.navigateUp()

        }
    }

}
