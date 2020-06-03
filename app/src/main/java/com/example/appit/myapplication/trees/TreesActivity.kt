package com.example.appit.myapplication.trees

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.navigation.ActivityNavigatorExtras
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appit.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_trees.*

class TreesActivity : AppCompatActivity() {

    lateinit var navController:NavController
    private val TAG = TreesActivity::class.java.name
    lateinit var listener:NavController.OnDestinationChangedListener;
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trees)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        navController = Navigation.findNavController(this,R.id.fragment)


        bottomNavigationView.setBackgroundColor(getColor(R.color.colorPrimaryDark))
        NavigationUI.setupWithNavController(bottomNavigationView,navController)



        //  val appBarConfiguration = AppBarConfiguration(setOf(R.id.blueTreeFragment,R.id.greenTreeFragment,R.id.redTreeFragment))
      //  setupActionBarWithNavController(navController,appBarConfiguration)


        setupColors()

    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun setupColors() {
        listener =  NavController.OnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id) {
                R.id.blueTreeFragment -> {
                    bottomNavigationView.setBackgroundColor(getColor(R.color.colorBlueDark))
                    window.statusBarColor = resources.getColor(R.color.colorBlueDark)
                }
                R.id.greenTreeFragment -> {
                    bottomNavigationView.setBackgroundColor(getColor(R.color.colorGreenDark))
                    window.statusBarColor = resources.getColor(R.color.colorGreenDark)

                }
                R.id.redTreeFragment -> {
                    bottomNavigationView.setBackgroundColor(getColor(R.color.colorRedDark))
                    window.statusBarColor = resources.getColor(R.color.colorRedDark)


                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onStop() {
        super.onStop()
        navController.addOnDestinationChangedListener(listener)
    }


    override fun onSupportNavigateUp(): Boolean {
        Log.i("tag","current destination id---"+navController.currentDestination?.id)
        navController.navigateUp()
        return super.onSupportNavigateUp()
    }
}
