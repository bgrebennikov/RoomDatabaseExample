package com.edricaazaza.roomexample.db

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Repository(private val userDao: UserDao) {
    val allUsers :LiveData<List<UserModel>> = userDao.getAll()

    suspend fun insert(user: UserModel){
        CoroutineScope(IO).launch {
            userDao.insert(user)
        }
    }

    suspend fun removeAll(){
        CoroutineScope(IO).launch {
            userDao.removeAll()
        }
    }

    suspend fun update(user: UserModel){
        CoroutineScope(IO).launch {
            userDao.update(user)
        }
    }

}