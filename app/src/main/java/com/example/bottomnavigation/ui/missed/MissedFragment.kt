package com.example.bottomnavigation.ui.missed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.bottomnavigation.R
import com.example.bottomnavigation.ui.completed.MissedViewModel

class MissedFragment : Fragment() {

    private lateinit var missedViewModel: MissedViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        missedViewModel =
            ViewModelProviders.of(this).get(MissedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_missed, container, false)
      /*  val textView: TextView = root.findViewById(R.id.text_notifications)
        missedViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }
}