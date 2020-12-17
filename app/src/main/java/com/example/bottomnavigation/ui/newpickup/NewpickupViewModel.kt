package com.example.bottomnavigation.ui.newpickup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewpickupViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is newpickup Fragment"
    }
    val text: LiveData<String> = _text
}