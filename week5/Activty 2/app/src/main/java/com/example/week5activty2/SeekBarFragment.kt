package com.example.week5activty2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week5activty2.ui.main.SeekBarFragment2

class SeekBarFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seek_bar_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SeekBarFragment2.newInstance())
                .commitNow()
        }
    }
}