package com.example.bottomnavigation.ui.completed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.bottomnavigation.CompletedPickUpDetail
import com.example.bottomnavigation.R

class CompletedFragment : Fragment() {

    private lateinit var completedViewModel: CompletedViewModel
    private lateinit var base_cardviewcompleted1: CardView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        completedViewModel =
            ViewModelProviders.of(this).get(CompletedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_completed, container, false)
      /*  val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        base_cardviewcompleted1 = root.findViewById(R.id.base_cardviewcompleted1)
        base_cardviewcompleted1.setOnClickListener{

            val intent = Intent(activity, CompletedPickUpDetail::class.java)
            startActivity(intent)
            activity?.finishAffinity()
        }


        return root
    }
}