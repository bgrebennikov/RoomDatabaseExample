package com.edricaazaza.roomexample.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserModel(
        @PrimaryKey(autoGenerate = true)
        val uid: Int,

        @ColumnInfo(name = "first_name")
        val firstName:String,

        @ColumnInfo(name = "last_name")
        val lastName:String?

)