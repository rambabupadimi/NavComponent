package com.example.appit.myapplication.trees

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

import com.example.appit.myapplication.R
import kotlinx.android.synthetic.main.fragment_complete_tree.*


class CompleteTreeFragment : Fragment() {

    lateinit var navController:NavController;
    private val TAG = CompleteTreeFragment::class.java.name

    val args: CompleteTreeFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_complete_tree, container, false)
    }


    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        when(navController?.previousBackStackEntry?.destination?.label) {
            "fragment_blue_child" -> {
                val name = args.message
                labelResult.text = "Hello $name"
            }
            "fragment_green_child" -> {
                var user = args.user
                labelResult.text = "Hello  ${user.name} / ${user.email}  /  ${user.phone}"
            }
            "fragment_red_child" -> {
            }
            else -> {
            }
        }

//        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true /* enabled by default */) {
//            override fun handleOnBackPressed() {
//         // back button override
//       //         navController.navigate(CompleteTreeFragmentDirections.actionCompleteTreeFragmentToBlueTreeFragment())
//            }
//        }
//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        Log.i(TAG,"nav graph --"+navController.graph)
        Log.i(TAG,"back stack --"+navController.backStack)
        Log.i(TAG,"current destination --"+navController.currentDestination)
        Log.i(TAG,"current back stack entry --"+navController.currentBackStackEntry?.destination?.displayName)
        Log.i(TAG,"previous back stack entry --"+navController.previousBackStackEntry?.destination?.displayName)
        Log.i(TAG,"current back stack entry navigation name--"+navController.currentBackStackEntry?.destination?.label)
        Log.i(TAG,"previous back stack entry navigation name --"+navController.previousBackStackEntry?.destination?.label)


        finish.setOnClickListener {
            when(navController?.previousBackStackEntry?.destination?.label) {
                "fragment_blue_child" -> {
                    navController.navigate(CompleteTreeFragmentDirections.actionCompleteTreeFragmentToBlueTreeFragment())
                }
                "fragment_green_child" -> {
                    navController.navigate(CompleteTreeFragmentDirections.actionCompleteTreeFragmentToGreenTreeFragment())
                }
                "fragment_red_child" -> {
                    navController.navigate(CompleteTreeFragmentDirections.actionCompleteTreeFragmentToRedTreeFragment())
                }
                else -> {
                    Log.i(TAG,"finish")
                }

            }

        }

    }





}
