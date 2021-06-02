package com.edricaazaza.roomexample.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.edricaazaza.roomexample.db.Database
import com.edricaazaza.roomexample.db.Repository
import com.edricaazaza.roomexample.db.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var repository :Repository
    val allUsers: LiveData<List<UserModel>>

    init {
        val dao = Database.getInstance(getApplication()).userDao()
        repository = Repository(dao)
        allUsers = repository.allUsers
    }

    fun insert(user: UserModel){
        viewModelScope.launch {
            repository.insert(user)
        }
    }

    fun removeAll(){
        viewModelScope.launch {
            repository.removeAll()
        }
    }

    fun update(user: UserModel){
        viewModelScope.launch {
            repository.update(user)
        }
    }







}