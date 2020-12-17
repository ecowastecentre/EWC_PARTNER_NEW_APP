package com.example.bottomnavigation.ui.newpickup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.bottomnavigation.NewPickUpDetail
import com.example.bottomnavigation.R
import com.example.bottomnavigation.ui.newpickup.NewpickupViewModel

class NewpickupFragment : Fragment() {

    private lateinit var newpickupViewModel: NewpickupViewModel
    private lateinit var base_cardview1: CardView

     override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root: View? = null
        newpickupViewModel =
            ViewModelProviders.of(this).get(NewpickupViewModel::class.java)
         root = inflater.inflate(R.layout.fragment_newpickup, container, false)
       /* val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        base_cardview1 = root.findViewById(R.id.base_cardview1)
        base_cardview1.setOnClickListener{

            val intent = Intent(activity, NewPickUpDetail::class.java)
            startActivity(intent)
            activity?.finishAffinity()
        }
        return root
    }
}