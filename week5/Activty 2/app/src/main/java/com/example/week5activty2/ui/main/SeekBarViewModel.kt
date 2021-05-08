package com.example.week5activty2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeekBarViewModel : ViewModel() {
    var seekbarValue = MutableLiveData<Int>()
}