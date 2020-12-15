package com.example.bottomnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    /*private lateinit var toolbar: Toolbar*/

    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: Button
    private lateinit var textViewForgotPassword: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*toolbar = findViewById(R.id.myToolBar)*/

        btnLogin= findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }

        btnSignUp= findViewById(R.id.btnSignUp)
        btnSignUp.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            finish()
        }

        textViewForgotPassword= findViewById(R.id.textViewForgotPassword)
        textViewForgotPassword.setOnClickListener{
            val intent = Intent(this, forgotpassword::class.java)
            startActivity(intent)
            finish()
        }

       /* setSupportActionBar(toolbar)*/
     }
}