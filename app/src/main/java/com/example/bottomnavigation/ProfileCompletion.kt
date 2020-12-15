package com.example.bottomnavigation

import android.content.Intent
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.bottomnavigation.ui.main.SectionsPagerAdapter

import com.example.bottomnavigation.ui.main.ProfileDetail

import kotlinx.android.synthetic.main.activity_profile_completion.*

class ProfileCompletion : AppCompatActivity() {


    private lateinit var btnSubmitForVerification: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_completion)


        val fragmentAdapter = ProfileDetail(supportFragmentManager)
        view_pager.adapter = fragmentAdapter

        tabs.setupWithViewPager(view_pager)
     /*   val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/

        btnSubmitForVerification= findViewById(R.id.btnSubmitForVerification)
        btnSubmitForVerification.setOnClickListener{
            val intent = Intent(this, ThankYou::class.java)
            startActivity(intent)
            finish()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}