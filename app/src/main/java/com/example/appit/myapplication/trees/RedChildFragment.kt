package com.example.appit.myapplication.trees

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.appit.myapplication.R
import kotlinx.android.synthetic.main.fragment_green_child.*
import kotlinx.android.synthetic.main.fragment_green_tree.*
import kotlinx.android.synthetic.main.fragment_red_child.*
import kotlinx.android.synthetic.main.fragment_red_child.btnComplete


class RedChildFragment : Fragment() {

    private val TAG = RedChildFragment::class.java.name

    lateinit var navController:NavController;

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            Toast.makeText(activity,"called",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_red_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        btnComplete.setOnClickListener {
            navController.navigate(R.id.action_redChildFragment_to_completeTreeFragment)
        }

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            Log.i(TAG,"destination is----"+destination)

        }
        setUpToolbar()

        btnNavGraph.setOnClickListener {
            navController.navigate(RedChildFragmentDirections.actionRedChildFragmentToOrangeTreeFragment())
        }
    }

    private fun setUpToolbar() {
        toolbarRedChild.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.colorRedDark))
        toolbarRedChild.title = getString(R.string.red_child_fragment)
        toolbarRedChild.setTitleTextColor(ContextCompat.getColor(requireContext(),R.color.colorWhite))
        toolbarRedChild.navigationIcon = ContextCompat.getDrawable(requireContext(),R.drawable.ic_arrow_back)
        toolbarRedChild.setNavigationOnClickListener {
            navController.navigateUp()

        }
    }





}
