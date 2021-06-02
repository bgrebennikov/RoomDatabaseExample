package com.edricaazaza.roomexample.fragmets

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.edricaazaza.roomexample.MainActivity
import com.edricaazaza.roomexample.R
import com.edricaazaza.roomexample.adapters.UsersAdapter
import com.edricaazaza.roomexample.databinding.FragmentListUsersBinding
import com.edricaazaza.roomexample.db.UserModel
import com.edricaazaza.roomexample.helper.showToast
import com.edricaazaza.roomexample.viewModels.MainViewModel

class ListUsersFragment : Fragment(R.layout.fragment_list_users) {

    private lateinit var viewBinding: FragmentListUsersBinding
    private lateinit var mainViewModel: MainViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentListUsersBinding.bind(view)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setHasOptionsMenu(true)
    }

    override fun onStart() {
        super.onStart()
        initUsersList()

        viewBinding.fab.setOnClickListener{
            findNavController().navigate(R.id.action_listUsersFragment_to_addUserFragment)
        }

        (activity as MainActivity).mainToolbar.title = "Users List"
    }

    private fun initUsersList(){
        viewBinding.usersListRecyclerView.layoutManager = LinearLayoutManager(context)

        mainViewModel.allUsers.observe(this, Observer {
            viewBinding.usersListRecyclerView.adapter = UsersAdapter(it.reversed()) { userModel -> onUserSelected(userModel) }
        })
    }

    private fun onUserSelected(user: UserModel){

        val bundle = Bundle()
        bundle.putString("firstname", user.firstName)
        bundle.putString("lastname", user.lastName)
        bundle.putLong("uid", user.uid.toLong())



        findNavController().navigate(R.id.action_listUsersFragment_to_detailUserFragment, bundle)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_users_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.appbar_remove_all_users -> {
                mainViewModel.removeAll()
                showToast("Users Removed")
            }
        }

        return super.onOptionsItemSelected(item)
    }

}