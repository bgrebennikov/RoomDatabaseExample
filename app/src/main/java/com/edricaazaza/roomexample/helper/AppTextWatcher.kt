package com.edricaazaza.roomexample.helper

import android.text.Editable
import android.text.TextWatcher

class AppTextWatcher(val onSuccess : (CharSequence?) -> Unit): TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        onSuccess(s)
    }

    override fun afterTextChanged(s: Editable?) {

    }
}