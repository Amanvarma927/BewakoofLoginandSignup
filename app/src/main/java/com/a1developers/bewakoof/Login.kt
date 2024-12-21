package com.a1developers.bewakoof

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.a1developers.bewakoof.databinding.ActivityLoginBinding
import com.a1developers.bewakoof.databinding.ActivityMainBinding

class Login : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)



        binding.apply {

            continueemail.setOnClickListener {
                startActivity(Intent(this@Login,Email::class.java))



            }
        }
    }
}