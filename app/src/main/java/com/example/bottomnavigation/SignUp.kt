package com.example.bottomnavigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class SignUp : AppCompatActivity() {

    private lateinit var btnactualSignUp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnactualSignUp= findViewById(R.id.btnactualSignUp)
        btnactualSignUp.setOnClickListener{
            val intent = Intent(this, ProfileCompletion::class.java)
            startActivity(intent)
            finish()
        }

    }
}