package com.example.bottomnavigation


import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telecom.Call
import android.util.Base64
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.firebase.auth.FacebookAuthProvider
import java.util.*


class MainActivity : AppCompatActivity() {

    /*private lateinit var toolbar: Toolbar*/

    private  lateinit var mAuth : FirebaseAuth
    private lateinit var mGoogleSignInClient: GoogleSignInClient

    var callbackManager = CallbackManager.Factory.create()

    private lateinit var login_button: LoginButton
    val RC_SIGN_IN = 1000


    private lateinit var sign_in_button: SignInButton

    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: Button
    private lateinit var textViewForgotPassword: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*toolbar = findViewById(R.id.myToolBar)
        *  callbackManager = CallbackManager.Factory.create();*/




        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.


        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

          // Check for existing Google Sign In account, if the user is already signed in
         // the GoogleSignInAccount will be non-null.
        val account = GoogleSignIn.getLastSignedInAccount(this)

        // Set the dimensions of the sign-in button.


        sign_in_button = findViewById(R.id.sign_in_button)
      /* sign_in_button.setSize(sign_in_button.SIZE_STANDARD)*/

        sign_in_button.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            signIn()
        }


        //facebook
        login_button = findViewById(R.id.login_button)

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



    /*
       mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

      Handler().postDelayed({
            if (user != null) {
                val dashboardIntent = Intent(this, MainActivity2::class.java)
                startActivity(dashboardIntent)
            } else {
                val signInIntent = Intent(this, MainActivity::class.java)
                startActivity(signInIntent)
            }
        }, 2000)*/

       /* setSupportActionBar(toolbar)*/

      /*  printHashKey(this)*/
        login_button.setOnClickListener {
            facebookLogin()
        }
     }
    fun moveNextPage(){
        var currentUser = FirebaseAuth.getInstance().currentUser
        if(currentUser != null){
            startActivity(Intent(this,MainActivity2::class.java))
        }
    }
    fun facebookLogin(){
        /*LoginManager.getInstance().loginBehavior = LoginBehavior.WEB_VIEW_ONLY*/
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile","email"))
        LoginManager.getInstance().registerCallback(callbackManager,object : FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult?) {
                firebaseAuthWithFacebook(result)
            }

            override fun onCancel() {

            }

            override fun onError(error: FacebookException?) {

            }

        })
    }
    fun firebaseAuthWithFacebook(result: LoginResult?){
        var credential = FacebookAuthProvider.getCredential(result?.accessToken?.token!!)
        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener { task ->
            if(task.isSuccessful){
                moveNextPage()
            }
        }
    }

    private fun signIn() {
        val signInIntent = mGoogleSignInClient.signInIntent

        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val acct = GoogleSignIn.getLastSignedInAccount(this)
            if (acct != null) {
                val personName = acct.displayName
                val personGivenName = acct.givenName
                val personFamilyName = acct.familyName
                val personEmail = acct.email
                val personId = acct.id
                val personPhoto: Uri? = acct.photoUrl


                Toast.makeText(this, "User email :" + personEmail, Toast.LENGTH_SHORT).show()
            }
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

            // Signed in successfully, show authenticated UI.

        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.

         Log.d("TAG", "signInResult:failed code=" + e.getStatusCode())

        }
    }

   /* companion object {
        var RC_SIGN_IN :Int=100;
    }*/



}



