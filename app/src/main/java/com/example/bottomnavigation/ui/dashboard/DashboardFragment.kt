package com.example.bottomnavigation.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bottomnavigation.NewPickUpDetail
import com.example.bottomnavigation.R
import com.example.bottomnavigation.SchedulePickupDetail
import kotlinx.android.synthetic.main.fragment_newpickup.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var base_cardviewschedule1: CardView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
      /*  val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        }
        )*/

        base_cardviewschedule1 = root.findViewById(R.id.base_cardviewschedule1)
        base_cardviewschedule1.setOnClickListener{

            val intent = Intent(activity, SchedulePickupDetail::class.java)
            startActivity(intent)
            activity?.finishAffinity()
        }



        return root
    }
}