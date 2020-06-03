package com.example.appit.myapplication.trees

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.appit.myapplication.R
import kotlinx.android.synthetic.main.fragment_blue_child.*


class BlueChildFragment : Fragment() {

    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blue_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        btnComplete.setOnClickListener {
            val name = inputEdtName.text.toString()
            var action =
                    BlueChildFragmentDirections.actionBlueChildFragmentToCompleteTreeFragment(message = name,user = User("","",""))
            navController.navigate(action)
        }
        setUpToolbar()
    }

    private fun setUpToolbar() {
        toolbarBlueChild.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.colorBlueDark))
        toolbarBlueChild.title = getString(R.string.blue_child_fragment)
        toolbarBlueChild.setTitleTextColor(ContextCompat.getColor(requireContext(),R.color.colorWhite))
        toolbarBlueChild.navigationIcon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_arrow_back)
        toolbarBlueChild.setNavigationOnClickListener {
              navController.navigateUp()

        }
    }






}
