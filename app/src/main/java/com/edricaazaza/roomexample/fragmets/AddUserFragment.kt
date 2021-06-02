package com.edricaazaza.roomexample.fragmets

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.edricaazaza.roomexample.MainActivity
import com.edricaazaza.roomexample.R
import com.edricaazaza.roomexample.databinding.FragmentAddUserBinding
import com.edricaazaza.roomexample.db.UserModel
import com.edricaazaza.roomexample.helper.showToast
import com.edricaazaza.roomexample.viewModels.MainViewModel


class AddUserFragment : Fragment(R.layout.fragment_add_user) {

    private lateinit var viewBinding: FragmentAddUserBinding
    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentAddUserBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


    }

    override fun onStart() {
        super.onStart()
        (activity as MainActivity).mainToolbar.title = "Add User"

        viewBinding.saveBtn.setOnClickListener {
            findNavController().navigateUp()
            saveBtnHandler()
        }

    }

    private fun saveBtnHandler(){
        val firstName:String = viewBinding.firstNameTxt.text.toString()
        val lastName:String = viewBinding.lastNameTxt.text.toString()

        if (validateData(firstName, lastName)){
            saveUserToDatabase(firstName, lastName)
        } else{
            showToast("All fields required")
        }

    }

    private fun saveUserToDatabase(f: String, l: String){
        viewModel.insert(
            UserModel(
                0,
                f,
                l
            )
        )
        showToast("User Created!")
    }

    private fun validateData(f:String, l:String):Boolean{
        return !(f.isEmpty() || l.isEmpty())
    }


}