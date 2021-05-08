package com.example.week5activty2.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.week5activty2.R

class SeekBarFragment2 : Fragment() {

    companion object {
        fun newInstance() = SeekBarFragment2()
    }

    private lateinit var viewModel: SeekBarViewModel
    private var mSeekBar: SeekBar? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        val root: View = inflater.inflate(R.layout.main_fragment, container, false)
        mSeekBar =  root.findViewById<SeekBar>(R.id.seekBar)
        viewModel = ViewModelProvider(this).get(SeekBarViewModel::class.java)

        subscribeSeekBar()

        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        // TODO: Use the ViewModel
    }
    private fun subscribeSeekBar() {

        // Update the ViewModel when the SeekBar is changed.
        mSeekBar!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    Log.d("Progress", "Progress changed!")
                    viewModel.seekbarValue.setValue(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        // Update the SeekBar when the ViewModel is changed.
        viewModel.seekbarValue.observe(
            requireActivity(), Observer<Int?> { value ->
                if (value != null) {
                    mSeekBar!!.progress = value
                    Log.d("ViewModel", "View Model Changed!")
                }
            })
    }

}