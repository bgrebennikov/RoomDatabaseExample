package com.edricaazaza.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.edricaazaza.roomexample.databinding.ActivityMainBinding
import com.edricaazaza.roomexample.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainToolbar: Toolbar
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initToolbar()


    }

    override fun onStart() {
        super.onStart()

    }


    private fun initToolbar(){
        mainToolbar = viewBinding.mainToolbar
        setSupportActionBar(mainToolbar)
        mainToolbar.setupWithNavController(findNavController(R.id.fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragment).navigateUp()
    }


}