package com.example.yumyum.view.main

import android.R.attr.password
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityLoginBinding
import com.example.yumyum.databinding.ActivityRegisterBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth;
    private lateinit var binding: ActivityRegisterBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance();
        binding = ActivityRegisterBinding.inflate(layoutInflater);
        val view = binding.root
        setContentView(view)
        initData();
    }
    private fun initData(){
        auth = FirebaseAuth.getInstance();
        clickListener();
    }

    private fun clickListener(){
        binding.registerButton.setOnClickListener {
            createUser();
        }
        binding.signInButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun createUser() {

        var email = binding.emailEditText.text.toString()
        var password = binding.passwordEditText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            //save User Info
            saveUser(email, password);

        }else{
            Toast.makeText(this, "Veuillez renseignier les champs", Toast.LENGTH_LONG).show()

        }
    }

    private fun saveUser(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {

                checkResults(it.isSuccessful);

            }
    }

    private fun checkResults(isSuccess: Boolean) {
        if(isSuccess) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }else{
            Toast.makeText(this, "Account not create", Toast.LENGTH_LONG).show()
        }
    }

}