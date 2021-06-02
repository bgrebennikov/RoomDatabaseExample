package com.edricaazaza.roomexample.helper

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment


public fun Fragment.showToast(text:String){
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}