package com.example.bottomnavigation.ui.notifications

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
import com.example.bottomnavigation.CompletedPickUpDetail
import com.example.bottomnavigation.R
import com.example.bottomnavigation.SchedulePickupDetail
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var base_cardviewcompleted1: CardView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
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