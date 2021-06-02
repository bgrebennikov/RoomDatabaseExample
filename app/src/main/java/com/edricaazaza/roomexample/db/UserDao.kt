package com.edricaazaza.roomexample.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAll(): LiveData<List<UserModel>>

    @Insert
    fun insert(user: UserModel)

    @Delete
    fun removeUser(user: UserModel)

    @Query("DELETE FROM users")
    fun removeAll()

   @Update
    fun update(user: UserModel)




}