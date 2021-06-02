package com.edricaazaza.roomexample.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.edricaazaza.roomexample.MainActivity
import com.edricaazaza.roomexample.R
import com.edricaazaza.roomexample.databinding.FragmentDetailUserBinding
import com.edricaazaza.roomexample.db.UserModel
import com.edricaazaza.roomexample.helper.AppTextWatcher
import com.edricaazaza.roomexample.helper.showToast
import com.edricaazaza.roomexample.viewModels.MainViewModel

class DetailUserFragment : Fragment(R.layout.fragment_detail_user) {

    private lateinit var viewBinding: FragmentDetailUserBinding
    private lateinit var mainViewModel: MainViewModel

    private lateinit var firstname:String
    private lateinit var lastname:String
    private lateinit var uid:String



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding = FragmentDetailUserBinding.bind(view)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        firstname = arguments?.getString("firstname").toString()
        lastname = arguments?.getString("lastname").toString()
        uid = arguments?.getLong("uid").toString()
    }

    override fun onStart() {
        super.onStart()

        (activity as MainActivity).mainToolbar.title = "Update this user"
        viewBinding.updateFirstname.hint = firstname
        viewBinding.updateLastname.hint = lastname

        initInputs()

        viewBinding.updateBtn.setOnClickListener {
            findNavController().navigateUp()
            updateUser()
        }

    }

    private fun updateUser(){
        mainViewModel.update(UserModel(
            uid.toInt(),
            firstname,
            lastname
        ))
    }

    private fun initInputs(){
        viewBinding.updateFirstname.addTextChangedListener(AppTextWatcher {
            firstname = it.toString()
        })

        viewBinding.updateLastname.addTextChangedListener(AppTextWatcher {
            lastname = it.toString()
        })
    }




}