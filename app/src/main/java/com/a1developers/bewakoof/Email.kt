package com.a1developers.bewakoof

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.a1developers.bewakoof.databinding.ActivityEmailBinding
import com.a1developers.bewakoof.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Email : AppCompatActivity() {

    private val binding: ActivityEmailBinding by lazy {
        ActivityEmailBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()




        binding.apply {

        registerbtn.setOnClickListener {
            startActivity(Intent(this@Email, Registration::class.java))
        }
        }

        binding.loginbtn.setOnClickListener{
            val email= binding.email.text.toString()
            val password= binding.password.text.toString()


            if (email.isEmpty() || password.isEmpty()){

                Toast.makeText(this,"Please Enter All the Details", Toast.LENGTH_LONG).show()
            }else{
                auth.signInWithEmailAndPassword(email,password)

                    .addOnCompleteListener{task ->
                        if (task.isSuccessful){
                            Toast.makeText(this,"Logged In Successfully", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this,MainActivity::class.java))
                            finish()
                        }
                        else {
                            Toast.makeText(this,"Login Failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }

    }
}}}