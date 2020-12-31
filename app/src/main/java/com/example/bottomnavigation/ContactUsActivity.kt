package com.example.bottomnavigation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contact_us.*

class ContactUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        callUs.setOnClickListener(){
            var uri = Uri.parse("tel:7892841549")
            startActivity(Intent(Intent.ACTION_DIAL,uri))
        }
    }
}