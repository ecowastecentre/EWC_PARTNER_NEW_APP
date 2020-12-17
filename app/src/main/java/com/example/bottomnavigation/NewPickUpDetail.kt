package com.example.bottomnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NewPickUpDetail : AppCompatActivity() {
    private lateinit var btnAccept: Button
    private lateinit var btnCancel: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pick_up_detail)

        btnAccept= findViewById(R.id.btnAccept)
        btnAccept.setOnClickListener{
            val intent = Intent(this, DateTimeSlot::class.java)
            startActivity(intent)
            finish()
        }


        btnCancel= findViewById(R.id.btnCancel)
        btnCancel.setOnClickListener{
            val intent = Intent(this, CancelPickUp::class.java)
            startActivity(intent)
            finish()
        }
    }
}