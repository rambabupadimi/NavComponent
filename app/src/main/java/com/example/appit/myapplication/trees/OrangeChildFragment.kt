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
import kotlinx.android.synthetic.main.fragment_orange_child.*
import kotlinx.android.synthetic.main.fragment_orange_tree.*
import kotlinx.android.synthetic.main.fragment_orange_tree.toolbarOrangeChild


class OrangeChildFragment : Fragment() {

    lateinit var navController: NavController;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orange_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        setUpToolbar()

        btnFinish.setOnClickListener {
            navController.navigate(R.id.action_orangeChildFragment_to_redTreeFragment)
        }

    }

    private fun setUpToolbar() {
        toolbarOrangeChild.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.colorRedDark))
        toolbarOrangeChild.title = getString(R.string.orange_child_fragment)
        toolbarOrangeChild.setTitleTextColor(ContextCompat.getColor(requireContext(),R.color.colorWhite))
        toolbarOrangeChild.navigationIcon = ContextCompat.getDrawable(requireContext(),R.drawable.ic_arrow_back)
        toolbarOrangeChild.setNavigationOnClickListener {
            navController.navigateUp()

        }
    }

}
