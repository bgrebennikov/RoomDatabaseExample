package com.edricaazaza.roomexample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.edricaazaza.roomexample.db.Database as DB


@Database(entities = [UserModel::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun userDao() : UserDao

    companion object{
        @Volatile
        private var instance: DB? = null

        fun getInstance(context: Context): DB{
            return instance ?: synchronized(this){
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context) : DB{
            return Room.databaseBuilder(context, DB::class.java, "local_db")
                    .fallbackToDestructiveMigration()
                    .build()
        }

    }


}