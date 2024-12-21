package com.a1developers.bewakoof

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.a1developers.bewakoof.databinding.ActivityWelcomeScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class WelcomeScreen : AppCompatActivity() {

    private val binding: ActivityWelcomeScreenBinding by lazy {
        ActivityWelcomeScreenBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth



    override fun onStart() {
        super.onStart()

        val currentuser: FirebaseUser? = auth.currentUser
        if (currentuser != null){
            startActivity(Intent(this@WelcomeScreen,MainActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val textview = findViewById<TextView>(R.id.tc)

//        val text1 = SpannableString("By Creating an account or logging in,you agree with Bewakoof®'s Terms and Conditions and Privacy Policy")
//        text1.setSpan(ForegroundColorSpan(Color.BLUE), 0, text1.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        textview.setText(text1)
      binding.apply {

          binding.letsgetstarted.setOnClickListener{
              startActivity(Intent(this@WelcomeScreen,Login::class.java))
//              finish()
          }
      }

}}