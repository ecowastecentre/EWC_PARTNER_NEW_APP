package com.example.bottomnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class SchedulePickupDetail : AppCompatActivity() {

    /*private lateinit var rescheduleDateTime: Button*/
    private lateinit var completePickup: Button
    private lateinit var cancelPickUp: Button
    private lateinit var rescheduleDateTime: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_pickup_detail)

/*        rescheduleDateTime= findViewById(R.id.rescheduleDateTime)
        rescheduleDateTime.setOnClickListener{
            val intent = Intent(this, ReschedulePickUp::class.java)
            startActivity(intent)
            finish()
        }*/

        rescheduleDateTime= findViewById(R.id.rescheduleDateTime)
        rescheduleDateTime.setOnClickListener{
            val intent = Intent(this, ReschedulePickUp::class.java)
            startActivity(intent)
            finish()
        }

        completePickup= findViewById(R.id.completePickup)
        completePickup.setOnClickListener{
            val intent = Intent(this, fillActualUponCompleting::class.java)
            startActivity(intent)
            finish()
        }

        cancelPickUp= findViewById(R.id.cancelPickUp)
        cancelPickUp.setOnClickListener{
            val intent = Intent(this, CancelPickUp::class.java)
            startActivity(intent)
            finish()
        }
    }
}