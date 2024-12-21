package com.a1developers.bewakoof

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.a1developers.bewakoof.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class Registration : AppCompatActivity() {


    private val binding: ActivityRegistrationBinding by lazy {
        ActivityRegistrationBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()



        binding.apply {

            registerlogin.setOnClickListener {
                startActivity(Intent(this@Registration,Email::class.java))
            }
        }



        binding.register.setOnClickListener{


            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val confirmpassword = binding.confirmpass.text.toString()


            //check if field is empty

            if (email.isEmpty()  || password.isEmpty() || confirmpassword.isEmpty()){

                Toast.makeText(this,"Please Fill All The Details", Toast.LENGTH_LONG).show()
            }
            else if (password != confirmpassword){

                Toast.makeText(this,"Confirm Password is wrong", Toast.LENGTH_LONG).show()
            }
            else{

                auth.createUserWithEmailAndPassword(email,password)

                    .addOnCompleteListener(this){task ->
                        if (task.isSuccessful){
                            Toast.makeText(this,"Registered Succesfully", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this,Email::class.java))
                        }
                        else{
                            Toast.makeText(this,"Registration Failed: ${task.exception?.message}",
                                Toast.LENGTH_LONG).show()
                        }
                    }
            }

        }


    }
}